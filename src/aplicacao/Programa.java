package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemDePedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("DADOS DO CLIENTE: ");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();

		System.out.print("E-mail: ");
		String emailCliente = sc.nextLine();

		System.out.print("Data de nascimento (dd/mm/yyyy): ");
		Date dataNasc = sdf.parse(sc.next());

		Cliente cliente = new Cliente(nomeCliente, emailCliente, dataNasc);
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println("INFORME OS DADOS DO PEDIDO: ");
		System.out.println("Status do pedido: 1-PAGAMENTO_PENDENTE / 2-PROCESSANDO / 3-ENVIADO / 4-ENTREGUE");

		int opcao = sc.nextInt();
		String status = null;
		if (opcao == 1) {
			status = "PAGAMENTO_PENDENTE";
		} else if (opcao == 2) {
			status = "PROCESSANDO";
		} else if (opcao == 3) {
			status = "ENVIADO";
		} else if (opcao == 4) {
			status = "ENTREGUE";
		} else {
			System.out.println("OPÇÃO INVÁLIDA. SAINDO DO SISTEMA.");
			System.exit(0);
		}

		Pedido pedido = new Pedido(new Date(), StatusPedido.valueOf(status), cliente);

		System.out.println("Informe o número de itens para o pedido: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("DADOS DO ITEM #" + i + ": ");
			System.out.print("Nome: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();

			System.out.print("Preço (R$): ");
			double precoProduto = sc.nextDouble();

			System.out.print("Quantidade: ");
			int qtde = sc.nextInt();

			ItemDePedido itemPedido = new ItemDePedido(qtde, precoProduto, new Produto(nomeProduto, precoProduto));
			pedido.adicionarItem(itemPedido);

		}

		System.out.println("");
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println(pedido);

		sc.close();
	}

}

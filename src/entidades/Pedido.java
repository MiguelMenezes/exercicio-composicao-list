package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {

	private static final SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date dataPedido;
	private StatusPedido status;
	private Cliente cliente;

	private List<ItemDePedido> itens = new ArrayList<>();

	public Pedido() {

	}

	public Pedido(Date dataPedido, StatusPedido status, Cliente cliente) {
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemDePedido> getItens() {
		return itens;
	}

	public void adicionarItem(ItemDePedido item) {
		itens.add(item);
	}

	public void removerItem(ItemDePedido item) {
		itens.remove(item);
	}

	public double totalPedido() {

		double somaTotal = 0;
		for (ItemDePedido i : itens) {
			somaTotal += i.subTotal();
		}

		return somaTotal;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Data do pedido: ");
		sb.append(formatador.format(dataPedido) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido: \n");
		for (ItemDePedido p : itens) {
			sb.append(p + "\n");
		}
		sb.append("Preço total: R$");
		sb.append(String.format("%.2f", totalPedido()));

		return sb.toString();

	}

}

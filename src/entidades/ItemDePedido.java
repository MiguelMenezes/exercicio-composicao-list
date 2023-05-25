package entidades;

public class ItemDePedido {

	private Integer qtde;
	private Double preco;

	private Produto produto;

	public ItemDePedido() {

	}

	public ItemDePedido(Integer qtde, Double preco, Produto produto) {
		this.qtde = qtde;
		this.preco = preco;
		this.produto = produto;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public double subTotal() {
		return preco * qtde;
	}

}

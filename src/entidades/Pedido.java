package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {

	private Date dataPedido;
	private StatusPedido status;

	private List<ItemDePedido> itens = new ArrayList<>();

	public Pedido() {

	}

	public Pedido(Date dataPedido, StatusPedido status) {
		this.dataPedido = dataPedido;
		this.status = status;
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

}

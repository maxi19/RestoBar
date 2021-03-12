package com.restobar.dominio;

public class Menu implements Consumible {

	private int id;

	private String titulo;
	
	private int precio;
	
	private String plato;
	
	private String postre;
	
	private String bebida;
	

	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getPostre() {
		return postre;
	}

	public void setPostre(String postre) {
		this.postre = postre;
	}

	public String getBebida() {
		return bebida;
	}

	public void setBebida(String bebida) {
		this.bebida = bebida;
	}

	@Override
	public Pedido obtenerPedido() {
		
		Pedido pedido = new Pedido();
		pedido.setId(this.getId());
		pedido.setNombre(getTitulo());
		pedido.setImporte(getPrecio());
		return pedido;
	}



	
}

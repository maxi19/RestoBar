package com.restobar.dominio;

public class Menu {

	private String titulo;
	
	private int precio;
	
	private String plato;
	
	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	private String postre;
	
	private String bebida;

	private int id;
	
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
	public String toString() {
		return "Menu [titulo=" + titulo + ", precio=" + precio + ", postre=" + postre + ", bebida=" + bebida + "]";
	}
	
	
	
}

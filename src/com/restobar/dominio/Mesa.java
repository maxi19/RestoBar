package com.restobar.dominio;

import java.util.List;

public class Mesa {

	private String nombre;
	
	private Boolean estado;
	
	private String descripcion;

	private int numeroMesa;
	
	private int cantidadComensales;

	private List<Menu> menus ;
	
	public Mesa() {
		this.cantidadComensales=0;
	}
	public int getCantidadComensales() {
		return cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
	@Override
	public String toString() {
		return "Mesa [nombre=" + nombre + ", estado=" + estado + ", descripcion=" + descripcion + ", numeroMesa="
				+ numeroMesa + "]";
	}
	
	
}

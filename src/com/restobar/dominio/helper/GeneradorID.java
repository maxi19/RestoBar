package com.restobar.dominio.helper;

import java.time.LocalDate;
import java.time.LocalTime;

import com.restobar.dominio.Mesa;

public class GeneradorID {

	
	
	public String generarIdPedido(Mesa mesa, String id) {
		String  nombreMesa = mesa.getNombre().trim();
		String fecha = LocalDate.now().toString();
		String tiempo=LocalTime.now().toString();
		String clave = nombreMesa.concat("-").concat(fecha).concat("-").concat(tiempo).concat("-id :"+id);
		return clave;
	}
	
	
	
	
}

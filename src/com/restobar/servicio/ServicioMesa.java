package com.restobar.servicio;

import java.util.ArrayList;
import java.util.List;

import com.restobar.dominio.Mesa;
import com.restobar.excepciones.NotEncontroException;

public class ServicioMesa {

	private List<Mesa> mesas = new ArrayList<>();
	
	public ServicioMesa() {
		 Mesa mesa= new Mesa();
		  mesa.setEstado(false);
		  mesa.setNombre("MESA 1");
		  mesa.setDescripcion("mesa entrada derecha");
		  mesa.setNumeroMesa(1);
		  
		  Mesa mesa2= new Mesa();
		  mesa2.setEstado(false);
		  mesa2.setNombre("MESA 2");
		  mesa2.setDescripcion("mesa entrada izquierda");
		  mesa2.setNumeroMesa(2);
		  
		  Mesa mesa3= new Mesa();
		  mesa3.setEstado(false);
		  mesa3.setNombre("MESA 3");
		  mesa3.setDescripcion("mesa entrada frente");
		  mesa3.setNumeroMesa(3);
		  
		  mesas.add(mesa);
		  mesas.add(mesa2);
		  mesas.add(mesa3);
	}
	
	public Mesa dameMesa(int idMesa) throws NotEncontroException {
		boolean encontroMesa= false;
		
		for (Mesa mesa : mesas) {
			if (idMesa == mesa.getNumeroMesa()) {
				System.out.println(mesa.toString());
				encontroMesa = true;
				return mesa;
			}
		}
		
		if (encontroMesa == false) {
			throw new NotEncontroException("no encontro la mesa solicitada");
		}
		return null;
	}
	
	
	public List<Mesa> dameTodos(){
		return mesas;
	}
}

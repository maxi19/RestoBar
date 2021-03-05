package com.restobar.servicio;

import java.util.ArrayList;
import java.util.List;

import com.restobar.dominio.Menu;
import com.restobar.dominio.Mesa;
import com.restobar.excepciones.NotEncontroException;

public class ServicioMenu {

	private List<Menu> menus = new ArrayList<>();
	
	static {
		
	}
	
	public ServicioMenu() {
		Menu menu = new Menu();
		menu.setTitulo("Menu ejecutivo");
		menu.setPlato("tallarines con tuco");
		menu.setPostre("gelatina");
		menu.setBebida("cerveza tirada");
		menu.setPrecio(200);
		menu.setId(1);
		menus.add(menu);
		
		Menu menu2 = new Menu();
		menu2.setTitulo("Menu clasico");
		menu2.setPlato("sopa mani");
		menu2.setPostre("helado de canela");
		menu2.setBebida("chicha");
		menu2.setPrecio(100);
		menu2.setId(2);
		menus.add(menu2);
		
	}
	
	
	
	public Menu dameMesa(int idMenu) throws NotEncontroException {
		boolean encontro= false;
		
		for (Menu menu : menus) {
			if (idMenu == menu.getId()) {
				System.out.println(menu.toString());
				encontro = true;
				return menu;
			}
		}
		if (encontro == false) {
			throw new NotEncontroException("No se encontro el menu solicitado");
		}
		
		return null ;
	}
	
	
	public List<Menu> dameTodos(){
		return menus;
	}
}

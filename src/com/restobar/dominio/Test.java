package com.restobar.dominio;

import com.restobar.dominio.helper.GeneradorID;

public class Test {

	public static void main(String[] args) {
		GeneradorID g = new GeneradorID();

		Mesa mesa1 = new Mesa();	
		mesa1.setNombre("Mesa 1");
		
		System.out.println(g.generarIdPedido(mesa1,"1"));
		
		Mesa mesa2 = new Mesa();
		mesa2.setNombre("Mesa 2");
		System.out.println(g.generarIdPedido(mesa2,"2"));

	
	}

}

package com.restobar.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restobar.dominio.Menu;
import com.restobar.dominio.conexion.Conexion;
import com.restobar.excepciones.NotEncontroException;

public class ServicioMenu {

	private List<Menu> menus = new ArrayList<>();
	
	private Conexion conexion  = Conexion.getInstance(); 
	
	public ServicioMenu() {
	
	}
	
	public Menu dameMenu(int idMenu) throws NotEncontroException {
		Connection con =conexion.dameConnection();
		Menu menu = null ;
		try {
			PreparedStatement stmt = con.prepareStatement("Select Id, Titulo, Precio, Plato, Postre, Bebida from Menu where Id = "+idMenu);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {	
				menu = new Menu();
				menu.setId(Integer.parseInt(rs.getString("Id")));
				menu.setTitulo(rs.getString("Titulo"));
				menu.setPrecio(Integer.parseInt(rs.getString("Precio")));
				menu.setPlato( rs.getString("Plato") );
				menu.setPostre(rs.getString("Postre"));
				menu.setBebida(rs.getString("Bebida"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return menu ;
	}
	
	
	public List<Menu> dameTodos(){
		menus.clear();
		Connection con =conexion.dameConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("Select Id, Titulo, Precio, Plato, Postre, Bebida from Menu");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(Integer.parseInt(rs.getString("Id")));
				menu.setTitulo(rs.getString("Titulo"));
				menu.setPrecio(Integer.parseInt(rs.getString("Precio")));
				menu.setPlato( rs.getString("Plato") );
				menu.setPostre(rs.getString("Postre"));
				menu.setBebida(rs.getString("Bebida"));
				menus.add(menu);
			}
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}
}

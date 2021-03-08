package com.restobar.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restobar.dominio.Mesa;
import com.restobar.dominio.conexion.Conexion;
import com.restobar.excepciones.NotEncontroException;

public class ServicioMesa {

	private List<Mesa> mesas = new ArrayList<>();
	private Conexion conexion ; 
	
	public ServicioMesa() {
		conexion = new Conexion();
	}
	
	public Mesa dameMesa(int idMesa) throws NotEncontroException {
		boolean encontroMesa= false;
		Connection con =conexion.dameConnection();
		java.sql.Statement stmt;
		String query = "SELECT * FROM Mesa where Numero = " + String.valueOf(idMesa);
		Mesa mesa = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				mesa = new Mesa();
				mesa.setCantidadComensales(Integer.parseInt(rs.getString("CANTIDAD_COMENSALES")));
				mesa.setDescripcion(rs.getString("DESCRIPCION"));
				if ( "1".equals(rs.getString("ESTADO"))  ) {
					mesa.setEstado(true);
				}else {
					mesa.setEstado(false);
				}
				mesa.setNumeroMesa(Integer.parseInt(rs.getString("NUMERO")));
				mesa.setNombre(rs.getString("NOMBRE"));
			}
			stmt.close();
			con.close();
			return mesa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (encontroMesa == false) {
			throw new NotEncontroException("no encontro la mesa solicitada");
		}
		return null;
	}
	
	
	public List<Mesa> dameTodos(){
		mesas.clear();
		Connection con =conexion.dameConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("Select * from Mesa");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mesa mesa = new Mesa();
				mesa.setCantidadComensales(Integer.parseInt(rs.getString("CANTIDAD_COMENSALES")));
				mesa.setDescripcion(rs.getString("DESCRIPCION"));
				if ( "1".equals(rs.getString("ESTADO"))  ) {
					mesa.setEstado(true);
				}else {
					mesa.setEstado(false);
				}
				mesa.setNumeroMesa(Integer.parseInt(rs.getString("NUMERO")));
				mesa.setNombre(rs.getString("NOMBRE"));
				mesas.add(mesa);
			}
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mesas;
	}
	
	public boolean cambiarEstadoMesa(int idMesa){
		Connection con =conexion.dameConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM MESA where id = ?");
			stmt.setString(1, "1");
			int count = stmt.executeUpdate();
			if (count == 1) {
				return true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
}

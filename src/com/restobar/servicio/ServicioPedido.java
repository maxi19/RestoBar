package com.restobar.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.restobar.dominio.Pedido;
import com.restobar.dominio.conexion.Conexion;

public class ServicioPedido {

	private Conexion conexion  = Conexion.getInstance(); 
			
	public int agregarPedido(Pedido pedido) {
		Connection con = conexion.dameConnection();
		PreparedStatement stmt = null;
		try {
			
			stmt = con.prepareStatement("INSERT INTO Pedido (Codigo, Importe, Cantidad, Nombre) VALUES (?,?,?,?,?)");
			stmt.setString(1, pedido.getCodigo());
			stmt.setString(2, String.valueOf(pedido.getImporte()));
			stmt.setString(3, String.valueOf(pedido.getCantidad()));
			stmt.setString(4, pedido.getNombre());
			int row = stmt.executeUpdate();
			stmt.close();
			con.close();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				stmt.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return 0;
	}
	
	public List<Pedido> buscarPedidosPorCodigo(String codigo) {
		Connection con = conexion.dameConnection();
		List<Pedido> pedidos= null;
		PreparedStatement stmt = null;
		try {
			
			stmt = con.prepareStatement("SELECT Id, Codigo, Importe, Cantidad, Nombre FROM Pedido where Pedido.codigo = ?");
			stmt.setString(1, codigo);
			ResultSet rs = stmt.executeQuery();
			pedidos = new ArrayList<Pedido>();
			while (rs.next()) {
				Pedido p = new Pedido();
				p.setId(Integer.parseInt(rs.getString("Id")));
				p.setCodigo(rs.getString("Codigo"));
				p.setImporte(Integer.parseInt(rs.getString("Importe")));
				p.setCantidad(Integer.parseInt(rs.getString("Cantidad")));
				p.setNombre(rs.getString("Nombre"));
				pedidos.add(p);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				stmt.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return pedidos;		
	}
	
}

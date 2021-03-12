package com.restobar.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restobar.dominio.Menu;
import com.restobar.dominio.Mesa;
import com.restobar.dominio.Pedido;
import com.restobar.excepciones.NotEncontroException;
import com.restobar.servicio.ServicioMenu;
import com.restobar.servicio.ServicioMesa;

import jdk.nashorn.internal.runtime.RewriteException;

@WebServlet(urlPatterns = { "/carrito"})
public class CarritoServlet extends HttpServlet {

	
	private ServicioMenu servicioMenu = new ServicioMenu();
	private ServicioMesa servicioMesa = new ServicioMesa();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pedido-page.jsp");
		HttpSession misession= req.getSession(true);
		 
		String idMesa = req.getParameter("idMesa");
		String idMenu = req.getParameter("idMenu");
		List<Pedido> pedidos = null; 
		
		
		try {		
			Menu menu =servicioMenu.dameMenu(Integer.parseInt(idMenu));
			Pedido pedido = menu.obtenerPedido();
		
		pedidos = (List<Pedido>) misession.getAttribute("pedidos");
		if (pedidos == null ) {
			pedidos= new ArrayList<Pedido>();
		}
		pedidos.add(pedido);
		misession.setAttribute("pedidos", pedidos);

		dispatcher.forward(req, resp);
		} catch (Exception e) {
			
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 HttpSession misession= req.getSession(true);	
		List<Pedido> pedidos =null;
		 try {
			String cantidad =  req.getParameter("cantidadTxt");
			String idMenu = req.getParameter("idMenu");
			String idMesa = req.getParameter("idMesa");

			Menu menu =servicioMenu.dameMenu(Integer.parseInt(idMenu));
			Pedido pedido  =(Pedido) menu.obtenerPedido();
			pedido.setCantidad(Integer.parseInt(cantidad));
			pedido.setNombre(menu.getTitulo());
			
			 if ( misession.getAttribute("misPedidos") == null) {
				pedidos = new ArrayList<Pedido>();
			}else {
				pedidos	=(List<Pedido>) misession.getAttribute("misPedidos");
			}
			 
			pedidos.add(pedido);
				
			misession.setAttribute("misPedidos", pedidos);
			req.setAttribute("idMesa", idMesa);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pedido-page.jsp");
			 
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
		
	


	
	
}

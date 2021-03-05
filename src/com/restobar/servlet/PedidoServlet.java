package com.restobar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restobar.dominio.Mesa;
import com.restobar.servicio.ServicioMenu;

@WebServlet(urlPatterns = { "/cantidad"})
public class PedidoServlet extends HttpServlet {

	private ServicioMenu servicioMenu = new ServicioMenu();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher //
		= this.getServletContext().getRequestDispatcher("/WEB-INF/views/mesa.jsp");
	
		HttpSession misession= (HttpSession) req.getSession();
		 
		Mesa miMesaElegida= (Mesa) misession.getAttribute("miMesaElegida");
		 
		String  cantidad = req.getParameter("cantidad");
		
				
		 if (miMesaElegida !=null ) {
			 System.out.println("se envia " + miMesaElegida.toString());
			 req.setAttribute("mesaInfo", miMesaElegida);
			 req.setAttribute("menus", servicioMenu.dameTodos());
		}
		
		 dispatcher.forward(req, resp);	
		
	}

	
	
	
	
	
	
}

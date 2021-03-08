package com.restobar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restobar.dominio.Menu;
import com.restobar.dominio.Mesa;
import com.restobar.servicio.ServicioMenu;
import com.restobar.servicio.ServicioMesa;

@WebServlet(urlPatterns = { "/carrito"})
public class CarritoServlet extends HttpServlet {

	
	private ServicioMenu servicioMenu = new ServicioMenu();
	private ServicioMesa servicioMesa = new ServicioMesa();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 RequestDispatcher dispatcher 
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/menu.jsp");
		 dispatcher.forward(req, resp);
 
		
		String idMesa = req.getParameter("idMesa");
		String idMenu = req.getParameter("idMenu");
		
		try {
		Menu menu =	servicioMenu.dameMenu(Integer.parseInt(idMenu));
		Mesa mesa =	servicioMesa.dameMesa(Integer.parseInt(idMesa));
		mesa.getMenus().add(menu);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	}

		
	
	
	
	
	
}

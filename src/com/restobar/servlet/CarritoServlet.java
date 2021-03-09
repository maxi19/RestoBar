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
		 RequestDispatcher dispatcher  = null;

		String idMesa = req.getParameter("idMesa");
		String idMenu = req.getParameter("idMenu");
		String comensal = req.getParameter("comensal");
		
		int numeroComensal = Integer.parseInt(comensal);
		numeroComensal = numeroComensal - 1;
		if (numeroComensal == 0) {
			dispatcher	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
		} else {
			req.setAttribute("cantidadComensales", numeroComensal);
			req.setAttribute("menus", servicioMenu.dameTodos());
			try {
				req.setAttribute("mesaInfo", servicioMesa.dameMesa(Integer.parseInt(idMesa)));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotEncontroException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			dispatcher	= this.getServletContext().getRequestDispatcher("/WEB-INF/views/mesa.jsp");
		}
		 dispatcher.forward(req, resp);
	}

		
	
	
	
	
	
}

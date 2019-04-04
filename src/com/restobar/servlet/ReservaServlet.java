package com.restobar.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restobar.dominio.Mesa;
import com.restobar.excepciones.NotEncontroException;
import com.restobar.servicio.ServicioMenu;
import com.restobar.servicio.ServicioMesa;

@WebServlet(urlPatterns = { "/reserva"})
public class ReservaServlet extends HttpServlet {

	private ServicioMesa servicioMesa = new ServicioMesa();
	private ServicioMenu servicioMenu = new ServicioMenu();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Mesa mesa = null;
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/mesa.jsp");
		
		 if (req.getParameter("idMesa")!= null) {
			
			 int numeroMesa = 0;
			try {
				numeroMesa = Integer.parseInt(req.getParameter("idMesa"));
				mesa = servicioMesa.dameMesa(numeroMesa);
			} catch (NotEncontroException e) {
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
				req.setAttribute("titulo", "ERROR DE SISTEMA");
				req.setAttribute("mensaje", e.getMessage());
				dispatcher.forward(req, resp);
			}catch (NumberFormatException e1) {
				dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/error.jsp");
				req.setAttribute("titulo", "ERROR DE SISTEMA");
				req.setAttribute("mensaje", "Error de sistema interno. intente mas tarde");
				dispatcher.forward(req, resp);
			}
		}
		 if (mesa !=null ) {
			 System.out.println("se envia " + mesa.toString());
			 req.setAttribute("mesaInfo", mesa);
			 req.setAttribute("menus", servicioMenu.dameTodos());
			 dispatcher.forward(req, resp);	
		}
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("por post");
		super.doPost(req, resp);
	}

	
	
	
}

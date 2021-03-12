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
import com.restobar.dominio.helper.GeneradorID;
import com.restobar.excepciones.NotEncontroException;
import com.restobar.servicio.ServicioMenu;
import com.restobar.servicio.ServicioMesa;

@WebServlet(urlPatterns = { "/reserva"})
public class ReservaServlet extends HttpServlet {

	private ServicioMesa servicioMesa = new ServicioMesa();
	
	private GeneradorID generadorId = new GeneradorID();
	
	private ServicioMenu servicioMenu = new ServicioMenu();
	
private static final String INIT_PATH="/WEB-INF/views/";
	
	private static final String MESAS_PAGE ="mesas-disponibles-page.jsp";
	/**
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Mesa mesa = null;
		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/cartilla-servicio-page.jsp");
		 HttpSession misession= req.getSession(true);		
		 

			 int numeroMesa = 0;
		
			try {
				
				if (req.getParameter("idMesa") != null) {
					numeroMesa = Integer.parseInt(req.getParameter("idMesa"));		
					mesa = servicioMesa.dameMesa(numeroMesa);					
				}
				
				String idDePedido = generadorId.generarIdPedido(mesa, "1"); 
				
				req.setAttribute("mesaInfo", mesa);
				req.setAttribute("idPedido", idDePedido);
				req.setAttribute("idMesa", req.getParameter("idMesa"));
				req.setAttribute("menus", servicioMenu.dameTodos());
				misession.setAttribute("miMesaElegida", mesa);
				
			} catch (Exception e) {
				// TODO: handle exception
			
			}
				 dispatcher.forward(req, resp);	
	

	}
	
}

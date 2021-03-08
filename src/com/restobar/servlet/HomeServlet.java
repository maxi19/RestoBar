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

import com.restobar.dominio.Mesa;
import com.restobar.servicio.ServicioMesa;


@WebServlet(urlPatterns = { "/home"})
public class HomeServlet extends HttpServlet {

	private ServicioMesa servicioMesa = new ServicioMesa();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
		  req.setAttribute("mesas", servicioMesa.dameTodos());
		  dispatcher.forward(req, resp);
	}
	
}

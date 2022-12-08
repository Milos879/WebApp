package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.repository.PonudeRepository;

/**
 * Servlet implementation class ObrisiPonuduServlet
 */
@WebServlet("/obrisiPonudu")
public class ObrisiPonuduServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try {
				PonudeRepository pom =new PonudeRepository(DBConnection.getConnection());
				int id= Integer.parseInt(request.getParameter("id"));
		        pom.obrisiAktivnuPonudu(id);
		        response.sendRedirect("ponude.jsp");
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		
		
		
	}

	
}

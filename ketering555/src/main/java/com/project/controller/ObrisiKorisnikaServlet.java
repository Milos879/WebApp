package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.repository.KorisnikRepository;

/**
 * Servlet implementation class ObrisiKorisnikaServlet
 */
@WebServlet("/obrisi")
public class ObrisiKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try {
		int id= Integer.parseInt(request.getParameter("id"));
		
			KorisnikRepository kr= new KorisnikRepository(DBConnection.getConnection());
		    kr.deleteUser(id);
		    
		    
		    response.sendRedirect("sviKorisnici.jsp");
		    
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	
	
		
		
	}

	

}

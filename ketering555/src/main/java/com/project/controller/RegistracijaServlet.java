package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.model.Korisnik;
import com.project.repository.KorisnikRepository;

/**
 * Servlet implementation class RegistracijaServlet
 */
@WebServlet("/registracija")
public class RegistracijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	KorisnikRepository kor;
	try {
	
		kor = new KorisnikRepository(DBConnection.getConnection());
	
		
		
		if(kor.emailExists(request.getParameter("email"))){
			
			request.setAttribute("error", true);
		    request.getRequestDispatcher("registracija.jsp").forward(request, response);
		}else {
			
		
		
			    String name= request.getParameter("name");
			    String surname=request.getParameter("surname");
			    String email= request.getParameter("email");
			    String password= request.getParameter("password");
			    String role= request.getParameter("role");
			    String address=request.getParameter("address");
			    kor.createUser(new Korisnik(name,surname,password,email,role,address));
			    
			    response.sendRedirect("home.jsp");
		
		}
		
		
	
	
	} catch (Exception  e1) {
	e1.printStackTrace();
	}
	
	}
	
		
	
	
}

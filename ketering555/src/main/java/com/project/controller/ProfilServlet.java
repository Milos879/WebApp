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
 * Servlet implementation class ProfilServlet
 */
@WebServlet("/profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
		int id= Integer.parseInt(request.getParameter("id"));
		
			KorisnikRepository kr= new KorisnikRepository(DBConnection.getConnection());
		    kr.deleteUser(id);
		    
		    request.getSession().invalidate();
		    response.sendRedirect("home.jsp");
		    
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			KorisnikRepository kr= new KorisnikRepository(DBConnection.getConnection());
			Korisnik k=(Korisnik) request.getSession().getAttribute("auth");
		
			int id=k.getId();
			String name= request.getParameter("name");
			String surname= request.getParameter("surname");
			String address= request.getParameter("address");
			
			kr.updateUser(id, name, surname, address);
			
			
			
			k.setName(name);
			k.setAddress(address);
			k.setSurname(surname);
			
			response.sendRedirect("profil.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	
		
	}

}

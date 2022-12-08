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
 * Servlet implementation class PopustServlet
 */
@WebServlet("/popust")
public class PopustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String popust= request.getParameter("popust");	
		
     if(popust.equals("prvi")){
    	
    	 try {

        	 Korisnik k = (Korisnik)request.getSession().getAttribute("auth");
			 KorisnikRepository kr=new KorisnikRepository(DBConnection.getConnection());
			 kr.deleteDiscount(k.getId());
			 int id= Integer.parseInt(request.getParameter("id"));
	    	 k.setDiscount(0);
	    	
	    	 request.setAttribute("prviPopust", true);
    	    request.getRequestDispatcher("porudzbine.jsp").forward(request, response);
    	 } catch (Exception e) {
	        e.printStackTrace();
		} 
    	 
     }else if(popust.equals("kolicina")){
    	 request.setAttribute("popustKolicina", true);
    	 request.getSession().setAttribute("popustKolicina", true);
 	    request.getRequestDispatcher("porudzbine.jsp").forward(request, response);
     }
	
		

	}

}

package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.model.Cart;
import com.project.model.Korisnik;
import com.project.model.Porudzbina;
import com.project.repository.PorudzbinaRepository;

/**
 * Servlet implementation class PlatiServlet
 */
@WebServlet("/plati")
public class PlatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	try {
		PorudzbinaRepository pr= new PorudzbinaRepository(DBConnection.getConnection());
	
	
		ArrayList<Cart> cart= (ArrayList<Cart>)request.getSession().getAttribute("cartovi");	
		Korisnik k= (Korisnik)request.getSession().getAttribute("auth");
		
		
		for(Cart c: cart) {
		String datum= request.getParameter("datum"+c.getId()).toString();
		
		Porudzbina p =new Porudzbina();
		p.setAddress(k.getAddress());
	    p.setUser_id(k.getId());
		p.setPonuda_id(c.getId());
		p.setKolicina(c.getQuantity());
		p.setDatum(datum);
		p.setPrice(c.getPrice());
		
		
		pr.createPorduzbina(p);
		
		
		}
	
		request.getSession().removeAttribute("cartovi");
		request.getSession().removeAttribute("popustKolicina");
		response.sendRedirect("home.jsp");
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	
	}

}

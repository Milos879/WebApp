package com.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Cart;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
  int id=  Integer.parseInt(request.getParameter("id"));	
  List<Cart> cartovi=(ArrayList<Cart>)request.getSession().getAttribute("cartovi"); 
		
   
  for(Cart c : cartovi){
	  if(id==c.getId()){
		cartovi.remove(c);
		break;
		  
	  }
    
  }
  
  response.sendRedirect("cart.jsp");
	}

	

}

package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.model.Cart;
import com.project.repository.PonudeRepository;

/**
 * Servlet implementation class QuantityIncreDecreServlet
 */
@WebServlet("/quantity-incre-decre")
public class QuantityIncreDecreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		
        try {
			PonudeRepository productRep= new PonudeRepository(DBConnection.getConnection());
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			List<Cart> cartovi = (List<Cart>) request.getSession().getAttribute("cartovi");
        
        
        
			for (Cart c : cartovi) {

				if (action.equals("incre") && c.getId() == id) {
					c.setQuantity(c.getQuantity() + 1);
					break;
				} else if (action.equals("decre") && c.getId() == id && c.getQuantity() > 1) {
					c.setQuantity(c.getQuantity() - 1);
					break;
				}
			}
	        request.getSession().setAttribute("cartovi", productRep.getAllCart(cartovi));
			
			response.sendRedirect("cart.jsp");
        
        
        
        
        } catch (Exception e) {
			e.printStackTrace();
		}
		
        
        
        
	
	}

}

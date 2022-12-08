package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.model.Cart;
import com.project.model.Ponude;
import com.project.repository.PonudeRepository;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			if(request.getSession().getAttribute("auth")==null)
			{
				
				response.sendRedirect("login.jsp");
			}
			else {
				
				
				
				
				
				PonudeRepository prDao = null;
			prDao = new PonudeRepository(DBConnection.getConnection());

			ArrayList<Cart> cartovi = (ArrayList<Cart>) request.getSession().getAttribute("cartovi");
			int id = Integer.parseInt(request.getParameter("id"));

			
			
			
			
			if (cartovi == null) {

				cartovi = new ArrayList<>();
				Cart c = new Cart();
				c.setId(id);
				cartovi.add(c);
				request.getSession().setAttribute("cartovi", prDao.getAllCart(cartovi));
				request.getRequestDispatcher("cart.jsp").forward(request, response);

			} else {
				boolean postoji = false;
				for (Cart c : cartovi) {
					if (c.getId() == id)
						postoji = true;
				}
				if (!postoji) {
					Cart c = new Cart();
					c.setId(id);
					cartovi.add(c);

					request.getSession().setAttribute("cartovi", prDao.getAllCart(cartovi));
					response.sendRedirect("cart.jsp");
				}else {
					response.sendRedirect("cart.jsp");
				}

			}}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}

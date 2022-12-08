package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.config.DBConnection;
import com.project.model.Korisnik;
import com.project.repository.KorisnikRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect("login.jsp");
	}

	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			KorisnikRepository userR = new KorisnikRepository(DBConnection.getConnection());

			Korisnik user = userR.getUser(email, password);

			if (user != null) {
				request.getSession().setAttribute("auth", user);

				response.sendRedirect("home.jsp");

			} else {
                request.setAttribute("error", true);
                System.out.println("ovooo radi tr");
                request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

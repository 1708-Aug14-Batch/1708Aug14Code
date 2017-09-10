package com.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.DatabaseDao;
import com.bank.pojos.User;
import com.bank.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// Redirect
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		System.out.println(email + ' ' + password);
		
		if (!Service.hasUser(email) || password == null) {
			response.sendRedirect("error.html");
			return;
		}
		
		if (Service.loginUser(email, password) == null) {
			
			session.setAttribute("user", Service.getCurrentUser());
			request.getRequestDispatcher("success.html").forward(request, response);
			return;
		}
		else {
			session.setAttribute("message", "Incorrect password");
			request.getRequestDispatcher("fail.html").forward(request, response);
			return;
		}
	}
	
	private DatabaseDao dao = new DatabaseDao();
}

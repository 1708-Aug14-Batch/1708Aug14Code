package com.bank.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.DatabaseDao;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {
	
	/**
	 * KEH
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Redirect
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		System.out.println(email + ' ' + password);
		
		if (!Service.hasUser(email) || password == null) {
			response.sendRedirect("error.html");
			return;
		}
		
		if (Service.loginUser(email, password) == null) {
			response.sendRedirect("success.html");
			return;
		}
		else {
			response.sendRedirect("fail.html");
			return;
		}
	}
	
	private DatabaseDao dao = new DatabaseDao();
}

package com.servlets.SerHan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class AttemptLoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		System.out.println("Attempting Log in");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		Service ser = new Service();
		User u = ser.getUser(email, password);
		if(u != null) {
			ses.setAttribute("User", u);
			System.out.println("Forwarding to home");
			request.getRequestDispatcher("app.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("LoginFailed.html").forward(request, response);
		}
	}
	
	
}

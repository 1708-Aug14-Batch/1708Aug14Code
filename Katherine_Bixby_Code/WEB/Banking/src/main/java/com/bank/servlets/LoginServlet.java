package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet {

	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int id = service.validateUser(email);
		if(id < 0){
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("details", "That user does not exist!");
			rd.forward(request, response); // invalid user
		}
		else{
			User u = service.login(id, pass);
			if(u == null){
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				request.setAttribute("details", "Your email exists, but password is wrong!");
				rd.forward(request, response); // password is wrong 
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				request.setAttribute("username", email);
				rd.forward(request, response); // successful login
			}
		}
	}



}
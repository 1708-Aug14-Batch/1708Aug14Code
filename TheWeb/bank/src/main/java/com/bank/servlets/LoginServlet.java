package com.bank.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;
import com.google.gson.Gson;

public class LoginServlet extends HttpServlet {

	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();


		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int id = service.validateUser(email);
		if(id < 0){
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response); // invalid user
		}
		else{
			User u = service.login(id, pass);
			if(u == null){
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
				rd.forward(request, response); // password is wrong 
			}
			else{
				session.setAttribute("user", u);
				//String json = new Gson().toJson(u);
				RequestDispatcher rd = request.getRequestDispatcher("success.html");
				rd.forward(request, response); // successful login 	
			}
		}
	}




}

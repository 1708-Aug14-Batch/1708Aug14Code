package com.pone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pone.pojos.AUser;
import com.pone.service.Service;


public class LoginServlet extends HttpServlet {
	
	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//System.out.println(session);
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int id = service.validateUser(email);
		if(id < 0){
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response); // invalid user
		}
		else{
			AUser u = service.login(id, pass);
			if(u == null){
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
				rd.forward(request, response); // password is wrong 
			}
			else{
				if(u.getIsManager()==0) { // is not a manager
					RequestDispatcher rd = request.getRequestDispatcher("employeehome.html");
					session.setAttribute("auser", u);
					rd.forward(request, response); // successful login
				}
				else { // is a manager
					RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
					session.setAttribute("auser", u);
					rd.forward(request, response); // successful login
				}
			}
		}
	}



}
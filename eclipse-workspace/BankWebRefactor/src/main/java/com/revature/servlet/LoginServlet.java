package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.model.User;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private UserDAO<User> dao = new UserDAOImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = this.dao.readUser(request.getParameter("email"));
		if (user == null) {
			request.getRequestDispatcher("/bad_email.html").forward(request, response);
		} else if (!user.getPassword().equals(request.getParameter("password"))) {
				request.getRequestDispatcher("/bad_password.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/dashboard.html").forward(request, response);
			//request.getRequestDispatcher("/success.html").forward(request, response);
			//response.sendRedirect("http://www.youtube.com/");
		}
	}

}

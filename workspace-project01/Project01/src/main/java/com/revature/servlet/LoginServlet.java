/**
 * 
 */
package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.RUserDAO;
import com.revature.model.RUser;

/**
 * This servlet handles login requests
 * @author Will Underwood
 */
public class LoginServlet extends HttpServlet {
	
	private RUserDAO dao = new RUserDAO();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RUser user = this.dao.read(request.getParameter("email"));
		if (user == null) {
			request.getRequestDispatcher("/bad_email.html").forward(request, response);
		} else if (!user.getPassword().equals(request.getParameter("password"))) {
				request.getRequestDispatcher("/bad_password.html").forward(request, response);
		} else {
			response.sendRedirect("http://www.youtube.com/");
		}
	}

}

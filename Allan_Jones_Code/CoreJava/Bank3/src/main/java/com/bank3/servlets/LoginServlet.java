package com.bank3.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank3.pojos.User;
import com.bank3.service.Service;

public class LoginServlet extends HttpServlet {

	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int id = service.validateUser(username, password);
		if (id == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response); // invalid user
		} else {
			User u = service.getUser(id);
			session.setAttribute("user", u);
			
			String fn = (String) session.getAttribute(u.getFirstname());
			
			String uname = session.getAttribute("user").toString();
			
			System.out.println("The session username is: " + uname);
			
			System.out.println("forwarding to home");
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			rd.forward(request, response); // successful login
		}
	}
}

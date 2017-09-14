package com.project1.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.pojos.Users;
import com.project1.service.Service;

public class LoginServlet extends HttpServlet {

	static Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		int id = service.validateUser(username, password);
		if (id == -1) {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response); // invalid user
		}
		
		Users user = new Users();
		user = service.getUser(id);
		String name = user.getFirstName().toString() + " " + user.getLastName().toString();
		
		System.out.println("Name from loginServlet is: " + name);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("User", user);

		boolean isMgr = service.isMgr(id);
		if (isMgr) {
			RequestDispatcher rd = request.getRequestDispatcher("manager_homepage.html");
			rd.forward(request, response); // successful login
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("employee_homepage.html");
			rd.forward(request, response); // successful login
		}
	}
}

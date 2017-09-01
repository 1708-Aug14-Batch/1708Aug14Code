package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		writer.print("<h1>Welcome " + username + " !</h1>");
		
		// get param names if you don't know them
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			writer.println("<br>");
			String param = paramNames.nextElement();
			String value = request.getParameter(param);
			writer.println(param + ": " + value);
		}
	}
	
}

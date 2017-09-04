package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		out.print("<h1> Welcome " + name + "!</h1>");
	}
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		
		out.print("<h1> Welcome " + name + "!</h1>");
		
		//get param name
		Enumeration<String> paramName = request.getParameterNames();
		while (paramName.hasMoreElements()) {
			out.println("<br> Get parameter names <br>");
			String param = paramName.nextElement();
			String value = request.getParameter(param);
			out.println(param + ": " + value);
			
		}
}
	}
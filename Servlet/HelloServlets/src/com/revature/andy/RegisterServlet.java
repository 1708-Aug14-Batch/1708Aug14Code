package com.revature.andy;

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		out.println("<h1> WELCOME " + username + "!</h1>");
		out.println("<h1> WELCOME " + password + "!</h1>");
		
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		out.println("<h1> WELCOME " + username + "!</h1>");
		out.println("<h1> WELCOME " + password + "!</h1>");

		Enumeration<String> paramNames = req.getParameterNames();
		
		while(paramNames.hasMoreElements()) {
			out.println("<br/>");
			String param = paramNames.nextElement();
			String value = req.getParameter(param);
			
			out.println(param + ": " + value);
		}
		
	}
}

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
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = -1010239190672979207L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter p = resp.getWriter();
		
		String username = (String) req.getParameter("username");
		
		p.print("<h1>Welcome " + username + "!</h1>");
		
		Enumeration<String> paramNames = req.getParameterNames();
		
		while (paramNames.hasMoreElements()) {
			String param = paramNames.nextElement();
			String value = req.getParameter(param);
			p.println("<br/>" + param + " = " + value);
		}
		
		p.close();
	}
}

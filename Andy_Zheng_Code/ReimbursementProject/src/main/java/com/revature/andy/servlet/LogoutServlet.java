package com.revature.andy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//???
		// use anchor href or form button to refresh the page completely
		if(req.getSession(false)== null) {
			resp.sendRedirect("index.html");
		}
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.removeAttribute("User");
			session.invalidate();
		}
		
		resp.sendRedirect("index.html");
	}
	
}

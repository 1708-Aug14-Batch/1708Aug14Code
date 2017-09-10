package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("logging out");
		if(req.getSession(false) == null) {
			resp.sendRedirect("index.html");
		}
		
		HttpSession sesh = req.getSession(false);
		if(sesh != null) {
			sesh.removeAttribute("employee");
			sesh.invalidate();
			System.out.println("invalidated!");
		}
		resp.sendRedirect("index.html");
	}
}

package com.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession(false) == null) {
			System.out.println("Session Found null");
			resp.sendRedirect("partials/Login.html");
		}
		else {
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("user"));
		session.setAttribute("user", null);
		System.out.println(session.getAttribute("user"));
		session.invalidate();
		System.out.println(session.isNew());
		req.getRequestDispatcher("partials/Login.html").forward(req, resp);
		}
	}

}

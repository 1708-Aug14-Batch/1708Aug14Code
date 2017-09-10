package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(HomeServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.trace("in doGet");
		HttpSession session = request.getSession(false);
		if (session == null) {
			log.trace("session doesn't exist");
			response.sendRedirect("login");
			return;
		}
		else if (session.getAttribute("user") == null) {
			log.trace("user attribute doesn't exist in session");
			response.sendRedirect("login");
			return;
		}

		log.trace("session exists");
		request.getRequestDispatcher("home.html").forward(request, response);
	}
}

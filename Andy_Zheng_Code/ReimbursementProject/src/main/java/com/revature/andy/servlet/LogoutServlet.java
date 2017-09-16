package com.revature.andy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.andy.pojos.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	final static Logger log = Logger.getLogger(LogoutServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

		HttpSession session = req.getSession(false);
		log.debug("Current User\t" + (User) session.getAttribute("User"));
		if(session != null) {
			session.removeAttribute("User");
			session.invalidate();
		}
	}
}

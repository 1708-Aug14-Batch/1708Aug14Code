package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -6057117928413353392L;
	private static final Logger logger = Logger.getLogger(LogoutServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession() == null) {
			response.sendRedirect(response.encodeRedirectURL("login.html"));
		}
		HttpSession session = request.getSession();
		if(session != null){
			if(logger.isInfoEnabled()){
				logger.info("User logged out");
			}
			session.removeAttribute("user");
			session.invalidate();
		}
		response.sendRedirect(response.encodeRedirectURL("login.html"));
	}

}

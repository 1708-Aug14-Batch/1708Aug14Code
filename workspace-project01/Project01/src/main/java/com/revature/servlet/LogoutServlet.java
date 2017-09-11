package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = -6057117928413353392L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession() == null){
			response.sendRedirect(response.encodeRedirectURL("login.html"));
		}
		HttpSession session = request.getSession();
		if(session != null){
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("Session invalidated!");
		}
		response.sendRedirect(response.encodeRedirectURL("login.html"));
	}

}

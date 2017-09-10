package com.Servlets.SerHan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logging out User");
		if(request.getSession(false) == null) {
			response.sendRedirect("app.html"); //if no session go to login page
		}
		
		HttpSession ses = request.getSession(false);
		if(ses != null) {
			ses.removeAttribute("User");
			ses.invalidate();
			System.out.println("Session Invalidated");
		}
		response.sendRedirect("app.html");
	}
	
}

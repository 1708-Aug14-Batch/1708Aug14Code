package com.bank.servlets.oldcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.BankUser;
import com.bank.service.Service;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/main/login_action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("doGet in LoginServlet (does nothing)");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost in LoginServlet");
		
		String username = request.getParameter("username_input");
		String password = request.getParameter("password_input");

		Service bankService = new Service();
		if (bankService.isABankUser(username)) {
			BankUser user = bankService.validateBankUser(username, password);
			
			if (user != null) {	// Successful login
				
				// j_session_id stored in a cookie on the client's browser
				HttpSession session = request.getSession();
				// the parameters are the name, and the actual object that you
				// want to store in the session
				session.setAttribute("user", user);
				System.out.println("Login servlet, session set to: " + user);	// DEBUG
				
				response.sendRedirect("app.html");
			} else {	// Password was incorrect
				
				response.sendRedirect("badPassword.html");
			}
		} else {	// Username is not in system
			
			response.sendRedirect("badUsername.html");
		}

	}

}

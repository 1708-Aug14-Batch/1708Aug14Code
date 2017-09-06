package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

public class EditAccountInfoServlet extends HttpServlet {

	private Service runApp = new Service();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User tmp = (User)session.getAttribute("user");
		if (tmp == null) {
			System.out.println("No user in session...");
			response.sendRedirect("login.html");
			return;
		}
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pword = request.getParameter("pword");
		String pword_c = request.getParameter("pword_c");
		if (runApp.validateEmail(email) != null && tmp.getEmail().equals(email) == false) {
			System.out.println("Email is already taken...");
			response.sendRedirect("login.html");
			return;
		}
		else {
			if (pword.equals(pword_c)) {
				System.out.println("Changing info...");
				tmp.setFirstname(fname);
				tmp.setLastname(lname);
				tmp.setEmail(email);
				tmp.setPassword(pword);
				runApp.updateInfo(tmp);
				response.setContentType("text/html");
				synchronized(session) {
					session.setAttribute("user", tmp);
				}
				response.sendRedirect("employee.html");
				return;
			} else {
				System.out.println("You entered the wrong password...");
				response.sendRedirect("employee.html");
				return;
			}			
		}
		
	}
}

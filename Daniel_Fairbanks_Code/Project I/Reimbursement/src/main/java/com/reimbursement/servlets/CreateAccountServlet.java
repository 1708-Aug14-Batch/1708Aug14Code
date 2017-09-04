package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

public class CreateAccountServlet extends HttpServlet {

	private Service runApp = new Service();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String pword = request.getParameter("pword");
		String pword_c = request.getParameter("pword_c");
		boolean isMgr = request.getParameter("manager") != null;
		System.out.println("Hello, " + fname + " " + lname +". Manager: "+isMgr);
		System.out.println(pword + " : " + pword_c);
		
		User tmp = runApp.validateEmail(email);
		if (tmp != null) {
			System.out.println("Email is already taken...");
			response.sendRedirect("login.html");
			return;
		}
		if (!pword.equals(pword_c)) {
			System.out.println("Passwords don't match...");
			response.sendRedirect("login.html");
			return;
		}

		int id = runApp.registerEmployee(fname, lname, email, pword, isMgr);
		if (id != -1) {
			tmp = new User(id, fname, lname, email, pword, isMgr);
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			synchronized(session) {
				session.setAttribute("user", tmp);
			}
			if (tmp.getIsManager() == true) {
				System.out.println("You are a manager in the system!");
				response.sendRedirect("manager.html");
				return;
			} else {
				System.out.println("You are an employee in the system!");
				response.sendRedirect("employee.html");
				return;
			}
		}
	}
}

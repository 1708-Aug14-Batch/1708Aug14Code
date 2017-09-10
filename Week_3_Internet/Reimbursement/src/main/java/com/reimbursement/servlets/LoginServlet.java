package com.reimbursement.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

@WebServlet("/FrontDesk")
public class LoginServlet extends HttpServlet{
	
	Service service = new Service();
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("Begin the post");
		
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		boolean check = service.checkEmail(email);
		boolean passCheck = service.checkPassword(email,password);
		System.out.println(email);
		User u = service.loginUser(email);
		System.out.println("Logging user " + u.toString());
		if(check == true && passCheck == true) {
			if(u.getIsManager() == 0) {
			System.out.println("Logging user " + u.toString());
			session.setAttribute("user", u); //Use this to persist the data throughout the server
			// The parameter is the name, and the actual object.
			
			RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
			rd.forward(req, res);
			}
			else if(u.getIsManager() == 1) {

				session.setAttribute("user", u);//Use this to persist the data throughout the server
				// The parameter is the name, and the actual object.
				
				RequestDispatcher rd = req.getRequestDispatcher("ManagerHomePage.html");
				rd.forward(req, res);
			}
		}
		else {
			res.sendRedirect("Failure.html");

		}
		
		
		
	}

}

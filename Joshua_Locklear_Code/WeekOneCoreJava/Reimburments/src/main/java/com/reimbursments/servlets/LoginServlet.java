package com.reimbursments.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursments.pojos.Users;
import com.reimbursments.service.Service;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In the Login");
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean check = service.checkEmail(email);
		boolean passCheck = service.checkPassword(email,password);
		System.out.println(email);
		Users u = service.loginUser(email);
		ArrayList<Users> list = service.getAllUsers();
		
		if(check == true && passCheck == true) {
			if(u.getIsManager() == 0) {
			System.out.println("Logging user " + u.toString());
			session.setAttribute("user", u); //Use this to persist the data throughout the server
			// The parameter is the name, and the actual object.
			
			RequestDispatcher rd = request.getRequestDispatcher("EmployeePage.html");
			rd.forward(request, response);
			}
			else if(u.getIsManager() == 1) {
				
				session.setAttribute("user", u);//Use this to persist the data throughout the server
				// The parameter is the name, and the actual object.
				
				RequestDispatcher rd = request.getRequestDispatcher("ManagerPage.html");
				rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("Login.html");

		}
	}
		
}

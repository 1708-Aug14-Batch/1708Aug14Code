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

public class LoginServlet extends HttpServlet {
	
	private Service runApp = new Service();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User tmp = runApp.validateEmail(email);
		if (tmp == null) {
			System.out.println("You are not in the system...");
			response.sendRedirect("login.html");
			return;
		}
		else {
			if (password.equals(tmp.getPassword())) {
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
			} else {
				System.out.println("You entered the wrong password...");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
				return;
			}
				
		}
	}
}

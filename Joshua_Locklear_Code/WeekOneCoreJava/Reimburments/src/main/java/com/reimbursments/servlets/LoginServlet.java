package com.reimbursments.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.reimbursments.DAO.DAOImpl;
import com.reimbursments.pojos.Users;
import com.reimbursments.service.Service;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static Logger log = Logger.getLogger(LoginServlet.class);
	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		log.debug("In the Login");
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean check = service.checkEmail(email);
		boolean passCheck = service.checkPassword(email,password);
		log.debug(email);
		Users u = service.loginUser(email);
		ArrayList<Users> list = service.getAllUsers();
		
		if(check == true && passCheck == true) {
			if(u.getIsManager() == 0) {
			log.debug("Logging user " + u.toString());
			session.setAttribute("user", u); //Use this to persist the data throughout the server
			// The parameter is the name, and the actual object.
			
			RequestDispatcher rd = request.getRequestDispatcher("EmployeePage.html");
			rd.forward(request, response);
			}
			else if(u.getIsManager() == 1) {
				
				session.setAttribute("user", u);//Use this to persist the data throughout the server
				// The parameter is the name, and the actual object.
				
				RequestDispatcher rd = request.getRequestDispatcher("ManagerPage.html");
				//PrintWriter print = response.getWriter();
				//print.write("ManagerPage.html");
				//return;
				rd.forward(request, response);
			}
		}
		else {
			response.sendRedirect("Login.html");

		}
	}
		
}

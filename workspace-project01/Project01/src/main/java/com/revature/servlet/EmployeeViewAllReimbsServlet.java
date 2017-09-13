package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.RUser;

@WebServlet("/employee-view-all-reimbs")
public class EmployeeViewAllReimbsServlet extends HttpServlet {

	private static final long serialVersionUID = -6580522119763970959L;
	private static final int FORBIDDEN = 403;
	
	/**
	 * Injects the partial view for showing an employee's reimbursement requests.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Inside EmployeeAllReimbs doGet");
		RUser loggedInUser = (RUser) request.getSession().getAttribute("user");
		if (loggedInUser != null) {
			request.getRequestDispatcher("partial/employee/view-all-requests.html").forward(request, response);
		} else {
			response.setStatus(FORBIDDEN);
		}
	}
	
}

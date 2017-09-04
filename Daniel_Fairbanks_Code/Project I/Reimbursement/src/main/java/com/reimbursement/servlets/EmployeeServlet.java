package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.User;

public class EmployeeServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User tmp = (User)session.getAttribute("user");
		if (tmp == null) {
			response.sendRedirect("login.html");
			//request.getRequestDispatcher("login.html").forward(request, response);
//			rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			out.write("Hello, "+tmp.getFirstname()+" "+tmp.getLastname()+"!");
			out.write("<ul>"
					+ "<li>"+tmp.getFirstname()+"</li>"
					+ "<li>"+tmp.getLastname()+"</li>"
					+ "<li>"+tmp.getEmail()+"</li>"
					+ "</ul>");
			out.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

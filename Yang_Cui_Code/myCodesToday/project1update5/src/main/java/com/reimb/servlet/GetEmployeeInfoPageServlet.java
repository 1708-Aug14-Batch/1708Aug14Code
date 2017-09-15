package com.reimb.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmployeeInfo")
public class GetEmployeeInfoPageServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("in reimb view servlet");
		
		
		req.getRequestDispatcher("partials/EmployeeInfo.html")
		.forward(req, resp);
	}
}
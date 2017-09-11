package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getEmployeePage")
public class GetEmployeePageServlet extends HttpServlet{

	
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("here!");
		req.getRequestDispatcher("employee.html").forward(req, res);
		//res.sendRedirect("employee.html");
	}
}
package com.reimbursement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getdashboard")
public class GetDashboardServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		req.getRequestDispatcher("partials/dashboard.html").forward(req, res);
		
	}
	
}

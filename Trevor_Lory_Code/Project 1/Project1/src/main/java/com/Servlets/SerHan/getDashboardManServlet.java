package com.Servlets.SerHan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getDashboardMan")
public class getDashboardManServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in Dashboard Man servlet");
		
		request.getRequestDispatcher("partials/DashboardMan.html").forward(request, response);
	}
	
}

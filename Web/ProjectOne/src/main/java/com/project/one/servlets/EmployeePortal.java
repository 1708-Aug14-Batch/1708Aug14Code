package com.project.one.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.one.service.Service;

/**
 * Servlet implementation class EmployeePortal
 */
public class EmployeePortal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service server;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		server = new Service();
		String email = request.getParameter("email");
		String name = Service.login(email).getFn();
		PrintWriter out = response.getWriter();
		out.write("User Person");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

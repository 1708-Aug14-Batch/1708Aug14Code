package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.RUser;

@WebServlet("/employee-view-my-info")
public class EmployeeViewMyInfoServlet extends HttpServlet {

	private static final int FORBIDDEN = 403;
	private static final long serialVersionUID = 7800631297147052348L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Inside EmployeeGetMyInfo doGet");
		RUser loggedInUser = (RUser) request.getSession().getAttribute("user");
		if (loggedInUser != null) {
			request.getRequestDispatcher("partial/employee/view-info.html").forward(request, response);
		} else {
			response.setStatus(FORBIDDEN);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Inside EmployeeGetMyInfo doPost");
		RUser loggedInUser = (RUser) request.getSession().getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(loggedInUser);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.RUser;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-view-employee")
public class ManagerViewEmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = -534896063319495499L;
	private ReimbursementService service = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("partial/manager/view-employee.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String email = requestParams.nextElement();
		//String email = (String) mapper.readValue(requestString, String.class);
		RUser employee = this.service.getUser(email);
		String json = mapper.writeValueAsString(employee);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

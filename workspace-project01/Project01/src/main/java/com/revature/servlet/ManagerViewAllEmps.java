package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.RUser;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-view-emps")
public class ManagerViewAllEmps extends HttpServlet {
	
	private ReimbursementService service = new ReimbursementService();
	
	/**
	 * Returns the view for showing all employees
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("partial/manager/view-all-employees.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<RUser> allEmps = this.service.getAllEmps();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(allEmps);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

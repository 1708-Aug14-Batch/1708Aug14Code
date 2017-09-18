package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserEditDTO;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-view-emp-requests")
public class ManagerViewEmpRequestsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 5195106599914069164L;
	private ReimbursementService service = new ReimbursementService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("partial/manager/view-employee-requests.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Get employee reimbs by email
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String email = requestParams.nextElement();
		
		ArrayList<Reimbursement> reimbs = this.service.getEmployeeReimbsByEmail(email);
		String json = mapper.writeValueAsString(reimbs);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

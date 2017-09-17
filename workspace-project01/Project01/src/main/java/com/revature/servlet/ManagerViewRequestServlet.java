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
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-view-request")
public class ManagerViewRequestServlet extends HttpServlet {
	
	private ReimbursementService service = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/partial/manager/view-request.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String requestString = requestParams.nextElement();
		String idString = (String) mapper.readValue(requestString, String.class);
		int id = Integer.parseInt(idString);
		Reimbursement reimb = this.service.getSingleReimb(id);
		String json = mapper.writeValueAsString(reimb);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

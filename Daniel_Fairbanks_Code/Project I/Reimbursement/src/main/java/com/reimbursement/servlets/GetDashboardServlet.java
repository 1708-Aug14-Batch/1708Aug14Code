package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.dto.DTO;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

@WebServlet("/getDashboard")
public class GetDashboardServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("partials/dashboard.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Using the DTO and json
		 */
		Service serv = new Service();
		HttpSession session = request.getSession();
		User sessionUser = (User)session.getAttribute("user");
		HashMap<Integer, Reimbursement> requests = serv.getRequestsByEmployee(sessionUser);
		if (sessionUser != null) {
			//DTO dto = new DTO(sessionUser, requests);
			ObjectMapper mapper = new ObjectMapper();
			
			//String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			//out.write(json);
		}
	}
}

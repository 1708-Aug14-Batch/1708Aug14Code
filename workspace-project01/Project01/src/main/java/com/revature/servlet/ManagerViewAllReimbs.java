package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/manager-all-reimbs")
public class ManagerViewAllReimbs extends HttpServlet {

	private static final long serialVersionUID = 366423898171136430L;
	private ReimbursementService service = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("partial/manager/view-all-requests.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<Reimbursement> reimbs = this.service.getAllReimbs();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbs);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

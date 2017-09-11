package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.service.Service;

@WebServlet("/getemployeereimbursements")
public class EmployeeReimbursementsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Service bankService = new Service();
		PrintWriter writer = res.getWriter();

		ArrayList<Reimbursement> reimbursements = bankService.getEmployeeReimbursements((String)req.getParameter("name"));
		//get json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbursements);

		//send json
		System.out.println(json);
		res.setContentType("application/json");
		writer.println(json); 
	}
}


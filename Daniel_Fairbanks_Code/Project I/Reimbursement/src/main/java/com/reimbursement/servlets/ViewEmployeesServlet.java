package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.reimbursement.dto.DTO;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

@WebServlet("/viewEmployees")
public class ViewEmployeesServlet extends HttpServlet {

	private Service runApp = new Service();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.setStatus(418);
		}
		else {
			User tmp = (User)session.getAttribute("user");
			ArrayList<User> employees = runApp.getAllEmployees();

			DTO dto = new DTO(tmp, null, employees);

			ObjectWriter objWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = objWriter.writeValueAsString(dto);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.close();
		}
	}
}

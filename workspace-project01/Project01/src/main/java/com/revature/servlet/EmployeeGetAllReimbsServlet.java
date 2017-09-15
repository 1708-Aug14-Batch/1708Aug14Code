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
import com.revature.dto.UserReimbsDTO;
import com.revature.model.RUser;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;

@WebServlet("/employee-get-all-reimbs")
public class EmployeeGetAllReimbsServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8219662133087879474L;
	private ReimbursementService service = new ReimbursementService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RUser loggedInUser = (RUser) request.getSession().getAttribute("user");
		int userID = loggedInUser.getRUserID();
		ArrayList<Reimbursement> reimbs = this.service.getEmployeeReimbs(userID);
		UserReimbsDTO dto = new UserReimbsDTO(loggedInUser, reimbs);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dto);
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

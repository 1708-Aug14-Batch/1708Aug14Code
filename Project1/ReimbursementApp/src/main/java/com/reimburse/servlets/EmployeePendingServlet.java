package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.dto.DTO;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/employeepending")
public class EmployeePendingServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(EmployeePendingServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
		//session + outwriter + service
		HttpSession session = req.getSession();
		PrintWriter writer = res.getWriter();
		Service bankService = new Service();
		
		//user + reimbursements + dto
		int userid = (int)session.getAttribute("userid");
		User user = bankService.getUser(userid);
		ArrayList<Reimbursement> reimbursements = bankService.getEmployeePendingReimbursements(user.getUserId());
		DTO dto = new DTO(user,reimbursements);
		
		//get json
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dto);
		
		//send json
		System.out.println(json);
		res.setContentType("application/json");
		writer.println(json); 

		logger.info("POST pending reimbursements for user "+session.getAttribute("userid")+":"+json);
	};
}

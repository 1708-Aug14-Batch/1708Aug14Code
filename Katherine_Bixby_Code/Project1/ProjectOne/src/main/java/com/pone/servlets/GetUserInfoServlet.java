package com.pone.servlets;

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
import com.pone.dto.DTO;
import com.pone.pojos.AUser;
import com.pone.pojos.RStatus;
import com.pone.pojos.Reimbursement;
import com.pone.service.Service;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet{
	
	
	/*
	 * I NEED ONE OF THESE BUT FOR MANAGERS FRIG
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		
		Service service = new Service();
		
		HttpSession session = request.getSession();

		AUser sessionUser = (AUser)session.getAttribute("auser");

		if(sessionUser != null){
			ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			reimbursements = service.getUserReimbursements(sessionUser);

			
			ArrayList<RStatus> allStatuses = service.getReimbursementStatuses();
			System.out.println("Statuses: "+allStatuses.toString());
			DTO dto = new DTO(sessionUser, reimbursements,allStatuses);
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}
		else{
			response.setStatus(418);
		}
		
		
	}
	
}
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
import com.pone.pojos.Reimbursement;
import com.pone.service.Service;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException{
		
		//System.out.println("GetUserInfoServlet -- GET");
		Service service = new Service();
		
		HttpSession session = request.getSession();
		//System.out.println(session);
		//System.out.println(session.getAttribute("auser"));
		AUser sessionUser = (AUser)session.getAttribute("auser");
		//System.out.println("getting user from session " + sessionUser.toString());
		if(sessionUser != null){
			ArrayList<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
			reimbursements = service.getUserReimbursements(sessionUser);
//			for(Reimbursement r: reimbursements){
//				System.out.println(r.toString());
//			}
			//System.out.println("converting our user and accounts to dto");
			DTO dto = new DTO(sessionUser, reimbursements);
			
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
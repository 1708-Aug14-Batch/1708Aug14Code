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
import com.reimbursement.DTO.DTO;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		System.out.println("getting user info");
		Service service = new Service();
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("user");
		System.out.println("getting user from session " + sessionUser.toString());
		if(sessionUser != null) {
			ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
			System.out.println("Converting our user and accounts to dto");
			DTO dto = new DTO(sessionUser, reim);
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.write(json);
		}
		else {
			res.setStatus(418);
		}
		
		
	}
	
	
}

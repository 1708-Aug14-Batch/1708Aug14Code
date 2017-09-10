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

@WebServlet("/UserReimbursement")
public class ReimbursementPage extends HttpServlet{

	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		System.out.println("getting user info");
		Service service = new Service();
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("user");
		ArrayList<User> userLists = (ArrayList<User>) session.getAttribute("userlist");
		DTO dto = new DTO();
		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
//		System.out.println("getting user from session " + sessionUser.toString());
		if(sessionUser != null) {
			if(sessionUser.getIsManager() == 0) {
			reim = service.getUserReimbursements(sessionUser);
			dto.setUser(sessionUser);
			
			}
			else if(sessionUser.getIsManager() == 1) {
				System.out.println("This dude is a manager");
				dto.setUserList(userLists);
				reim = service.getAllReimbursements();
				dto.setAccounts(reim);
			}
			
			System.out.println("Converting our user and accounts to dto");
			System.out.println(dto.getAccounts().toString());
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			
			System.out.println(sessionUser.toString());
			System.out.println(reim.size());
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.write(json);
			
		}
		else {
			res.setStatus(418);
		}
		
	}
	
	
	
	
}

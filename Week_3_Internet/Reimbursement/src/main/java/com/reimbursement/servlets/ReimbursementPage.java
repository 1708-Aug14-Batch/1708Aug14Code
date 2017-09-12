package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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
		ArrayList<User> userLists = service.getAllUsers();
		DTO dto = new DTO();
		ArrayList<Reimbursement> reim = new ArrayList<Reimbursement>();
//		System.out.println("getting user from session " + sessionUser.toString());
		if(sessionUser != null) {

			if(sessionUser.getIsManager() == 0) {
			reim = service.getUserReimbursements(sessionUser);
			}
			else if(sessionUser.getIsManager() == 1) {
				reim = service.getAllReimbursements();
			}
			dto.setUser(sessionUser);
			
			dto.setAccounts(reim);

			dto.setUserList(userLists);
			System.out.println(userLists);
			
			System.out.println("Converting our user and accounts to dto");
			
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		Service service = new Service();
		System.out.println("In the approve or deny post");
		
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		Integer resId = Integer.parseInt(list.get(0));
		String notes = list.get(1);
		Integer r_id = Integer.parseInt(list.get(2));
		Integer re_id = Integer.parseInt(list.get(3));
		service.ApporDeny(resId, notes, r_id, re_id);

		
	}
	
	
	
	
}

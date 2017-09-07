package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.dto.DTO;
import com.revature.andy.pojos.Reimbursement;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("getting user info");
		Service s = new Service();
		
		System.out.println("userInfoServlet");
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");
		
		System.out.println(sessionUser.getUserID());
		
		if(sessionUser!=null) {
			HashSet<Reimbursement> reims = null;
			reims = s.getUserReimbursement(sessionUser.getUserID());
			
			DTO dto = new DTO(sessionUser,reims);
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dto);
			
			System.out.println(json);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			
			out.write(json);
		}
		/*
		else {
			resp.setStatus(418);
		}*/
	}
}

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
import com.revature.andy.pojos.Account;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;
import com.revature.andy.session.PseudoSession;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("getting user info");
		Service s = new Service();
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");
		if(sessionUser!=null) {
			HashSet<Account> accounts = null;
			accounts = s.getAccounts();
			
			DTO dto = new DTO(PseudoSession.getCurrentUser(),accounts);
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dto);
			
			System.out.println(json);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			
			out.write(json);
		}
		else {
			resp.setStatus(418);
		}
	}

	
	
}

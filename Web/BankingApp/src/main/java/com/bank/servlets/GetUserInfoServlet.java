package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dto.DTO;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("Getting User Info");
		
		Service service  = new Service();
		
		HttpSession session = req.getSession();
		
		
		
		User sessionuser = (User)session.getAttribute("user");
		
		if(sessionuser != null) {
			ArrayList<Account> accounts = service.getOpenAccounts(sessionuser); 
			
			System.out.println("Converting use & accounts to DTO");
			DTO dto = new DTO(sessionuser, accounts);
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);
			
		}
		else {
			resp.setStatus(418);
		}
	}
}

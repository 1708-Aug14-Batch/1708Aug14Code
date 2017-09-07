package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.DTO;
import com.revature.model.Account;
import com.revature.model.User;
import com.revature.service.BankService;

//@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("getting user info");
		BankService service = new BankService();
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");
		if (sessionUser != null) {
			/*ArrayList<Account> accounts = new ArrayList<Account>();
			accounts = service.getUserAccounts(sessionUser);
			System.out.println("Converting user and account to DTO");
			DTO dto = new DTO(sessionUser, accounts);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			writer.write(json);*/
		} else {
			response.setStatus(418);
		}
	}
	
}

package com.bank3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank3.dto.DTO;
import com.bank3.pojos.User;
import com.bank3.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("GetUserInfoServlet -- GET");
		Service service = new Service();
		
		HttpSession session = request.getSession(true);
		User sessionUser = (User) session.getAttribute("user");
	
		if(sessionUser != null) {
			//ArrayList<Account> accounts = new ArrayList<Account>();
			//accounts = service.getUserAccounts(sessionUser);
			
			System.out.println("converting out user and accounts to dto");
			System.out.println(sessionUser.getFirstname().toString());
			
			//DTO dto = new DTO(sessionUser, accounts);
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(sessionUser);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		} else {
			response.setStatus(418);
		}
	}

}

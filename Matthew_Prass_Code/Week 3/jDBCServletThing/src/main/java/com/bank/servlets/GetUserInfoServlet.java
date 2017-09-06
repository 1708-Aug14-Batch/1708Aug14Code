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

import com.bank.dao.DaoImpl;
import com.bank.dto.DTO;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getUserInfo")
public class GetUserInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		System.out.println("getting user info");
		Service s = new Service();
		DaoImpl dao = new DaoImpl();
		
		HttpSession sesh = req.getSession();
		User seshuser = (User)sesh.getAttribute("user");
		
		if(seshuser != null)
		{
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts = dao.getAllAccountsForUser(seshuser.getId());
			
			System.out.println("converting our user and account to dto");
			DTO dto = new DTO(seshuser,accounts);
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

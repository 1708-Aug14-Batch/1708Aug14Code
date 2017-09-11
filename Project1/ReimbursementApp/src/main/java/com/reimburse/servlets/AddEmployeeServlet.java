package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
	
		Service bankService = new Service();
		PrintWriter writer = res.getWriter();
		
		//make new user
		User user = new User();
		
		//update info
		user.setFirstname(req.getParameter("fn"));
		user.setLastname(req.getParameter("ln"));
		user.setUsername(req.getParameter("username"));
		user.setEmail(req.getParameter("email"));
		user.setPwd(req.getParameter("pwd"));
		user.setIsManager((byte) 0); 
		
		//send
		user = bankService.addUser(user);

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		res.setContentType("application/json");
		writer.print(json);
	}
}

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
import com.reimburse.service.Services;

@WebServlet("/addUser")
public class CreateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Services service = new Services();
		PrintWriter writer = resp.getWriter();
		
		
		User user = new User();
		
		user.setFirstname(req.getParameter("firstname"));
		user.setLastname(req.getParameter("lastname"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("pwd"));
		user.setIsAManager(0);
		
		user = service.addUser(user);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		resp.setContentType("application/json");
		writer.print(json);
	}

}

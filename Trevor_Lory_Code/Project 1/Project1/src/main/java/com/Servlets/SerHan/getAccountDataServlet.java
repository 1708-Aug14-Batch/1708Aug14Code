package com.Servlets.SerHan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Reburse.Service.Service;
import com.Reburse.dto.DTOAcc;
import com.Reburse.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getAccData")
public class getAccountDataServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in AccountData servlet");
		
		Service ser = new Service();
		
		HttpSession ses = request.getSession();
		
		User sessionUser = (User)ses.getAttribute("User");
		
		if(sessionUser != null) {
			
			ArrayList<User> users = ser.getAllUsers();
			DTOAcc dto = new DTOAcc(users);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(dto);
			
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(json);
		}
		else {
			response.setStatus(418);
		}
	}
	
}

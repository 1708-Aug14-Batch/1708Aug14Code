package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.dto.DTO;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("User");
		
		//System.out.println(sessionUser.toString());
		
		if(sessionUser!=null) {
			
			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(sessionUser);
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			
			out.write(json);
		}
		else {
			resp.setStatus(418);
		}
	}
}

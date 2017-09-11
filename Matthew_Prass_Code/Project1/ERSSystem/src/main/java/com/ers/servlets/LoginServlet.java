package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet  extends HttpServlet{
	
	static Service s = new Service();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession sesh = req.getSession();
		Service s = new Service();
		
		System.out.println("------------------");
		String email = req.getParameter("name");
		String pass = req.getParameter("paw");
		String username = req.getParameter("username");
		System.out.println(email + " " + pass+ " " + username);
		int id = s.validateEmployee(email, username);
		System.out.println("id = " + id);
		
		if(id<0)
		{	
			String json = "fail";
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.write(json);
		}
		else {
			Employee u = s.login(id, pass);
			if(u == null)
			{
				String json = "pass";
				PrintWriter out = res.getWriter();
				res.setContentType("application/json");
				out.write(json);
			}
			else {
				
				sesh.setAttribute("employee", u);
				
				
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(u);
				PrintWriter out = res.getWriter();
				res.setContentType("application/json");
				out.write(json);
			}
		}
		
	}

}

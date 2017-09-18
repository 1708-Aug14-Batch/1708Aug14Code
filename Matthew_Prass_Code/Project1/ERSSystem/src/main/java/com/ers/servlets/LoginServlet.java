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

import org.apache.log4j.Logger;

import com.ers.pojos.Employee;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlet  extends HttpServlet{
	
	static Service s = new Service();

	static Logger l = Logger.getRootLogger();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		
		HttpSession sesh = req.getSession();
		Service s = new Service();
		
	
		String email = req.getParameter("name");
		String pass = req.getParameter("paw");
		String username = req.getParameter("username");
		
		int id = s.validateEmployee(email, username);
		
		if(id<0)
		{	
			l.info("an attempt was made to log in");
			String json = "fail";
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.write(json);
		}
		else {
			Employee u = s.login(id, pass);
			if(u == null)
			{
				l.info("an attempt was made to log with the username of" + username);
				String json = "pass";
				PrintWriter out = res.getWriter();
				res.setContentType("application/json");
				out.write(json);
			}
			else {
				
				sesh.setAttribute("employee", u);
				
				l.info("login successful: " + email +pass + username);
				ObjectMapper mapper = new ObjectMapper();
				
				String json = mapper.writeValueAsString(u);
				PrintWriter out = res.getWriter();
				res.setContentType("application/json");
				out.write(json);
			}
		}
		
	}

}

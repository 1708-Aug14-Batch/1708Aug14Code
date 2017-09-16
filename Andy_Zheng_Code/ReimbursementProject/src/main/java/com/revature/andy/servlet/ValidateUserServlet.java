package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/validateUser")
public class ValidateUserServlet extends HttpServlet{

	final static Logger log = Logger.getLogger(ValidateUserServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.

		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> transObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		log.debug("User Info\t" + to);
		
		Service s= new Service();
		
		String password = to.get(0);
		
		HttpSession session = req.getSession();

		User sessionUser = (User) session.getAttribute("User");
		
		log.debug("Current User\t" + sessionUser);
		
		String json = null;
		if(sessionUser.getPassword().equals(password)) {
			json = "true";
		}else {
			json = "false";
		}
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		log.debug("Response\t" + json);
	}
}

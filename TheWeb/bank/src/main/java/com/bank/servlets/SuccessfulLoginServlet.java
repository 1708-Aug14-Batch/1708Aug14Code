package com.bank.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loginsuccess")
public class SuccessfulLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("successfully logging in. redirecting to app home");
System.out.println("testing -- POST");
		
		// Grab all params, even though in this case its
		// only 1 JSON string
		Map<String, String[]> myMap = req.getParameterMap();
		
		// Get the keyset from the map 
		Set<String> txObject = myMap.keySet();
		
		// use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();
		
		// convert our keyset into an array, then get
		// what we need from it
		Object obj = txObject.toArray()[0];
		System.out.println(obj.toString());
		User user = jackson.readValue(
				(String)obj, User.class);
		
		HttpSession session = req.getSession();
		
		
		session.setAttribute("user", user);
		
		
//		req.getRequestDispatcher("app.html")
//		.forward(req, resp);
	}

}

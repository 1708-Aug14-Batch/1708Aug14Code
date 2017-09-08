package com.pone.servlets;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pone.pojos.AUser;
import com.pone.service.Service;

@WebServlet("/loginmessage")
public class LoginMessageServlet extends HttpServlet {
	
	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Testing -- POST");
		
		//Grab all params, even though in this case its only 1 JSON string
		Map<String,String[]> myMap = req.getParameterMap();
		//Get the keyset from the map
		Set<String> txObject = myMap.keySet();
		//use Jackson. API for converting JSON to Java
		ObjectMapper jackson = new ObjectMapper();
		
		//convert our keyset into an array, then get what we want from it
		Object obj = txObject.toArray()[0]; // our array is only gonna have one element here
		
		ArrayList<String> tx = jackson.readValue((String) obj,ArrayList.class);
		
		HttpSession session = req.getSession();
		
		
		String username = tx.get(0);
		String password = tx.get(1);
		
		int id = service.validateUser(username);
		System.out.println("id = "+id);
		String json="";
		if(id<0) { // if user does not exist
			json = "Invalid user. Please try again";
		}
		else {
			AUser u = service.login(id, password);
			if(u==null) {
				json= "Incorrect Password. Please try again.";
			}
			else {
				json = "Success";
				session.setAttribute("auser", u);
			}
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
		
	}
	
}

package com.revature.andy.testing;

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
import com.revature.andy.service.Service;
import com.revature.andy.session.PseudoSession;

@WebServlet("/testLogin")
public class testLoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("testing Post");
		
		// grab all params, this case only have 1 JSON string
		
		Map<String, String[]> myMap = req.getParameterMap();
		
		// get the key set
		
		Set<String> transObject = myMap.keySet();
		
		// use jackson api for converting json to java
		
		ObjectMapper jackson = new ObjectMapper();
		
		// convert our keyset into an array, then get what we need from it
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		HttpSession session = req.getSession();
		Service s= new Service();
		
		String email = to.get(0);
		String password = to.get(1);
		
		
		int id = PseudoSession.login(email, password);
		String json = null;
		if(id==1) {
			json = "success";
		}else if(id==2) {
			json = "wrong password";
		}else if(id==0) {
			json = "wrong information";
		}
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}
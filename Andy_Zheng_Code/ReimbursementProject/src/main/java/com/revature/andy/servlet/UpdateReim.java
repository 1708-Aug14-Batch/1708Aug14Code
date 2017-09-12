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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

@WebServlet("/updateReim")
public class UpdateReim extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, String[]> myMap = req.getParameterMap();
		
		Set<String> transObject = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = transObject.toArray()[0];
		ArrayList<String> to = jackson.readValue((String) obj, ArrayList.class);
	
		Service s= new Service();
		
		int reimID = Integer.parseInt(to.get(0));
		String status = to.get(1);
		String notes = to.get(2);
		
		System.out.println(reimID);
		System.out.println(notes);
		
		String json = null;
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("User");
		
		if(s.updateReimbursements(reimID, u, status, notes)) {
			json = "Success";
		}
		else {
			json = "Failure";
		}
			
		System.out.println(json);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}

}

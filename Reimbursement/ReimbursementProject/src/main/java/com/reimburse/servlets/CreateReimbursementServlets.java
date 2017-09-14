package com.reimburse.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.service.Services;

public class CreateReimbursementServlets extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException{
		System.out.println("posting new accounts to database");
		Map<String, String[]> myMap = request.getParameterMap();
		Set<String> rimObj = myMap.keySet();
		
		ObjectMapper  jackson = new ObjectMapper();
		
		Object obj = rimObj.toArray()[0];
		
		String reimburse = (String) jackson.readValue((String)obj, String.class);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String desc = "";
		double amt = 0.0;
		
		Services service = new Services();
		Reimbursement temp = service.addReimbursement(user, desc, amt);
		System.out.println(temp.toString());
		
		session.setAttribute("user", user);
		session.setAttribute("newReimburse", temp);
		
		//request.getRequestDispatcher(partials/dashboard.html);
		
		
	}

}

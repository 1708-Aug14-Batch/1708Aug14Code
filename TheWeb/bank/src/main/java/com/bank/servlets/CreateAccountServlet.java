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

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/addAccount")
public class CreateAccountServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("posting new account to db");
		
		// grab all parameters - in this case, only 1 JSON string
		Map<String, String[]> myMap = request.getParameterMap();
		
		// get the key set from the map of params and vals
		Set<String> txObj = myMap.keySet();
		
		//API For converting JSON to java obj
		ObjectMapper jackson = new ObjectMapper();
		
		Object obj = txObj.toArray()[0];
		
		//convert the JSON string into the class specified in the 2nd argument
		String accType = (String) jackson.readValue((String)obj, String.class);
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		
		Service service = new Service();
		Account temp = service.addAccount(user, accType);
		
		System.out.println(temp.toString());
		
		session.setAttribute("user", user);
		session.setAttribute("newAcc", temp);
		
		request.getRequestDispatcher("partials/dashboard.html");
		
	}
	
}

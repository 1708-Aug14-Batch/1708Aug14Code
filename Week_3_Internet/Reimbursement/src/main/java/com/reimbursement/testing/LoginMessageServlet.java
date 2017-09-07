package com.reimbursement.testing;

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
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

@WebServlet("/loginmessagetest")
public class LoginMessageServlet extends HttpServlet {

	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		System.out.println("Testing -- GET");
		
		req.getRequestDispatcher("partials/testloginpartial.html").forward(req, res);
	}
	
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		System.out.println("Testing -- POST");
		
		// Grab all params, even though in this case its only 1 JSON string
		
		Map<String, String[]> myMap = req.getParameterMap();
		System.out.println(myMap.toString());
		//Get the keyset from the map
		Set<String> txObject = myMap.keySet();
		
		// use Jackson API for converting JSON to Java
		ObjectMapper jackson = new ObjectMapper();
		
		//Convert our keyset into an array, then get what we need from it.
		Object obj = txObject.toArray()[0];
		System.out.println(obj.toString());
		ArrayList<String> tx = jackson.readValue((String) obj, ArrayList.class);
		
		HttpSession session = req.getSession();
		Service service = new Service();
		
		String email = tx.get(0);
		String pass = tx.get(1);
		
		boolean check = service.checkEmail(email);
		boolean passCheck = service.checkPassword(email, pass);
		String json = "";
		if(check == true && passCheck == true) {
			User u = service.loginUser(email);
			
		}
		else {
			json = "Invalid Email and/or Password";
		}
		PrintWriter out = res.getWriter();
		res.setContentType("application/json");
		out.write(json);
		
		
	}
	
	
	
}

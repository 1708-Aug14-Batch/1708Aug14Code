package com.reimbursement.servlets;

import java.io.IOException;
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

@WebServlet("/EditUserInfo")
public class UpdateUserServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("We in here doing the update");
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		HttpSession session = req.getSession();

		
		User temp = (User)session.getAttribute("user");
		
		
		String fname = list.get(0);
		if(fname == "") {
			fname = temp.getFirstname();
		}
		System.out.println("Firstname " + fname);
		String lname = list.get(1);
		if(lname == "") {
			lname = temp.getLastname();
		}
		System.out.println("Lastname: " + lname);
		String email = list.get(2);
		if(email == "") {
			email = temp.getEmail();
		}
		System.out.println("email: " + email);
		String password = list.get(3);
		if(password == "") {
			password = temp.getPassword();
		}
		System.out.println("Password:" + password);
		temp.setFirstname(fname);
		System.out.println("First name being set:" + temp.getFirstname());
		temp.setLastname(lname);
		System.out.println("Last name being set:" + temp.getLastname());
		temp.setEmail(email);
		System.out.println("Email being set: " + temp.getEmail());
		temp.setPassword(password);
		System.out.println("Password being set: " + temp.getPassword());
		Service service = new Service();
		service.updateUser(temp);
		System.out.println("Submittal Success?");
		
	}

}

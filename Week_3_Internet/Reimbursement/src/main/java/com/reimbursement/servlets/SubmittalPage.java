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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursement.DTO.DTO;
import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

@WebServlet("/AddReimbursement")
public class SubmittalPage extends HttpServlet {

	
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("IN POST");
		
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		String email = list.get(0);
		String password = list.get(1);
		String reason = list.get(2);
		Integer amount = Integer.parseInt(list.get(3));
		User u = new User(email,password);
		Reimbursement r = new Reimbursement(reason,amount);
		Service service = new Service();
		service.submitReimbursement(u, r);
		System.out.println("Submittal Success?");
		
		
	
		
		
	}
}

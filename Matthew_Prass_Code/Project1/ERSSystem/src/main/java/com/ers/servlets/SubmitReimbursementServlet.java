package com.ers.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/SubmitReimbursement")
public class SubmitReimbursementServlet extends HttpServlet{
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		HttpSession session = req.getSession();

		
		Employee seshuser = (Employee)session.getAttribute("employee");
		
		
		String descript = list.get(0);
		double amount = Double.parseDouble(list.get(1));
		InputStream is = req.getInputStream();
		System.out.println(is);
		Service s= new Service();
		s.submitReimbursement(seshuser, descript, amount, is);
		
		
	}

}

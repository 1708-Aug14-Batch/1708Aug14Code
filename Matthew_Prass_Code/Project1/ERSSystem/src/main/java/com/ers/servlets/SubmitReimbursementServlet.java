package com.ers.servlets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ers.pojos.Employee;
import com.ers.pojos.Reimbursement;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

@WebServlet("/SubmitReimbursement")
public class SubmitReimbursementServlet extends HttpServlet{
	
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		HttpSession session = req.getSession();
		
		for(String str: list) {
			System.out.println(str);
		}

		Employee seshuser = (Employee)session.getAttribute("employee");
		
		
		String descript = list.get(0);
		double amount = Double.parseDouble(list.get(1));
		String file = list.get(2);
		InputStream is = new ByteArrayInputStream(file.getBytes(StandardCharsets.UTF_8.name()));
		System.out.println(is);
		Service s= new Service();
		Reimbursement test = s.submitReimbursement(seshuser, descript, amount, is);
		System.out.println(test.getInputStream());
		
	}



}

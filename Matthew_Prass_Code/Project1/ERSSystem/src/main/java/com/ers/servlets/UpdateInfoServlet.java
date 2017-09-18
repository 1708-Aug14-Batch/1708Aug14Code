package com.ers.servlets;

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

import org.apache.log4j.Logger;

import com.ers.pojos.Employee;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/EditUserInfo")
public class UpdateInfoServlet extends HttpServlet{
	
	static Logger l = Logger.getRootLogger();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Map<String,String[]> myMap = req.getParameterMap();
		Set<String> keys = myMap.keySet();
		
		ObjectMapper jackson = new ObjectMapper();
		Object obj = keys.toArray()[0];
		ArrayList<String> list = jackson.readValue((String)obj, ArrayList.class);
		HttpSession session = req.getSession();

		
		Employee temp = (Employee)session.getAttribute("employee");
		
		
		String fname = list.get(0);
		if(fname == "") {
			fname = temp.getFirstname();
		}
		
		String lname = list.get(1);
		if(lname == "") {
			lname = temp.getLastname();
		}
		
		String email = list.get(2);
		if(email == "") {
			email = temp.getEmail();
		}
		
		String password = list.get(3);
		if(password == "") {
			password = temp.getPassword();
		}
		
		String username = list.get(4);
		if(username == "") {
			username = temp.getUsername();
		}
		l.info("updated employee: " + temp.getFirstname());
		Service s= new Service();
		s.updateInfo(temp, fname, lname, email, password, username);
		
		
		
	}

}

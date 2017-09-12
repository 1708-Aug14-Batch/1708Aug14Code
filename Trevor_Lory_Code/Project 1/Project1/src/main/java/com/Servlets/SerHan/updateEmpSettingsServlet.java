package com.Servlets.SerHan;

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

import com.Reburse.Service.Service;
import com.Reburse.pojos.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/updateEmpSet")
public class updateEmpSettingsServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in updateEmpSet servlet");
		
		Service ser = new Service();
		
		HttpSession ses = request.getSession();
		
		User sessionUser = (User)ses.getAttribute("User");
		
		if(sessionUser != null) {
			Map<String, String[]> myMap = request.getParameterMap();
			Set<String> txObject = myMap.keySet();
			ObjectMapper jackson = new ObjectMapper();
			Object obj = txObject.toArray()[0];
			ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
//			[Email, FirstName, LastName, NewPass, OldPass]
			PrintWriter p = response.getWriter();
			String pssOld = tx.get(4);
			if(!pssOld.equals(sessionUser.getPassword())) {
				p.write("pass");
				return;
			}
			String email = sessionUser.getEmail();
			String firstName = sessionUser.getFirstName();
			String lastName = sessionUser.getLastName();
			String password = sessionUser.getPassword();
			if(!tx.get(0).equals("") && tx.get(0) != null) {
				sessionUser.setEmail(tx.get(0));
			}
			if(!tx.get(1).equals("") && tx.get(1) != null) {
				sessionUser.setFirstName(tx.get(1));
			}
			if(!tx.get(2).equals("") && tx.get(2) != null) {
				sessionUser.setLastName(tx.get(2));
			}
			if(!tx.get(3).equals("") && tx.get(3) != null) {
				sessionUser.setPassword(tx.get(3));
			}
			boolean val = ser.UpdateEmp(sessionUser);
			if(val) {
				p.write("true");
			}
			else {
				sessionUser.setEmail(email);
				sessionUser.setFirstName(firstName);
				sessionUser.setLastName(lastName);
				sessionUser.setPassword(password);
				p.write("false");
			}
		}
		else {
			response.setStatus(418);
		}
	}
	
}

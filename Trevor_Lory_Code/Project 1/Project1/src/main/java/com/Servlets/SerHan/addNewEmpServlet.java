package com.Servlets.SerHan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
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

@WebServlet("/addNewEmp")
public class addNewEmpServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in NewEmp servlet");
		
		Service ser = new Service();
		
		HttpSession ses = request.getSession();
		
		User sessionUser = (User)ses.getAttribute("User");
		
		if(sessionUser != null) {
			Map<String, String[]> myMap = request.getParameterMap();
			Set<String> txObject = myMap.keySet();
			ObjectMapper jackson = new ObjectMapper();
			Object obj = txObject.toArray()[0];
			ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
			String firstname = tx.get(0);
			String lastname = tx.get(1);
			String email = tx.get(2);
			String man = tx.get(3);
			boolean man2 = false;
			if(man.equals("true")) {
				man2 = true;
			}
			else {
				man2 = false;
			}
			ArrayList<String> passthings = ser.getAllPass();
			String tempPass = "";
			boolean failed = true;
			String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			Random r = new Random();
		    int N = alphabet.length();
			while(failed) {
				tempPass = "";
				for(int e = 0; e < 10; e++) {
					tempPass += alphabet.charAt(r.nextInt(N));
				}
				failed = false;
				for(int i = 0; i < passthings.size(); i++) {
					if(tempPass.equals(passthings.get(i))) {
						failed = true;
					}
				}
			}
			User u = new User();
			u.setFirstName(firstname);
			u.setLastName(lastname);
			u.setEmail(email);
			u.setPassword(tempPass);
			u.setIsManager(man2);
			boolean val = ser.addUser(u);
			PrintWriter p = response.getWriter();
			if(val) {
				p.write(tempPass);
			}
			else {
				p.write("");
			}
		}
		else {
			response.setStatus(418);
		}
	}
	
}

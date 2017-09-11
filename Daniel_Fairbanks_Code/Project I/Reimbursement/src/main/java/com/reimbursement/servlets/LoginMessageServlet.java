package com.reimbursement.servlets;

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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String[]> myMap = request.getParameterMap();
		Set<String> txObject = myMap.keySet();
		ObjectMapper jackson = new ObjectMapper();
		Object obj = txObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String)obj, ArrayList.class);
		
		HttpSession session = request.getSession();
		Service service = new Service();
		
		String email = tx.get(0);
		String pword = tx.get(1);
		String json="";
		
		User tmp = service.validateEmail(email);
		if(tmp == null) {
			json = "invalid";
		}
		else {
			if (tmp.getPassword().equals(pword)) {
				response.setContentType("text/html");
				synchronized(session) {
					session.setAttribute("user", tmp);
				}
				if (tmp.getIsManager() == true) {
					System.out.println("You are a manager in the system!");
					json = "manager.html";
				} else {
					System.out.println("You are an employee in the system!");
					json = "employee.html";
				}
			}
			else {
				json = "password";
			}
		}
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}
}

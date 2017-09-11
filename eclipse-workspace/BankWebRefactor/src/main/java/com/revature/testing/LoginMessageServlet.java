package com.revature.testing;

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
import com.revature.service.BankService;

@WebServlet("/login-message-test")
public class LoginMessageServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Testing -- POST");
		// Get all params, even though in this case its only 1 json string
		Map<String, String[]> map = request.getParameterMap();
		// Get the keyset from the map
		Set<String> transactionObject = map.keySet();
		// Use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();
		// Convert our keyset into an array, then get what we need from it
		Object obj = transactionObject.toArray()[0];
		ArrayList<String> transaction = jackson.readValue((String) obj, ArrayList.class);
		HttpSession session = request.getSession();
		BankService service = new BankService();
		String email = transaction.get(0);
		String password = transaction.get(1);
		String json = "";
		if (service.checkUserExists(email)) {
			if (service.validateUserCredentials(email, password)) {
				json = "You have successfully logged in!";
				request.getRequestDispatcher("/app.html").forward(request, response);
			} else {
				json = "Password incorrect";
			}
		} else {
			json = "That email was not found";
		}
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json");
		writer.write(json);
	}

}

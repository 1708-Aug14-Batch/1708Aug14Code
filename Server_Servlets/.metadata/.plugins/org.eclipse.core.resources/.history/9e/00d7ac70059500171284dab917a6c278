package com.bank.testing;

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

import com.bank.pojos.BankUser;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/loginMessageTest")
public class LoginMessageServlet extends HttpServlet {

	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = -7645111975570458433L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doPost of LoginMessageServlet");

		// Grab all params, even though in this case it is 1 JSON String
		// name values
		Map<String, String[]> myMap = req.getParameterMap();

		// Get the keyset from the map
		Set<String> dtoObject = myMap.keySet();

		// use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();

		// Convert our keyset into an array, then get what we need
		Object obj = dtoObject.toArray()[0];
		ArrayList<String> tx = jackson.readValue((String) obj, ArrayList.class);

		HttpSession session = req.getSession();
		Service bankService = new Service();

		String username = tx.get(0);
		String password = tx.get(1);

		BankUser user = bankService.validateBankUser(username, password);

		String json = "";
		if (user == null) {
			// Login failed
			json = "Invalid user";
			if (bankService.isABankUser(username)) {
				// Bad password
				json = "pass";
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				out.write(json);
			} else {
				// Bad username
				json = "fail";
				PrintWriter out = resp.getWriter();
				resp.setContentType("application/json");
				out.write(json);
			}
		} else {
			// Login successful
			session.setAttribute("user", user);
			json = username + " logged in!";

			ObjectMapper mapper = new ObjectMapper();

			json = mapper.writeValueAsString(user);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			out.write(json);

		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroying login servlet");
	}

}

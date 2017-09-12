package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.pojos.User;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AddUserServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.trace("in doPost");
		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<String> params = mapper.readValue(rawParams, ArrayList.class);

		String email = params.get(0);
		String password = params.get(1);
		String firstName = params.get(2);
		String lastName = params.get(3);
		boolean isManager = Boolean.parseBoolean(params.get(4));
		
		User newUser = new User(email, password, firstName, lastName, isManager);
		
		String errorMessage = Service.addUser(newUser);

		if (errorMessage == null || "".equals(errorMessage)) {
			log.trace("Successfully created user "+firstName+" "+lastName);

		} else {		
			log.trace("Failed to create user "+firstName+" "+lastName+": "+errorMessage);
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(errorMessage);
		}
	}

}

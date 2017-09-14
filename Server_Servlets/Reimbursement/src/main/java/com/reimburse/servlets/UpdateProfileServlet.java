package com.reimburse.servlets;

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

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimburse.pojos.Worker;
import com.reimburse.service.Service;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

	final static Logger logger = Logger.getLogger(UpdateProfileServlet.class);
	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = 6190081605793034484L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("doPost");

		ArrayList<String> tx = readValuesFromRequest(request);

		Service service = new Service();

		// Parameters in the following order: [userId, firstName, lastName,
		// email, username, password, managerId, isManager]
		int userId = Integer.parseInt(tx.get(0));
		String firstName = tx.get(1);
		String lastName = tx.get(2);
		String email = tx.get(3);
		String username = tx.get(4);
		String password = tx.get(5);
		int managerId = Integer.parseInt(tx.get(6));
		boolean isManager = tx.get(7).equals("true") ? true : false;

		HttpSession session = request.getSession();
		Worker user = service.getWorker(userId);

		String json = "";

		if (firstName.isEmpty() || lastName.isEmpty())
			json = "You must put a value in both name fields";
		else if (email.isEmpty())
			json = "You must put a value in the email field";
		else if (!service.isEmailValid(email))
			json = "That email is invalid.";
		else if (username.isEmpty() || password.isEmpty())
			json = "You must put a value in both the username and password fields";

		else if (userId == -1) {
			// Create a new worker

			if (!service.isUsernameAvailable(username))
				json = "That username is already taken";
			else if (!service.isEmailAvailable(email))
				json = "That email is already taken.";
			else {
				service.tryCreateWorker(managerId, firstName, lastName, email, username, password, isManager);
				json = "true";
			}
		} else if (user == null) {
			// userId does not correspond to a Bank User.
			// This should never happen
			logger.info("User is not in database");
			json = "User is not in database";
		} else {

			if (!service.isUsernameAvailable(username) && !username.equals(user.getUsername()))
				json = "That username is already taken";
			else if (!service.isEmailAvailable(email) && !email.equals(user.getEmail()))
				json = "That email is already taken.";
			else if (service.updateWorker(userId, firstName, lastName, email, username, password)) {
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				session.setAttribute("user", user); // Update the session's copy
													// of the User
				json = "true";
			} else {
				logger.info("Update failed");
				json = "Update failed";
			}

		}

		writeValueToResponse(response, json);
	}

	private ArrayList<String> readValuesFromRequest(HttpServletRequest req)
			throws JsonParseException, JsonMappingException, IOException {
		// Grab all params, even though in this case it is 1 JSON String
		// name values
		Map<String, String[]> myMap = req.getParameterMap();

		// Get the keyset from the map
		Set<String> dtoObject = myMap.keySet();

		// use Jackson. API for converting JSON to java
		ObjectMapper jackson = new ObjectMapper();

		// Convert our keyset into an array, then get what we need
		Object obj = dtoObject.toArray()[0];
		return jackson.readValue((String) obj, ArrayList.class);
	}

	private void writeValueToResponse(HttpServletResponse resp, String json) throws IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		out.write(json);
	}
}

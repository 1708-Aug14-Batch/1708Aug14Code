package com.ers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.pojos.User;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/updateinfo")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(UpdateInfoServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.setStatus(418);
			return;
		}
		
		log.trace(request.getParameterMap().keySet());
		
		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<String> params = mapper.readValue(rawParams, ArrayList.class);

		User user = (User) session.getAttribute("user");
		String type = params.get(0);
		String newValue = params.get(1);
		
		if (user != null) {
			
			switch (type) {
			case "fullname":
				String[] names = newValue.split("XQX");
				log.trace(names);
				Service.updateFirstName(user, names[0]);
				Service.updateLastName(user, names[1]);
				break;
			case "email":
				Service.updateEmail(user, newValue);
				break;
			case "password":
				Service.updatePassword(user, newValue);
				break;
			default:
			}
		}
	}
}

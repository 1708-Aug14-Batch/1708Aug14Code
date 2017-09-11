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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.pojos.User;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/checkCredentials")
public class CheckCredentialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CheckCredentialsServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");

		ObjectMapper mapper = new ObjectMapper();
		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();		
		@SuppressWarnings("unchecked")
		List<String> params = mapper.readValue(rawParams, ArrayList.class);
		
		String email = params.get(0);
		String password = params.get(1);
		
		log.info("checking credentials for email= "+email);

		String errorMessage = Service.loginUser(email, password);

		User user = Service.getCurrentUser();

		if (errorMessage == null || "".equals(errorMessage)) {
			log.trace("login successful");
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(Service.MAX_SESSION_INACTIVE_INTERVAL);
			
			log.trace("session= "+session.getId());
			session.setAttribute("user", user);
			log.trace("user= "+user);

		} else {		
			log.trace(errorMessage);
			log.trace("session= "+request.getSession(false));
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			out.write(errorMessage);
		}
	}
}

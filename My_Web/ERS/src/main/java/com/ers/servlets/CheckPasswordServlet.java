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
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/checkpassword")
public class CheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CheckPasswordServlet.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");

		HttpSession session = request.getSession(false);
		if (session == null) {
			log.warn("Session doesn't exist");
			response.setStatus(418);
			return;
		}

		User user = (User) session.getAttribute("user");
		if (user == null) {
			log.warn("Session user doesn't exist");
			response.setStatus(418);
			return;
		}

		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		ObjectMapper mapper = new ObjectMapper();	
		@SuppressWarnings("unchecked")
		List<String> params = mapper.readValue(rawParams, ArrayList.class);

		String password = params.get(0);

		log.trace("password= "+password);
		log.trace("user password= "+user.getPassword());

		if (!password.equals(user.getPassword())) {
			PrintWriter out = response.getWriter();
			out.write("Current password doesn't match");
			log.info("Incorrect password entered");

		} else {
			log.info("Correct password entered");
		}
	}
}

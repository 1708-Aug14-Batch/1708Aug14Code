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

import com.ers.dto.TableDto;
import com.ers.pojos.Request;
import com.ers.pojos.User;
import com.ers.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/gettable")
public class GetTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GetTableServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");

		HttpSession session = request.getSession(false);
		if (session == null) {
			log.warn("Session doesn't exist");
			response.setStatus(418);
			return;
		}

		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<Boolean> params = mapper.readValue(rawParams, ArrayList.class);

		boolean getPending = params.get(0);
		boolean getApproved = params.get(1);
		boolean getDenied = params.get(2);
		boolean showEmployees = params.get(3);

		User user = (User) session.getAttribute("user");
		if (user == null) {
			log.warn("Session user doesn't exist");
			response.setStatus(418);
			return;
		}
		
		String json;
		if (user.isManager() && showEmployees) {
			List<User> rows = Service.getAllEmployees();
			json = mapper.writeValueAsString(new TableDto<>(user, rows));
		}
		else {
			List<Request> rows = Service.getRequests(user, getPending, getApproved, getDenied);
			json = mapper.writeValueAsString(new TableDto<>(user, rows));
		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}
}

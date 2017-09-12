package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
			response.setStatus(418);
			return;
		}
		
		User user = (User) session.getAttribute("user");
		List<Request> requests = Service.getPendingRequests(user);
		TableDto<Request> dto = new TableDto<>(user, requests);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dto);
				
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.write(json);
	}

}

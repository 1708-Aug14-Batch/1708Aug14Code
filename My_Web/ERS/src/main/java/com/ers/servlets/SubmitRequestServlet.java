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

@WebServlet("/submitrequest")
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SubmitRequestServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");
		
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		
		if (session == null) {
			out.write("Failed to submit request: session error");
			return;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		@SuppressWarnings("unchecked")
		List<String> params = mapper.readValue(rawParams, ArrayList.class);
		
		float amount = Float.parseFloat(params.get(0));
		String description = params.get(1);
		User user = (User) session.getAttribute("user");
		

		if (Service.submitRequest(user, amount, description)) {
			
			out.write("Request successfully submitted");
		}
		else {			
			out.write("Failed to submit request");
		}		
	}
}

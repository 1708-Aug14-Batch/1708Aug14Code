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

@WebServlet("/resolverequest")
public class ResolveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ResolveRequestServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");

		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");

		if (session == null || user == null) {
			out.write("Failed to submit request: session error");
			return;
		}

		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<String> params = mapper.readValue(rawParams, ArrayList.class);

		int requestId = Integer.parseInt(params.get(0));
		String note = params.get(1);
		String status = params.get(2);

		String result = "Failed to resolve request";

		switch (status) {
		case "approve":
			if (Service.approveRequest(requestId, user.getUserId(), note)) {
				result = "Successfully approved Request #" + requestId;
			}
			break;
		case "deny":
			if (Service.denyRequest(requestId, user.getUserId(), note)) {
				result = "Successfully denied Request #" + requestId;
			}
			break;
		default:
		}

		out.write(result);
	}

}

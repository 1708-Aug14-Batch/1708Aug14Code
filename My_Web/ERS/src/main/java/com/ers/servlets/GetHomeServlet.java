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

@WebServlet("/gethome")
public class GetHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GetHomeServlet.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("in doPost");

		HttpSession session = request.getSession(false);
		if (session == null) {
			log.trace("null session");
			response.setStatus(418);
			return;
		}

		log.trace(request.getParameterMap().keySet());
		String rawParams = request.getParameterMap().keySet().toArray()[0].toString();
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		List<Boolean> params = mapper.readValue(rawParams, ArrayList.class);
		Boolean showEmployees = params.get(0);

		User user = (User) session.getAttribute(Service.USER_ATTR);
		if (user == null) {
			log.trace("session user is null");
			response.setStatus(418);
			return;
		}
		String url;
		if (user.isManager()) {
			if (showEmployees) {
				url = "frag/manHome2.html";
			}
			else {
				url = "frag/manHome.html";
			}
		}
		else {
			url = "frag/empHome.html";
		}

		request.getRequestDispatcher(url).forward(request, response);
		log.trace("responded with "+url);
	}
}

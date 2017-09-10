package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ers.pojos.User;
import com.ers.service.Service;

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
			return;
		}
		
		User user = (User) session.getAttribute(Service.USER_ATTR);
		if (user == null) {
			log.trace("session user is null");
			return;
		}
		String url = user.isManager() ? "frag/manHome.html" : "frag/empHome.html";
		
		request.getRequestDispatcher(url).forward(request, response);
		log.trace("responded with "+url);
	}
}

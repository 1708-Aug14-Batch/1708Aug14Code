package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.revature.logging.Logging;
import com.revature.service.Service;

public class ChangeUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = -2203144656220389003L;

	private static Logger logger = Logging.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("ChangeUserInfoServlet doPost()");
		
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Service service = Service.getFromSession(req.getSession());
		JSONObject obj = new JSONObject();
		
		resp.setContentType("application/json");
		
		obj.put("success", service.updateUserInfo(first, last, email, password));
		
		resp.getWriter().println(obj);
	}
}

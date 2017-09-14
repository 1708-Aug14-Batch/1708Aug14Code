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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5901784448217028279L;
	
	private static Logger log = Logging.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("LoginServlet doPost()");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Service s = Service.getFromSession(req.getSession());
		
		resp.setContentType("application/json");
		JSONObject obj = new JSONObject();
		
		if (s.doesUserExist(email)) {
			if (s.attemptLogin(email, password))
				obj.put("success", "success");
			else
				obj.put("success", "bad password");
		} else {
			obj.put("success", "bad email");
		}
		
		resp.getWriter().println(obj);
	}
}

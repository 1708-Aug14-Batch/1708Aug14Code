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

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = -793845528597489145L;
	
	private static Logger logger = Logging.getLogger();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("UserInfoServlet doPost()");
		
		resp.setContentType("application/json");
		
		Service service = Service.getFromSession(req.getSession());
		
		JSONObject obj = new JSONObject(service.getCurUser().toMap());
		
		resp.getWriter().println(obj);
	}
}

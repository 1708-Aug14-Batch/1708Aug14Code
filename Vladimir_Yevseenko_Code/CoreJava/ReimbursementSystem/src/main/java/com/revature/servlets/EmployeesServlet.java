package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.revature.logging.Logging;
import com.revature.pojos.User;
import com.revature.service.Service;

public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = -3156533466145222054L;
	
	private static Logger logger = Logging.getLogger();

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("EmployeeServlet doPost()");
		
		JSONArray arr = new JSONArray();
		
		Service service = Service.getFromSession(req.getSession());
		
		User[] users = service.getAllNonManagers();
		
		for (User user: users)
			arr.add(new JSONObject(user.toMap()));
		
		
		resp.setContentType("application/json");
		resp.getWriter().println(arr);
	}
}

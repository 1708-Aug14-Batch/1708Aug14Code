package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import com.revature.email.EmailSender;
import com.revature.logging.Logging;
import com.revature.passwordgenerator.PasswordGenerator;
import com.revature.service.Service;

public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 3979568826540168433L;
	
	private static Logger logger = Logging.getLogger();

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("RegisterServlet doPost()");
		
		
		Service service = Service.getFromSession(req.getSession());
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		
		boolean isManager = Boolean.valueOf(req.getParameter("isManager"));
		
		resp.setContentType("application/json");
		JSONObject obj = new JSONObject();
	
		String password;
		if (isManager) {
			password = req.getParameter("password");
		} else {
			PasswordGenerator pg = new PasswordGenerator();
			password = pg.generatePassword();
			EmailSender es = new EmailSender();
			es.sendEmail(email, password);
		}
		logger.debug("RegisterServlet firstName: " + firstName);
		logger.debug("RegisterServlet lastName: " + lastName);
		logger.debug("RegisterServlet email: " + email);
		logger.debug("RegisterServlet password: " + password);
		
		
		obj.put("success", service.addUser(firstName, lastName, email, password, isManager));
		
		resp.getWriter().print(obj);
	}
}

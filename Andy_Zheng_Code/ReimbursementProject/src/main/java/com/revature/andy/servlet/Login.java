package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revature.andy.service.Service;
import com.revature.andy.session.PseudoSession;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Service s = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = null;
		String pwd = null;

		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(req.getInputStream());

		while (!parser.isClosed()) {
			JsonToken jsonToken = parser.nextToken();

			if (JsonToken.FIELD_NAME.equals(jsonToken)) {
				String fieldName = parser.getCurrentName();
				if (fieldName.equals("email")) {
					jsonToken = parser.nextToken();
					email = parser.getValueAsString();
				} else if (fieldName.equals("password")) {
					jsonToken = parser.nextToken();
					pwd = parser.getValueAsString();
				}
			}
		}

		resp.setContentType("text/plain");
		
		if (email != null && pwd != null) {
			resp.getWriter().write(Integer.toString(s.login(email, pwd)));
			// resp.setStatus(200);
			resp.getWriter().close();
		}
	}

	/*
	 * PrintWriter pr = resp.getWriter();
	 * 
	 * String email = req.getParameter("email"); String pass =
	 * req.getParameter("pass");
	 * 
	 * if(PseudoSession.login(email, pass) == 1) {
	 * pr.println(PseudoSession.getCurrentUser().getFName() + " " +
	 * PseudoSession.getCurrentUser().getLName());
	 * //resp.sendRedirect("success.html"); } else if(PseudoSession.login(email,
	 * pass) == 2){ resp.sendRedirect("failurepassword.html"); }else {
	 * resp.sendRedirect("failure.html"); }
	 */

}

/**
 * 
 */
package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.annotation.WebServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.RUser;
import com.revature.service.ReimbursementService;

/**
 * This servlet handles login requests
 * @author Will Underwood
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -8744761542576381118L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> transactionKeys = parameterMap.keySet();
		Object obj = transactionKeys.toArray()[0];
		ObjectMapper jackson = new ObjectMapper();
		@SuppressWarnings("unchecked")
		ArrayList<String> transaction = jackson.readValue((String)obj, ArrayList.class);
		HttpSession session = request.getSession();
		ReimbursementService service = new ReimbursementService();
		String email = transaction.get(0);
		String password = transaction.get(1);
		String json = "";
		if (service.checkUserExists(email)) {
			if (service.validateUserCredentials(email, password)) {
				RUser user = service.getUser(email);
				session.setAttribute("user", user);
				ObjectMapper mapper = new ObjectMapper();
				json = mapper.writeValueAsString(user);
				if (user.isManager()) {
					response.sendRedirect(response.encodeRedirectURL("manager-home.html"));
				} else {
					response.sendRedirect(response.encodeRedirectURL("employee-home.html"));
				}
			} else {
				json = "password-incorrect";
				PrintWriter writer = response.getWriter();
				response.setContentType("application/json");
				writer.write(json);
			}
		} else {
			json = "user-not-exist";
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json");
			writer.write(json);
		}
	}

}

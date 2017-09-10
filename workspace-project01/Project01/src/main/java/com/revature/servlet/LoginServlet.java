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
				System.out.println("Inside LoginServlet doPost");
				response.sendRedirect(response.encodeRedirectURL("home.html"));
				//request.getRequestDispatcher("/home.html").forward(request, response);
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

		/*
						// stored in a cookie on the client's browser
						System.out.println("Logging user " + u.toString());

						// the parameters are the name, and the actual object that you want to store in the session
						System.out.println("forwarding to home");
						request.getRequestDispatcher("app.html")
						.forward(request, response);

		/*RUser user = this.dao.read(request.getParameter("email"));
		if (user == null) {
			request.getRequestDispatcher("/bad_email.html").forward(request, response);
		} else if (!user.getPassword().equals(request.getParameter("password"))) {
			request.getRequestDispatcher("/bad_password.html").forward(request, response);
		} else {
			this.checkIfUserIsManager(request, response, user);
		}*/
	}

	private void checkIfUserIsManager(HttpServletRequest request, HttpServletResponse response, RUser user)
			throws ServletException, IOException {
		if (user.isManager()) {
			request.getRequestDispatcher("/home.html").forward(request, response);
		} else {
			request.getRequestDispatcher("/home.html").forward(request, response);
		}
	}

}

package com.reimburse.servlets.oldcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesterServlet
 */
public class TesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TesterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Result will be null if the field was not available on that page
		// Result will be empty string if nothing is entered in the field
		String username = request.getParameter("usernameText");
		String password = request.getParameter("passwordText");

		method1(request, response, username, password);
		method2(request, response, username, password);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void method1(HttpServletRequest request, HttpServletResponse response, 
			String username, String password) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (username != null) {
			// TesterPage1.html
			if (username.isEmpty()) {
				sendAlert(out, "You must enter a username");
			} else
				response.sendRedirect("testerPage2.html");
		} else if (password != null) {
			// TesterPage2.html
			if (password.isEmpty())
				sendAlert(out, "You must enter a password");
			else
				response.sendRedirect("testerPage1.html");
		}
		
		System.out.println("method 1");

	}
	
	private void method2(HttpServletRequest request, HttpServletResponse response, 
			String username, String password) throws IOException, ServletException {		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (username != null) {
			// TesterPage1.html
			if (username.isEmpty()) {
				setMessage(out, "You must enter a username");
			} else
				response.sendRedirect("testerPage2.html");
		} else if (password != null) {
			// TesterPage2.html
			if (password.isEmpty())
				setMessage(out, "You must enter a password");
			else
				response.sendRedirect("testerPage1.html");
		}

		System.out.println("method 2");
	}
	
	private void sendAlert(PrintWriter out, String alert) {
		out.println("<script type=\"text/javascript\">");
		out.append("alert('" + alert + "')");
		out.println("</script>");
	}
	
	private void setMessage(PrintWriter out, String message) {
		out.println("<script type=\"text/javascript\">");
		out.append("var display = document.getElementById('error_display');");
		out.append("display.innerHTML = " + message);
		out.println("</script>");
	}

}

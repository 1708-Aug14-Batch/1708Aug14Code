package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.pojos.User;
import com.bank.service.Service;

/**
 * Servlet implementation class LoggedInServlet
 */
public class LoggedInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoggedInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter page = response.getWriter();
		User u;
		Service serve = new Service();
		String usr = request.getParameter("username");
		String pass = request.getParameter("password");
		u=serve.login(usr, pass);
		String name = u.getFirstname();
		page.println("<!DOCTYPE html>"
				+ "<html>\n"
				+"<head>\n" 
				+"<meta charset=\"UTF-8\">\n" 
				+"<title>Login Page</title>\n"
				+"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\" integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">\n"  
				+"<!-- <style>\n" 
				+"* { font: helvetica;\n" 
				+"}\n" 
				+"</style> -->\n" 
				+"</head>\n" 
				+"<body>"
				+ "<h1>");
		page.print("Welcome back "+name+" </h1> ");
		
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

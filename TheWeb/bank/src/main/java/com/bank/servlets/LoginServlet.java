package com.bank.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service; 	

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
//	@Override
//	public void init() throws ServletException {
//		super.init();
//		System.out.println("initializing login servlet");
//		
//		
//	}
	
	protected String servletConfigParam = null;
//	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		
//		System.out.println("intializing with params");
//		this.servletConfigParam = config.getInitParameter("param");
//		String servletContextParam = getServletContext().getInitParameter("myParam");
//		System.out.println("config param = " + servletConfigParam);
//		System.out.println("context param = "  + servletContextParam);
//	}

	static Service service = new Service();
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logging in - log in servlet");
		
		
		HttpSession session = request.getSession();


		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		int id = service.validateUser(email);
		if(id < 0){
			RequestDispatcher rd = request.getRequestDispatcher("home.html");
			session.setAttribute("message", "Invalid user");
			rd.forward(request, response); // invalid user
		}
		else{
			User u = service.login(id, pass);
			if(u == null){
				session.setAttribute("message", "Incorrect Password");
				RequestDispatcher rd = request.getRequestDispatcher("home.html");
				rd.forward(request, response); // password is wrong 
			}
			else{
				
				 //j_session_id stored in a cookie on the client's browser
				session.setAttribute("user", u);
				 //the parameters are the name, and the actual object that you want to store in the session
				
				System.out.println("forwarding to home");
				request.getRequestDispatcher("app.html").forward(request, response);
				
			}
		}
		
	
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroying login servlet");
	}




}

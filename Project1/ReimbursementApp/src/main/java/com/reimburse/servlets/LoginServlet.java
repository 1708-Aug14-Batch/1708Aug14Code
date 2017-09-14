package com.reimburse.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(LoginServlet.class);
	
	@Override protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		RequestDispatcher sd;

		//session + writer + service + mapper
		HttpSession session = req.getSession();
		PrintWriter writer = res.getWriter();
		Service bankService = new Service();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(!bankService.existsUsername(username)){
			String response = "username";

			logger.error("Username '"+username+"' was not found");
			res.setContentType("application/json");
			writer.print(response);
			return;
		}
		User user = bankService.getUser(username, password);
		
		//see if success, new User is fail
		if(user.getUserId() == 0){
			String response = "password";
			logger.error("Username '"+username+"' failed login w/ pass: "+password);
			res.setContentType("application/json");
			writer.print(response);
		}
		else{
		    logger.info("User "+user.getUserId()+" has logged in.");
			session.setAttribute("userid", user.getUserId());
		    session.setAttribute("usertype",user.getIsManager());
		    
		    sd = req.getRequestDispatcher("homepage");
		    sd.forward(req, res);
		}
	}
}

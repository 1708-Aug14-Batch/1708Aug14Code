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

import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		RequestDispatcher sd;

		//session + writer + service + mapper
		HttpSession session = req.getSession();
		PrintWriter writer = res.getWriter();
		Service bankService = new Service();
		
		System.out.println(req.getParameter("username")+ " : "+req.getParameter("password"));
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(!bankService.existsUsername(username)){
			String response = "username";
//			sd = req.getRequestDispatcher("/login_fail_username.html");
//			sd.forward(req, res);
			System.out.println(response);
			res.setContentType("application/json");
			writer.print(response);
			return;
		}
		User user = bankService.getUser(username, password);
		
		//see if success, new User is fail
		if(user.getUserId() == 0){
			String response = "password";
			System.out.println(response);
			res.setContentType("application/json");
			writer.print(response);
//			sd = req.getRequestDispatcher("/login_fail_password.html");
//			sd.forward(req, res);
		}
		else{
		    
			session.setAttribute("userid", user.getUserId());
		    session.setAttribute("usertype",user.getIsManager());
		    
		    sd = req.getRequestDispatcher("homepage");
		    sd.forward(req, res);
//		    if(user.getIsManager() == (byte) 0){
//		    	res.sendRedirect("homepage.html");
//		    }
//		    else{
//		    	res.sendRedirect("manager_homepage.html");
//		    }
		}
	}
}

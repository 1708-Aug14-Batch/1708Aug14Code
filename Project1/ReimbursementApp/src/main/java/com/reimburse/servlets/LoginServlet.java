package com.reimburse.servlets;

import java.io.IOException;

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
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Service bankService = new Service();
		if(!bankService.existsUsername(username)){
			sd = req.getRequestDispatcher("/login_fail_username.html");
			sd.forward(req, res);
			return;
		}
		User user = bankService.getUser(username, password);
		
		//see if success, new User is fail
		if(user.getUserId() == 0){
			sd = req.getRequestDispatcher("/login_fail_password.html");
			sd.forward(req, res);
		}
		else{
			HttpSession session = req.getSession();
		    
			session.setAttribute("userid", user.getUserId());
		    session.setAttribute("usertype",user.getIsManager());
		    
		    if(user.getIsManager() == (byte) 0){
		    	res.sendRedirect("homepage.html");
		    }
		    else{
		    	res.sendRedirect("manager_homepage.html");
		    }
		}
	}
}

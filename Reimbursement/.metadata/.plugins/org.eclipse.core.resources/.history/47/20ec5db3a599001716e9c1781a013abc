package com.reimburse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimburse.pojos.User;
import com.reimburse.service.Services;

@WebServlet("/getUserInfo")
public class GetUserInfo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Get User Servlet");
		Services service = new Services();
		HttpSession session = req.getSession();
		User sessionUser = (User)session.getAttribute("user");
		System.out.println("Getting user" + sessionUser.toString());
		
		if(sessionUser != null){
			
		}
		
		
	}
	
}
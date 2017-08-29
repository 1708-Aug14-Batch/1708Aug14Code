package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardRedirectServlets extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		//forwarding
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		rd.forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		//redirect
		res.sendRedirect("hello");
	}
}


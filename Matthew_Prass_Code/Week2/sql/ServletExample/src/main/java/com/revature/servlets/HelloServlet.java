package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		//System.out.println("Hello servlet!");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		System.out.println(name +" "+pass);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		System.out.println(name +" "+pass);
	}
}

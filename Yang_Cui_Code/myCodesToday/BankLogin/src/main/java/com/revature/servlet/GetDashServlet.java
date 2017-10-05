package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getDashboard")
public class GetDashServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.getRequestDispatcher("dashboard.html").forward(req, res);
	}
}

//FLOW
/*
 * Start app in login form.. mine is at home.html from has the action tag of login with method ost, taking
 */
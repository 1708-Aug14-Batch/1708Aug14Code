package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.andy.pojos.User;

//@WebServlet("/loadMenu")
@WebServlet(name="loadMenu", urlPatterns="/loadMenu", loadOnStartup=3)
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User sessionUser = (User) session.getAttribute("User");
		if(sessionUser.getIsManager() == 1) {
			req.getRequestDispatcher("menuM.html").forward(req, resp);
		}else {
			req.getRequestDispatcher("menuE.html").forward(req, resp);
		}	
	}
}


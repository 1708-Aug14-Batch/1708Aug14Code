package com.reimb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimb.pojo.Users;

@SuppressWarnings("serial")
@WebServlet("/getDashboard")
public class GetDashServlet extends HttpServlet{
	/*protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession session =req.getSession();
		Users sessionUser=(Users)session.getAttribute("user");
		System.out.println("in dashboard servlet");
		if(sessionUser.getIsMananger())
			req.getRequestDispatcher("partials/dashManager.html").forward(req, res);
		else
			req.getRequestDispatcher("partials/dashEmployee.html").forward(req, res);
	}*/
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("in dashboard servlet");
		req.getRequestDispatcher("partials/dashEmployee.html").forward(req, resp);
	}
}

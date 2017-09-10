package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.RUser;

@WebServlet("/homepage")
public class HomepageServlet extends HttpServlet {

	private static final long serialVersionUID = 1597399747209416024L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		RUser user = (RUser) session.getAttribute("user");
		System.out.println("Inside HomepageServlet doGet");
		if (user.isManager()) {
			System.out.println("Is manager");
			request.getRequestDispatcher("partial/home-manager.html").forward(request, response);
		} else {
			System.out.println("Is employee");
			request.getRequestDispatcher("partial/home-employee.html").forward(request, response);
		}
	}

}

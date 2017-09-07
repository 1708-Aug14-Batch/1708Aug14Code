package com.revature.andy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;
import com.revature.andy.session.PseudoSession;


@WebServlet("/loadLogin")
public class LoginServlet extends HttpServlet {

	Service s = new Service();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = s.getUserByID(181);
		HttpSession session = req.getSession();
		session.setAttribute("User", u);
		
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
}

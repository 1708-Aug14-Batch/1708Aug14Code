package com.pone.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pone.pojos.AUser;
import com.pone.pojos.RStatus;
import com.pone.service.Service;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//System.out.println(session);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int id = service.validateUser(username);
		ArrayList<RStatus> allStatus = service.getReimbursementStatuses();
		
		String alert = "";
		
		if(id < 0){
			alert = "window.alert(\"Invalid user. Please try again\")";
			request.setAttribute("loginAlert", "Invalid Username! Please try again.");
			request.getRequestDispatcher("login.jsp").forward(request, response); // invalid user
		}
		else{
			AUser u = service.login(id, password);
			if(u == null){
				request.setAttribute("loginAlert", "Invalid password! Please try again.");
				request.getRequestDispatcher("login.jsp").forward(request, response); // invalid password
			}
			else{
				if(u.getIsManager()==0) { // is not a manager
					RequestDispatcher rd = request.getRequestDispatcher("employeehome.html");
					session.setAttribute("auser", u);
					session.setAttribute("rstatuses", allStatus);
					rd.forward(request, response); // successful login
				}
				else { // is a manager
					RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
					session.setAttribute("auser", u);
					session.setAttribute("rstatuses", allStatus);
					rd.forward(request, response); // successful login
				}
			}
		}
	}



}
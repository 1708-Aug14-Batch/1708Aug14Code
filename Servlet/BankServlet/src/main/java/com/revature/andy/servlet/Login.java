package com.revature.andy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.andy.service.Service;
import com.revature.andy.session.PseudoSession;

public class Login extends HttpServlet{

	Service s = new Service();
/*	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		pw.write("hello");

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		if(PseudoSession.login(email, pass) == 1) {
			pw.write(PseudoSession.getCurrentUser().getFName());
			pw.write(PseudoSession.getCurrentUser().getLName());
			pw.write("logged in");
		}
		else if(PseudoSession.login(email, pass) == 2){
			pw.write("wrong password");
		}else {
			pw.write("Failure");
		}
	}
*/

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		if(PseudoSession.login(email, pass) == 1) {
			HttpSession session = req.getSession();
			session.setAttribute("User", PseudoSession.getCurrentUser());
			session.setAttribute("FullName",(PseudoSession.getCurrentUser().getFName() + " " + PseudoSession.getCurrentUser().getLName()));
			System.out.println("logged in");
			resp.sendRedirect("app.html");
		}
		else if(PseudoSession.login(email, pass) == 2){
			System.out.println("wrong password");
			resp.sendRedirect("failurepassword.html");
		}else {
			System.out.println("Failure");
			resp.sendRedirect("failure.html");
		}
	}
}

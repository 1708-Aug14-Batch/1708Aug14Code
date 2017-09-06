package com.bank.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;
import com.bank.service.Service;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	//Service s = new Service();
	static Service s = new Service();

//	@Override
//	public void init() throws ServletException {
//		super.init();
//		System.out.println("init!");
//	}
	protected String servConParam = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init with params oooooooo");
		this.servConParam = config.getInitParameter("param");
		System.out.println(servConParam);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		HttpSession sesh = req.getSession();
		
		String email = req.getParameter("name");
		String pass = req.getParameter("paw");
		int id = s.validateUser(email);
		if(id < 0){
			req.getRequestDispatcher("fail.html").forward(req, res);
		}
		else {
			User u = s.loginForServlet(id, pass);
			if(u == null){
				req.getRequestDispatcher("fail.html").forward(req, res);
			}
			
			else{
				sesh.setAttribute("user", u);
				req.getRequestDispatcher("success.html").forward(req, res);
			}
		}
	}
	
	
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
//		String email = req.getParameter("name");
//		String pass = req.getParameter("paw");
//		int id = s.validateUser(email);
//		if(id < 0){
//			res.sendRedirect("fail.html");
//		}
//		else {
//			User u = s.loginForServlet(id, pass);
//			if(u == null){
//				res.sendRedirect("fail.html");
//			}
//			
//			else{
//				String message = u.getFirstname();
//		        req.setAttribute("message", message);
//		        req.getRequestDispatcher("success.jsp").forward(req, res);
//				//res.sendRedirect("success.jsp");
//			}
//		}
//	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("DEEEstroyed");
	}
}

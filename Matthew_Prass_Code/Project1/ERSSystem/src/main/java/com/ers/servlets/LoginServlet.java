package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.pojos.Employee;
import com.ers.service.Service;

public class LoginServlet  extends HttpServlet{
	
	static Service s = new Service();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		HttpSession sesh = req.getSession();
		
		
		String email = req.getParameter("name");
		String username = req.getParameter("username");
		String pass = req.getParameter("paw");
		int id = s.validateEmployee(email,username);
		System.out.println(id);
		if(id < 0){
			req.getRequestDispatcher("fail.html").forward(req, res);
		}
		else {
			Employee e = s.login(id, pass);
			if(e == null){
				req.getRequestDispatcher("fail.html").forward(req, res);
			}
			
			else{
				if(e.getIsManager() == 0) {
					sesh.setAttribute("employee", e);
					req.getRequestDispatcher("employee.html").forward(req, res);
				}
				else 
					req.getRequestDispatcher("manager.html").forward(req, res);
			}
		}
	}

}

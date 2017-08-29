package com.bank.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet{
	
	//Service s = new Service();
	static Service s = new Service();

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		String email = req.getParameter("name");
		String pass = req.getParameter("paw");
		int id = s.validateUser(email);
		if(id < 0){
			res.sendRedirect("fail.html");
		}
		else {
			User u = s.loginForServlet(id, pass);
			if(u == null){
				res.sendRedirect("fail.html");
			}
			
			else{
				String message = u.getFirstname();
		        req.setAttribute("message", message); // This will be available as ${message}
		        req.getRequestDispatcher("success.jsp").forward(req, res);
				res.sendRedirect("success.jsp");
			}
		}
	}

}

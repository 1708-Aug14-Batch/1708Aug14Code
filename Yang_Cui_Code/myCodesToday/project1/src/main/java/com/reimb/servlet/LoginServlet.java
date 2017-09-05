package com.reimb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.DAO;
import com.revature.dao.DaoImpl;
import com.revature.pojo.User;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//System.out.println("Hello Servlet");
		String id=req.getParameter("UserID");
		String pass=req.getParameter("Password");
		System.out.println(id);
		System.out.println(pass);
		
		DAO dao = new DaoImpl();
		User user = dao.authentication(Integer.parseInt(id), pass);
		if(user==null){
			System.out.println("redirect to fail page");
			RequestDispatcher rd= req.getRequestDispatcher("fail.html"); // /hello instead html page we can also forward to a servlet
			rd.forward(req, res);
		}else{
			System.out.println("redirect to sucess page");
			RequestDispatcher rd= req.getRequestDispatcher("sucess.html"); // /hello instead html page we can also forward to a servlet
			rd.forward(req, res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

	}
}

package com.reimb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimb.main.DBControl;
import com.reimb.pojo.Users;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//System.out.println("Hello Servlet");
		HttpSession session =req.getSession();
		String uname=req.getParameter("UserName");
		String pass=req.getParameter("Password");
		//System.out.println(uname);
		//System.out.println(pass);
		
		DBControl dbcon=new DBControl();
		Users user =dbcon.Authentication(uname, pass);

		if(user==null){
			//System.out.println("redirect to fail page");
			RequestDispatcher rd= req.getRequestDispatcher("fail.html"); // /hello instead html page we can also forward to a servlet
			rd.forward(req, res);
		}else if(user.getIsMananger()){
			//System.out.println("redirect to Manager page");
			RequestDispatcher rd= req.getRequestDispatcher("manager.html"); // /hello instead html page we can also forward to a servlet
			session.setAttribute("user",user);
			rd.forward(req, res);
		}else{
			//System.out.println("redirect to Employee page");
			RequestDispatcher rd= req.getRequestDispatcher("employee.html"); // /hello instead html page we can also forward to a servlet
			session.setAttribute("user",user);
			rd.forward(req, res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//System.out.println("Hello Servlet");
		HttpSession session =req.getSession();
		String uname=req.getParameter("UserName");
		String pass=req.getParameter("Password");
		//System.out.println(uname);
		//System.out.println(pass);
		
		DBControl dbcon=new DBControl();
		Users user =dbcon.Authentication(uname, pass);

		if(user==null){
			//System.out.println("redirect to fail page");
			RequestDispatcher rd= req.getRequestDispatcher("fail.html"); // /hello instead html page we can also forward to a servlet
			rd.forward(req, res);
		}else if(user.getIsMananger()){
			//System.out.println("redirect to Manager page");
			RequestDispatcher rd= req.getRequestDispatcher("manager.html"); // /hello instead html page we can also forward to a servlet
			session.setAttribute("user",user);
			rd.forward(req, res);
		}else{
			//System.out.println("redirect to Employee page");
			RequestDispatcher rd= req.getRequestDispatcher("employee.html"); // /hello instead html page we can also forward to a servlet
			session.setAttribute("user",user);
			rd.forward(req, res);
		}
	}
}

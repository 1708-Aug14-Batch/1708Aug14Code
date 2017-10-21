package com.bank.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.User;
import com.bank.service.Service;

public class LoginServlet extends HttpServlet{
	static int load = 0;


	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException{


		BufferedReader read = new BufferedReader(new FileReader("/Users/emmabownes/my_git_repos/1708Aug14Code/Web/BankingApp/src/main/webapp/Index.html"));
		String text;
		while((text = read.readLine()) != null) {
			if(load>0)
			{
				if(text.equals("<body>")) {
					text = text.concat("<p style=\"color: red;\"> Username or password incorrect</p>");
				}
			}
			PrintWriter pr = res.getWriter();
			pr.print(text);
		}

	}

	@Override
	public void doPost(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException{
		Service serve = new Service();

		HttpSession session = req.getSession(); 

		String usr = req.getParameter("username");
		String pwd = req.getParameter("password");

		System.out.println(usr+pwd);
		User u = Service.login(usr, pwd);
		
		if(u!=null) {
			load=0;
			session.setAttribute("user", u);
			RequestDispatcher rd = req.getRequestDispatcher("App.html");
			rd.forward(req, res);
		}
		else {
			load++;
			res.sendRedirect("login");
		}


	}

}

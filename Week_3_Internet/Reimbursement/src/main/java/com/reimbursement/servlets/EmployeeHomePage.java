package com.reimbursement.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;


@WebServlet("/HomePage")
public class EmployeeHomePage extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		Service service = new Service();
		LoginServlet login = new LoginServlet();

//		User user = service.loginUser(email);
//		
//		PrintWriter write = res.getWriter();
//		write.write(user.getFirstname() + " " + user.getLastname());
		
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		
		
		
		
		
	}
	

}

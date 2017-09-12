package com.bank.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/addAccount")
public class CreateAccountServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("posting new account to db");
		
		
				//convert the JSON string into the class specified in the 2nd argument
		String accType = request.getParameter("accType");
		System.out.println("creating account of type " + accType);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		
		Service service = new Service();
		Account temp = service.addAccount(user, accType);
		
		System.out.println(temp.toString());
		
		session.setAttribute("user", user);
		session.setAttribute("newAcc", temp);
		
		request.getRequestDispatcher("partials/dashboard.html");
		
	}
	
}

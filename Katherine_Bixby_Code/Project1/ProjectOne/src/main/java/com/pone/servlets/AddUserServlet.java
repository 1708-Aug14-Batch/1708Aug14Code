package com.pone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pone.service.Service;


@WebServlet("/addEmp")
public class AddUserServlet {

	static Service service = new Service();
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("managerhome.html");
		//session.setAttribute("auser", theUpdated);
		rd.forward(request, response);
		
		
	}
	
}

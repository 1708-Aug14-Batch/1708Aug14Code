package com.bank.servlets.oldcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getLoginView")
public class GetLoginViewServlet extends HttpServlet{

	
	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = -8093497423657393144L;

	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws
			ServletException, IOException{
		
		System.out.println("in loginview servlet");
		
		
		req.getRequestDispatcher("testing/test.html")
		.forward(req, resp);
	}
}
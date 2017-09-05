package com.reimb.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reimb.main.DBControl;

public class SumbitServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String userID=req.getParameter("userID");
		String description=req.getParameter("description");
		String amount=req.getParameter("amount");
		DBControl dbcon=new DBControl();
		boolean sucess=dbcon.SumbitRemib(userID, description, amount);
		
		if(sucess){
			
		}else{
			
		}
	}
}

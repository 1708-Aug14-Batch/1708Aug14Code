package com.pone.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pone.pojos.AUser;
import com.pone.pojos.Reimbursement;
import com.pone.service.Service;

@WebServlet("/submitReimb")
public class SubmitReimbursementServlet extends HttpServlet {
	
	static Service service = new Service();
	
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		AUser loggedUser = (AUser) session.getAttribute("auser");
		Reimbursement toSubmit = new Reimbursement();
		double amt = Double.parseDouble(request.getParameter("subamount"));
		String checkamt = request.getParameter("subamount");
		if(checkamt == null || checkamt=="") {
			amt=0;
		}
		String desc = request.getParameter("subdesc");
		if(desc == null) {
			desc="";
		}
		int theUID = loggedUser.getU_id();
		toSubmit = service.addReimbursement(theUID, desc, amt);
		RequestDispatcher rd = request.getRequestDispatcher("employeehome.html");
		session.setAttribute("newReimb", toSubmit);
		rd.forward(request, response);
		
		
	}



}
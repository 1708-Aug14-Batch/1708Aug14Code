package com.reimburse.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/submitreimbursement")
public class SubmitReimbursementServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		Service bankService = new Service();
		
		User user = bankService.getUser((int)session.getAttribute("userid"));
		Reimbursement newReimbursement = new Reimbursement();
		
		newReimbursement.setAmount(new BigDecimal(req.getParameter("amount")));
		newReimbursement.setDescription(req.getParameter("description"));
		newReimbursement.setSubmitId(user.getUserId());
		
		bankService.addReimbursement(newReimbursement);

		res.sendRedirect("homepage.html");
	}
}

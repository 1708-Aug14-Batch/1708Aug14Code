package com.reimbursement.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reimbursement.pojos.Reimbursement;
import com.reimbursement.pojos.ReimbursementStatus;
import com.reimbursement.pojos.User;
import com.reimbursement.service.Service;

public class RequestReimbursementServlet extends HttpServlet {

	private Service runApp = new Service();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User tmp = (User)session.getAttribute("user");
		if (tmp == null) {
			response.sendRedirect("login.html");
			return;
		}
		else {
			BigDecimal amount = new BigDecimal(request.getParameter("amount"));
			String desc = request.getParameter("desc");

			Reimbursement r = new Reimbursement();
			r.setSubmitter(tmp);
			r.setAmount(amount);
			r.setDescription(desc);
			r.setStatus(ReimbursementStatus.PENDING);
			
			runApp.submitRequest(r);
			
			response.sendRedirect("employee.html");
			return;
		}
	}
}

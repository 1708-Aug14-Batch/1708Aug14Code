package com.reimburse.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;
import com.reimburse.service.Service;

@WebServlet("/submitreimbursement")
public class SubmitReimbursementServlet extends HttpServlet{
	final static Logger logger = Logger.getLogger(SubmitReimbursementServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		Service bankService = new Service();
		
		User user = bankService.getUser((int)session.getAttribute("userid"));
		Reimbursement newReimbursement = new Reimbursement();
		
		newReimbursement.setAmount(new BigDecimal(req.getParameter("amount")));
		
		String description = req.getParameter("description");
		if(description.equals("")){
			description = "N/A";
		}
		newReimbursement.setDescription(description);
		newReimbursement.setSubmitId(user.getUserId());
		
		bankService.addReimbursement(newReimbursement);

		logger.info("Reimbursement Submitted:" + newReimbursement.toString());
		res.sendRedirect("homepage.html");
	}
}

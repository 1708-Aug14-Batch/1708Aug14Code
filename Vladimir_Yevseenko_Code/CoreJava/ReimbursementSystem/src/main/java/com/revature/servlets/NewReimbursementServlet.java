package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.logging.Logging;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.Status;
import com.revature.pojos.User;
import com.revature.service.Service;

public class NewReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = -1538576759461590085L;
	
	private static Logger logger = Logging.getLogger();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("NewReimbursementServlet doPost()");
		
		resp.setContentType("text/plain");
		
		String description = req.getParameter("description");
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		Service service = Service.getFromSession(req.getSession());
		
		User curUser = service.getCurUser();
		
		Date submitDate = new Date(Calendar.getInstance().getTime().getTime());
		
		Reimbursement reimbursement = new Reimbursement(curUser,
														curUser,
														submitDate,
														submitDate,
														Status.PENDING,
														description,
														amount);
		
		service.addNewReimbursement(reimbursement);
	}
}

package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.revature.logging.Logging;
import com.revature.pojos.Reimbursement;
import com.revature.service.Service;

public class YourReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 7822453862694525041L;
	
	private static Logger logger = Logging.getLogger();

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("YourReimbursementsServlet doPost()");
		
		Service service = Service.getFromSession(req.getSession());
		
		JSONArray arr = new JSONArray();
		Reimbursement[] reimbursements = service.getUsersReimbursements();
		
		for (Reimbursement reimbursement: reimbursements)
			arr.add(new JSONObject(reimbursement.toMap()));
		
		resp.setContentType("application/json");
		resp.getWriter().println(arr);
	}
}

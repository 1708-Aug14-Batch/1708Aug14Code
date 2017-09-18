package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dto.UserEditDTO;
import com.revature.model.RUser;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbursementService;
import com.revature.util.Status;

/**
 * Shows the form for submitting reimbursements 
 * and submits reimbursement data to the database.
 * @author Will Underwood
 */
@WebServlet("/employee-submit-request")
public class EmployeeSubmitReimbServlet extends HttpServlet {
	
	private static final long serialVersionUID = -4145403106447195223L;
	private ReimbursementService service = new ReimbursementService();
	private static final String SUBMIT_REQUEST_VIEW = "partial/employee/submit-request.html";
	private static final String VIEW_ALL_REQUESTS_VIEW = "partial/employee/view-all-requests.html";
	private static final String FAILURE = "Failed to submit reimbursement request";
	
	/**
	 * View
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher(SUBMIT_REQUEST_VIEW).forward(request, response);
	}
	
	/**
	 * Data
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Enumeration<String> requestParams = request.getParameterNames();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = requestParams.nextElement();
		Reimbursement reimb = (Reimbursement) mapper.readValue(jsonString, Reimbursement.class);
		RUser submitter = (RUser) request.getSession().getAttribute("user");
		reimb.setSubmitterID(submitter.getRUserID());
		reimb.setResolverID(100); // TODO Do not hard code resolver ID
		Date utilDateSubmitted = new Date();
		java.sql.Date sqlDateSubmitted = new java.sql.Date(utilDateSubmitted.getTime());
		reimb.setDateSubmitted(sqlDateSubmitted);
		reimb.setStatusID(Status.PENDING.getValue());
		boolean submitSuccess = (0 != this.service.submitReimb(reimb));
		if (submitSuccess) {
			request.getRequestDispatcher(VIEW_ALL_REQUESTS_VIEW).forward(request, response);
		} else {
			PrintWriter writer = response.getWriter();
			writer.print(FAILURE);
		}
	}

}

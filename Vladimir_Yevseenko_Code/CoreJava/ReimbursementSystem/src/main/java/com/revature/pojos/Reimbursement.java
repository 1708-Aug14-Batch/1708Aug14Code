package com.revature.pojos;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.revature.logging.Logging;

public class Reimbursement {
	private int id;
	private User submitter, resolver;
	private Date submissionDate, resolutionDate;
	private Status status;
	private String description;
	double amount;
	
	private static Logger log = Logging.getLogger();
	
	public Reimbursement() {
		log.debug("Reimbursement() created");
	}
	
	
	public Reimbursement(int id, User submitter, User resolver, Date submissionDate,
			Date resolutionDate, Status reimbursementStatus, String description, double amount) {
		this.id = id;
		this.submitter = submitter;
		this.resolver = resolver;
		this.submissionDate = submissionDate;
		this.resolutionDate = resolutionDate;
		this.status = reimbursementStatus;
		this.description = description;
		this.amount = amount;
		log.debug("Reimbursement(...) created");
	}
	
	public int getId() {
		return id;
	}
	
	public User getSubmitter() {
		return submitter;
	}
	
	public User getResolver() {
		return resolver;
	}
	
	public Date getSubmissionDate() {
		return submissionDate;
	}
	
	public Date getResolutionDate() {
		return resolutionDate;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public String getDescription() {
		return description;
	}
	
}

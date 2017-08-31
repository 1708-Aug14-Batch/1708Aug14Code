package com.revature.andy.pojos;

import java.sql.Date;

public class Reimbursement {
			 
	private int reimID;
	private User submitterID;
	private User resolverID;
	private Date submitDate;
	private Date resolveDate;
	private ReimStatus statusID;
	private String description;
	private String notes;
	private double amount;
	
	public Reimbursement() {}

	public Reimbursement(int reimID, User submitterID, User resolverID, Date submitDate, Date resolveDate,
			ReimStatus statusID, String description, String notes, double amount) {
		super();
		this.reimID = reimID;
		this.submitterID = submitterID;
		this.resolverID = resolverID;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.statusID = statusID;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
	}

	public int getReimID() {
		return reimID;
	}

	public void setReimID(int reimID) {
		this.reimID = reimID;
	}

	public User getSubmitterID() {
		return submitterID;
	}

	public void setSubmitterID(User submitterID) {
		this.submitterID = submitterID;
	}

	public User getResolverID() {
		return resolverID;
	}

	public void setResolverID(User resolverID) {
		this.resolverID = resolverID;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}

	public ReimStatus getStatusID() {
		return statusID;
	}

	public void setStatusID(ReimStatus statusID) {
		this.statusID = statusID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	};
	
}

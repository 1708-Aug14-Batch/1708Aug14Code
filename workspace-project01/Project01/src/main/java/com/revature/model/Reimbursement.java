package com.revature.model;

import java.sql.Date;

public class Reimbursement {
	
	private int rID;
	private int submitterID;
	private int resolverID;
	private Date dateSubmitted;
	private Date dateResolved;
	private int statusID;
	private String description;
	private String resolutionNotes;
	private double amount;
	
	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}
	
	public int getReimbursementID() {
		return rID;
	}
	
	public void setReimbursementID(int reimbursementID) {
		this.rID = reimbursementID;
	}
	
	public int getSubmitterID() {
		return submitterID;
	}
	
	public void setSubmitterID(int submitterID) {
		this.submitterID = submitterID;
	}
	
	public int getResolverID() {
		return resolverID;
	}
	
	public void setResolverID(int resolverID) {
		this.resolverID = resolverID;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public int getStatusID() {
		return statusID;
	}
	
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getResolutionNotes() {
		return resolutionNotes;
	}
	
	public void setResolutionNotes(String resolutionNotes) {
		this.resolutionNotes = resolutionNotes;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + rID + ", submitterID=" + submitterID + ", resolverID="
				+ resolverID + ", dateSubmitted=" + dateSubmitted + ", dateResolved=" + dateResolved + ", statusID="
				+ statusID + ", description=" + description + ", resolutionNotes=" + resolutionNotes + ", amount="
				+ amount + "]";
	}
}

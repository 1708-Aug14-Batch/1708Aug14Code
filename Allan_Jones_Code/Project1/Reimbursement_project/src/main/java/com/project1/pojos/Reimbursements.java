package com.project1.pojos;

public class Reimbursements {
	private int submitterID;
	private int resolverID;
	private String submitDate;
	private String resolvedDate;
	private int statusID;
	private String resolution_notes;
	private double amount;
	
	public Reimbursements() {}
	
	public Reimbursements(int submitterID, int resolverID, String submitDate, String resolvedDate, int statusID,
			String resolution_notes, double amount) {
		super();
		this.submitterID = submitterID;
		this.resolverID = resolverID;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.statusID = statusID;
		this.resolution_notes = resolution_notes;
		this.amount = amount;
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

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getResolution_notes() {
		return resolution_notes;
	}

	public void setResolution_notes(String resolution_notes) {
		this.resolution_notes = resolution_notes;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Reimbursements [submitterID=" + submitterID + ", resolverID=" + resolverID + ", submitDate="
				+ submitDate + ", resolvedDate=" + resolvedDate + ", statusID=" + statusID + ", resolution_notes="
				+ resolution_notes + ", amount=" + amount + "]";
	}
	
}

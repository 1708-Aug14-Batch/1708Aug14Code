package com.project1.pojos;

public class Reimbursements {
	private int submitterID;
	private int resolverID;
	private String submit_date;
	private String resolved_date;
	private int statusID;
	private String description;
	private String resolution_notes;
	private double amount;
	
	public Reimbursements() {}

	public Reimbursements(int submitterID, int resolverID, String submit_date, String resolved_date, int statusID,
			String description, String resolution_notes, double amount) {
		super();
		this.submitterID = submitterID;
		this.resolverID = resolverID;
		this.submit_date = submit_date;
		this.resolved_date = resolved_date;
		this.statusID = statusID;
		this.description = description;
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

	public String getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}

	public String getResolved_date() {
		return resolved_date;
	}

	public void setResolved_date(String resolved_date) {
		this.resolved_date = resolved_date;
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
		return "Reimbursements [submitterID=" + submitterID + ", resolverID=" + resolverID + ", submit_date="
				+ submit_date + ", resolved_date=" + resolved_date + ", statusID=" + statusID + ", description="
				+ description + ", resolution_notes=" + resolution_notes + ", amount=" + amount + "]";
	}

}

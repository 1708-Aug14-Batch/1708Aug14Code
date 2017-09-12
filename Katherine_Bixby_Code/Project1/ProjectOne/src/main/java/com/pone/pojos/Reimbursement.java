package com.pone.pojos;

import java.sql.Timestamp;

public class Reimbursement {

	int r_id;
	int submitterId;
	int resolverId;
	Timestamp submitDate;
	Timestamp resolveDate;
	int statusId;
	String description;
	String resolveNotes;
	double amount;
	
	public Reimbursement() {}
	
	public Reimbursement(int r_id, int submitterId, int resolverId, Timestamp submitDate, Timestamp resolveDate, int statusId,
			String description, String resolveNotes, double amount) {
		super();
		this.r_id = r_id;
		this.submitterId = submitterId;
		this.resolverId = resolverId;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
		this.statusId = statusId;
		this.description = description;
		this.resolveNotes = resolveNotes;
		this.amount = amount;
	}

	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public Timestamp getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResolveNotes() {
		return resolveNotes;
	}

	public void setResolveNotes(String resolveNotes) {
		this.resolveNotes = resolveNotes;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", submitterId=" + submitterId + ", resolverId=" + resolverId
				+ ", submitDate=" + submitDate + ", resolveDate=" + resolveDate + ", statusId=" + statusId
				+ ", description=" + description + ", resolveNotes=" + resolveNotes + ", amount=" + amount + "]";
	}
	
	
	
	
}

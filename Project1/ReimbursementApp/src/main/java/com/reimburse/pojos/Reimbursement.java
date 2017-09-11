package com.reimburse.pojos;

import java.math.BigDecimal;
import java.util.Date;

public class Reimbursement {

	//instance variables
	private int reimbursementId;
	private int submitId;
	private int resolveId;
	private int statusId; // 0-pending,1-approved,2-denied
	private String description; //submitter reason for request
	private String managerNotes; //manager reason for approval/denial
	private BigDecimal amount; //amount of request
	private Date submitDate; 
	private Date resolveDate;
	private String resolveName;
	private String submitName;
	
	//constructors
	public Reimbursement() {
	}
	
	public Reimbursement(int reimbursementId, int submitId, int resolveId, int statusId, String description,
			String managerNotes, BigDecimal amount, Date submitDate, Date resolveDate) {
		this.reimbursementId = reimbursementId;
		this.submitId = submitId;
		this.resolveId = resolveId;
		this.statusId = statusId;
		this.description = description;
		this.managerNotes = managerNotes;
		this.amount = amount;
		this.submitDate = submitDate;
		this.resolveDate = resolveDate;
	}

	//getters and setters
	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getSubmitId() {
		return submitId;
	}

	public void setSubmitId(int submitId) {
		this.submitId = submitId;
	}

	public int getResolveId() {
		return resolveId;
	}

	public void setResolveId(int resolveId) {
		this.resolveId = resolveId;
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

	public String getManagerNotes() {
		return managerNotes;
	}

	public void setManagerNotes(String managerNotes) {
		this.managerNotes = managerNotes;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	
	
	//tostring override for easy read

	public String getSubmitName() {
		return submitName;
	}

	public void setSubmitName(String submitName) {
		this.submitName = submitName;
	}

	public String getResolveName() {
		return resolveName;
	}

	public void setResolveName(String resolveName) {
		this.resolveName = resolveName;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", submitId=" + submitId + ", resolveId="
				+ resolveId + ", statusId=" + statusId + ", description=" + description + ", managerNotes="
				+ managerNotes + ", amount=" + amount + ", submitDate=" + submitDate + ", resolveDate=" + resolveDate
				+ "]";
	}
	
	
}

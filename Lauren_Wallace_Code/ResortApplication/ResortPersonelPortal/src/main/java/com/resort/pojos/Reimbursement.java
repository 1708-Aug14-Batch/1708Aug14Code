package com.resort.pojos;

import java.sql.Timestamp;

public class Reimbursement {
	
	private int reimburseId;
	private int requesterId;
	private int resolverId;
	private int status_Id;
	private int type_Id;
	private String receipt;
	private String reason;
	private String rNotes;
	private double amount;
	private Timestamp sdate;
	private Timestamp rdate;

	public Reimbursement() {};
	
	public Reimbursement(int reimburseId, int requesterId, int status_Id, String reason, String rNotes, 
			double amount, int type_Id) {
		super();
		this.reimburseId = reimburseId;
		this.requesterId = requesterId;
		this.status_Id = status_Id;
		this.reason = reason;
		this.rNotes = rNotes;
		this.amount = amount;
		this.type_Id = type_Id;
	}

	public Reimbursement(int reimburseId, int requesterId, int resolverId, int status_Id, String receipt, String reason,
			String rNotes, double amount, int type_Id) {
		super();
		this.reimburseId = reimburseId;
		this.requesterId = requesterId;
		this.resolverId = resolverId;
		this.status_Id = status_Id;
		this.receipt = receipt;
		this.reason = reason;
		this.rNotes = rNotes;
		this.amount = amount;
		this.type_Id = type_Id;
	}

	public int getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public int getStatus_Id() {
		return status_Id;
	}

	public void setStatus_Id(int status_Id) {
		this.status_Id = status_Id;
	}
	
	public int getType_Id() {
		return type_Id;
	}

	public void setType_Id(int type_Id) {
		this.type_Id = type_Id;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getrNotes() {
		return rNotes;
	}

	public void setrNotes(String rNotes) {
		this.rNotes = rNotes;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Timestamp getSdate() {
		return sdate;
	}

	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}

	public Timestamp getRdate() {
		return rdate;
	}

	public void setRdate(Timestamp rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "Reimbursement Id: " + reimburseId + "\n Requester Id: " + requesterId + "\n Resolver Id: "
				+ resolverId + "\n Status Id: " + status_Id + "\n Reason: " + reason + "\n Resolver Notes: " + rNotes + "\n Amount Requested: "
				+ amount;
	}

}

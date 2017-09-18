package com.ers.pojos;

import java.sql.Timestamp;

public class Request {
	
	private int requestId;
	private int submitterId;
	private String submitterName;
	private Timestamp submitDate;
	private int resolverId;
	private String resolverName;
	private Timestamp resolveDate;
	private String status;
	private String description;
	private String notes;
	private float amount;
	
	public Request() {
		super();
	}

	public Request(int requestId, int submitterId, String submitterName, Timestamp submitDate, int resolverId, String resolverName, Timestamp resolveDate,
			String status, String description, String notes, float amount) {
		this.requestId = requestId;
		this.submitterId = submitterId;
		this.submitterName = submitterName;
		this.submitDate = submitDate;
		this.resolverId = resolverId;
		this.resolverName = resolverName;
		this.resolveDate = resolveDate;
		this.status = status;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getSubmitterId() {
		return submitterId;
	}

	public void setSubmitterId(int submitterId) {
		this.submitterId = submitterId;
	}
	
	public String getName() {
		return submitterName;
	}
	
	public void setName(String submitterName) {
		this.submitterName = submitterName;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public String getResolverName() {
		return resolverName;
	}

	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}

	public Timestamp getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Timestamp resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", submitterId=" + submitterId + ", submitterName=" + submitterName + ", submitDate=" + submitDate
				+ ", resolverId=" + resolverId + ", resolverName=" + resolverName + ", resolveDate=" + resolveDate + ", status=" + status
				+ ", description=" + description + ", notes=" + notes + ", amount=" + amount + "]";
	}
}

package com.reimburse.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reimbursement {
	
	public enum reimbursementStatus {
		NULL,		// The database is 1-indexed so I'm throwing out the index 0 element
		PENDING,
		DENIED,
		APPROVED
	};
	
	private final int reimbursementId;
	private final int submitterId;
	protected int resolverId;
	private reimbursementStatus status;
	private final LocalDateTime submitDate;
	protected LocalDateTime resolvedDate;
	private String description;
	protected String resolveNotes;
	private BigDecimal ammount;
	
	public Reimbursement(int reimbursementId, int submitterId, reimbursementStatus status, LocalDateTime submitDate, String description, BigDecimal ammount) {
		super();
		this.reimbursementId = reimbursementId;
		this.submitterId = submitterId;
		this.status = status;
		this.submitDate = submitDate;
		this.description = description;
		this.ammount = ammount;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public LocalDateTime getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(LocalDateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
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

	public int getReimbursementId() {
		return reimbursementId;
	}

	public int getSubmitterId() {
		return submitterId;
	}

	public LocalDateTime getSubmitDate() {
		return submitDate;
	}

	public reimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(reimbursementStatus status) {
		this.status = status;
	}

	public BigDecimal getAmmount() {
		return ammount;
	}

	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", submitterId=" + submitterId + ", resolverId="
				+ resolverId + ", status=" + status + ", submitDate=" + submitDate + ", resolvedDate=" + resolvedDate
				+ ", description=" + description + ", resolveNotes=" + resolveNotes + ", ammount=" + ammount + "]";
	}
	
}

package com.reimbursement.pojos;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class Reimbursement {
	
	private int id;
	private User submitted_by;
	private User resolved_by;
	private ReimbursementStatus status;
	private String description;
	private String resolve_notes;
	private BigDecimal amount;
	private Timestamp submit_date;
	private Timestamp resolve_date;
	
	public Reimbursement(int id, User submitted_by, ReimbursementStatus status, String description, BigDecimal amount, Timestamp submit_date) {
		super();
		this.id = id;
		this.submitted_by = submitted_by;
		this.status = status;
		this.description = description;
		this.amount = amount;
		this.submit_date = submit_date;
	}
	
	public Reimbursement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubmitterId() {
		return submitted_by.getId();
	}

	public void setSubmitter(User submitted_by) {
		this.submitted_by = submitted_by;
	}

	public int getResolverId() {
		return resolved_by.getId();
	}

	public void setResolver(User resolved_by) {
		this.resolved_by = resolved_by;
	}

	public int getStatus() {
		return status.getStatus();
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResolve_notes() {
		return resolve_notes;
	}

	public void setResolve_notes(String resolve_notes) {
		this.resolve_notes = resolve_notes;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Timestamp getSubmit_date() {
		return submit_date;
	}

	public void setSubmit_date(Timestamp submit_date) {
		this.submit_date = submit_date;
	}

	public Timestamp getResolve_date() {
		return resolve_date;
	}

	public void setResolve_date(Timestamp resolve_date) {
		this.resolve_date = resolve_date;
	}
	
}

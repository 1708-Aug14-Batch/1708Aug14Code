package com.ers.pojos;

import java.sql.Date;

public class Reimbursement {

	private int id;
	private Employee submitter;
	private Employee resolver;
	private Date submitdate;
	private Date resolveddate;
	private ReimbursementStatus type;
	private String descript;
	private String notes;
	private double amount;
	
	public Reimbursement() {};
	
	public Reimbursement(Employee submitter, Employee resolver, Date submitdate, Date resolveddate,
			ReimbursementStatus type, String descript, String notes, double amount) {
		super();
		this.submitter = submitter;
		this.resolver = resolver;
		this.submitdate = submitdate;
		this.resolveddate = resolveddate;
		this.type = type;
		this.descript = descript;
		this.notes = notes;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getSubmitter() {
		return submitter;
	}

	public void setSubmitter(Employee submitter) {
		this.submitter = submitter;
	}

	public Employee getResolver() {
		return resolver;
	}

	public void setResolver(Employee resolver) {
		this.resolver = resolver;
	}

	public Date getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Date submitdate) {
		this.submitdate = submitdate;
	}

	public Date getResolveddate() {
		return resolveddate;
	}

	public void setResolveddate(Date resolveddate) {
		this.resolveddate = resolveddate;
	}

	public ReimbursementStatus getType() {
		return type;
	}

	public void setType(ReimbursementStatus type) {
		this.type = type;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
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
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", submitter=" + submitter + ", resolver=" + resolver + ", submitdate="
				+ submitdate + ", resolveddate=" + resolveddate + ", type=" + type + ", descript=" + descript
				+ ", notes=" + notes + ", amount=" + amount + "]";
	}
	
	
	
	
}

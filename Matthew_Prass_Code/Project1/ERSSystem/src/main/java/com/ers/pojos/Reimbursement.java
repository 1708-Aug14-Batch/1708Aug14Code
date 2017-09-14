package com.ers.pojos;

import java.io.InputStream;
import java.sql.Blob;
//import java.sql.Date;
import java.sql.Timestamp;

public class Reimbursement {

	private int id;
	private Employee submitter;
	private Employee resolver;
	private Timestamp submitdate;
	private Timestamp resolveddate;
	private ReimbursementStatus type;
	private String descript;
	private String notes;
	private double amount;
	private byte[] receipt;
	
	public Reimbursement() {};
	
	public Reimbursement(Employee submitter, Employee resolver, Timestamp submitdate, Timestamp resolveddate,
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

	public Timestamp getSubmitdate() {
		return submitdate;
	}

	public void setSubmitdate(Timestamp submitdate) {
		this.submitdate = submitdate;
	}

	public Timestamp getResolveddate() {
		return resolveddate;
	}

	public void setResolveddate(Timestamp resolveddate) {
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
	
	public byte[] getInputStream() {
		return receipt;
	}

	public void setInputStream(byte[] receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", submitter=" + submitter + ", resolver=" + resolver + ", submitdate="
				+ submitdate + ", resolveddate=" + resolveddate + ", type=" + type + ", descript=" + descript
				+ ", notes=" + notes + ", amount=" + amount + " blob= " + receipt + "]";
	}
	
	
	
	
}

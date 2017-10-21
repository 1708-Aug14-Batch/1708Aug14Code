package com.project.one.pojos;

import java.sql.Date;

public class Reimbursement {
	private int ID;// number Primary Key,
	private Employee empl;//EMPLOYEE NUMBER NOT NULL,
	private Employee mngr;//MANAGER NUMBER,
	private double amount;//AMOUNT NUMBER NOT NULL CHECK (AMOUNT >= 0),
	private String desc;//DESCRIPTION VARCHAR2(30) NOT NULL,
	private Date submitDate;//SUBMITDATE TIMESTAMP NOT NULL,
	private Status status;//STATUS NUMBER,
	private Date rslv;//RESOLVEDATE TIMESTAMP DEFAULT (NULL),
	private String reason;//RESREASON VARCHAR2(30),

	/**
	 * This is the constructor for making a NEW Reimbursement request, 
	 * requests that already exist should use the constructor that includes
	 * status & dates.
	 * @param ID
	 * @param empl
	 * @param amount
	 * @param desc
	 */
	public Reimbursement(int ID, Employee empl, double amount, String desc) {
		
	}

	public Reimbursement(int iD, Employee empl, Employee mngr, double amount, String desc, Date submitDate,
			Status status, Date rslv, String reason) {
		super();
		ID = iD;
		this.empl = empl;
		this.mngr = mngr;
		this.amount = amount;
		this.desc = desc;
		this.submitDate = submitDate;
		this.status = status;
		this.rslv = rslv;
		this.reason = reason;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Employee getEmpl() {
		return empl;
	}

	public void setEmpl(Employee empl) {
		this.empl = empl;
	}

	public Employee getMngr() {
		return mngr;
	}

	public void setMngr(Employee mngr) {
		this.mngr = mngr;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getRslv() {
		return rslv;
	}

	public void setRslv(Date rslv) {
		this.rslv = rslv;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Reimbursement id: " + ID + ", employee:" + empl.getFn()+" "+empl.getLn() + ", Resolving manager" + mngr.getFn()+" "+mngr.getLn() + ", amount: " + amount + ", description:" + desc
				+ ", submitted on: " + submitDate + ", status: " + status.getDesc() + ", resolved date: " + rslv + ", reason=" + reason;
	}
	
	
}

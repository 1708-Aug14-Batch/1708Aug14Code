package com.reimbursments.pojos;

import java.sql.Timestamp;

public class Reimburs {
	private int r_id;
	private int sub_id;
	private int res_id;
	private int status_id;
	private String description;
	private String notes;
	private double amount;
	private Timestamp subDate;
	private Timestamp resDate;
	
	
	public Reimburs() {
		super();
	}
	
	
	public Reimburs(String description, double amount) {
		super();
		this.description = description;
		this.amount = amount;
	}


	public Reimburs(int r_id, int sub_id, int res_id, Timestamp subDate,Timestamp resDate, int status_id, String description, String notes,
			double amount) {
		super();
		this.r_id = r_id;
		this.sub_id = sub_id;
		this.res_id = res_id;
		this.subDate = subDate;
		this.resDate = resDate;
		this.status_id = status_id;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
	}


	public Reimburs(int r_id, int sub_id, int res_id, int status_id, String description, String notes, double amount,
			Timestamp subDate, Timestamp resDate) {
		super();
		this.r_id = r_id;
		this.sub_id = sub_id;
		this.res_id = res_id;
		this.status_id = status_id;
		this.description = description;
		this.notes = notes;
		this.amount = amount;
		this.subDate = subDate;
		this.resDate = resDate;
	}


	public int getR_id() {
		return r_id;
	}


	public void setR_id(int r_id) {
		this.r_id = r_id;
	}


	public int getSub_id() {
		return sub_id;
	}


	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}


	public int getRes_id() {
		return res_id;
	}


	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}


	public int getStatus_id() {
		return status_id;
	}


	public void setStatus_id(int status_id) {
		this.status_id = status_id;
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


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Timestamp getSubDate() {
		return subDate;
	}


	public void setSubDate(Timestamp subDate) {
		this.subDate = subDate;
	}


	public Timestamp getResDate() {
		return resDate;
	}


	public void setResDate(Timestamp resDate) {
		this.resDate = resDate;
	}
	
	
	
	
	
	

}

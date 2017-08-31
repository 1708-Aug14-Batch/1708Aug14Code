package com.reimbursement.pojos;

public class Status {

	
	private int st_id;
	private String name;
	public Status(int st_id, String name) {
		super();
		this.st_id = st_id;
		this.name = name;
	}
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

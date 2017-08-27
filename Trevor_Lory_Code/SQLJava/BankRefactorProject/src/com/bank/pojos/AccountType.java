package com.bank.pojos;

public class AccountType {

	private int id;
	private String type;
	
	public AccountType(int id) {
		super();
		this.id = id;
		switch(id) {
		case 0:
			type = "Checkings";
			break;
		case 1:
			type = "Savings";
			break;
		case 2:
			type = "Credit";
			break;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + type + "]";
	}
	
}

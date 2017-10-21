package com.bank.pojos;

public class AccountType {
	private int id;
	private String description;
	
	public AccountType(int type) {
		this.id = type;
		switch(type) {
		case 1: this.description = "Checking";
		break;
		case 2: this.description = "Savings";
		break;
		case 3: this.description = "Credit";
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", description=" + description + "]";
	}
	
	
	

}

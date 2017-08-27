package com.bank.pojos;

public enum AccountType {
	CHECKING(1, "Checking"), SAVINGS(2, "Savings"), CREDIT(3, "Credit");
	
	private int id;
	private String typeName;
	private AccountType(int id, String typeName) {
		this.id = id;
		this.typeName = typeName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	
	public static AccountType get(int id) {
		switch (id) {
		case 1: return CHECKING;
		case 2: return SAVINGS;
		case 3: return CREDIT;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return "AccountType [id="+id+" typeName="+typeName;
	}
}

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
	
	@Override
	public String toString() {
		return "AccountType [id="+id+" typeName="+typeName;
	}
}

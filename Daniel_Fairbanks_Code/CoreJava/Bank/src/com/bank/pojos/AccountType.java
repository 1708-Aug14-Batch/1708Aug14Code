package com.bank.pojos;


public class AccountType {
	
	private enum Type {
		CHECKING,
		SAVINGS,
		CREDIT
	}
	private int id;
	private Type type;
	
	public AccountType(int type_id) {
		id = type_id;
		switch (type_id) {
			case 1:
				type = Type.CHECKING;
				break;
			case 2:
				type = Type.SAVINGS;
				break;
			case 3:
				type = Type.CREDIT;
				break;
			default:
				type = Type.SAVINGS;
				id = 2;
				break;
		}
	}
	
	public AccountType(String typeStr) {
		
		switch (typeStr) {
			case "Checking":
				type = Type.CHECKING;
				break;
			case "Savings":
				type = Type.SAVINGS;
				break;
			case "Credit":
				type = Type.CREDIT;
				break;
			default:
				type = Type.SAVINGS;
				id = 2;
				break;
		}
	}
	
	public int getId() {
		return id;
	}
	
	public String getType() {
		return type.toString();
	}

	@Override
	public String toString() {
		return type.toString();
	}
	
}

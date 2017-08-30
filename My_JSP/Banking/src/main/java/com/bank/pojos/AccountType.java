package com.bank.pojos;


public class AccountType {
	
	public static enum TYPES { NONE, SAVINGS, CHECKING, CREDIT };

	private int typeId;
	private String name;
	
	public AccountType(int typeId, String name) {
		super();
		this.typeId = typeId;
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}

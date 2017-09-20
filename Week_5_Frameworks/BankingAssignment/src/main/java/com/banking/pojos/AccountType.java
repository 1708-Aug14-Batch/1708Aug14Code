package com.banking.pojos;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTTYPE")
public class AccountType {

	@Id
	@Column(name = "Type_ID")
	private int typeID;
	
	@Column(name = "Type_Name")
	private String name;
	
	public AccountType() {};
	public AccountType(int typeID, String name) {
		super();
		this.typeID = typeID;
		this.name = name;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
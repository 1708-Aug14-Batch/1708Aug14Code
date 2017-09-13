package com.bank.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTTYPES")
public class AccountType {

	@Id
	@Column(name="TYPEID")
	private int TYPEID; //Primary Key
	@Column(name="NAME", nullable=false, unique=true)
	private String NAME; //not null, unique
	
	public AccountType() {}

	public AccountType(int tYPEID, String nAME) {
		super();
		TYPEID = tYPEID;
		NAME = nAME;
	}

	public int getTYPEID() {
		return TYPEID;
	}

	public void setTYPEID(int tYPEID) {
		TYPEID = tYPEID;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	@Override
	public String toString() {
		return "AccountType [TYPEID=" + TYPEID + ", NAME=" + NAME + "]";
	}
	
}

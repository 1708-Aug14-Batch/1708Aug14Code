package com.bank.beans;

import javax.persistence.Column;
import javax.persistence.Id;

public class AccountType {
	
	@Id
	@Column(name="TYPEID", nullable = false)
	private int id;
	
	@Column
	private String name;

	public AccountType() {
		super();
	}

	public AccountType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.bank.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTTYPE")
public class AccountType {

	@Id
	@Column(name = "TYPE_ID")
	private int id;
	@Column
	private String name;
	
	public AccountType() {};
	
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

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", name=" + name + "]";
	}
	
}

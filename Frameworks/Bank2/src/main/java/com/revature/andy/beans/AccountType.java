package com.revature.andy.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_TYPE")
public class AccountType {
	@Id
	@Column(name="TYPE_ID")
	/*
	@SequenceGenerator(name="ACCOUNTID_SEQ", sequenceName="ACCOUNTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNTID_SEQ")
	*/
	private int id;
	@Column
	private String type;
	
	public AccountType() {
		// TODO Auto-generated constructor stub
	}

	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
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
		return "AccountType [id=" + id + ", type=" + type + "]";
	}
	
}

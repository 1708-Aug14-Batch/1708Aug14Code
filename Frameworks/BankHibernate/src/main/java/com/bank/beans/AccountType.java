package com.bank.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AccountType")
public class AccountType {

	@Id
	@Column(name="Type_id")
	private int id;
	
	@Column(name="type")
	private String type;

	
	public AccountType() {
		super();
	}

	public AccountType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "AccountType [id=" + id + ", type=" + type + "]";
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
	
	
}

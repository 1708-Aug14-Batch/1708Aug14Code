package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="account_type")
public class AccountType implements Serializable {
	
	private static final long serialVersionUID = -2786042802974674137L;

	@Id
	@Column(name="account_type_id")
	@SequenceGenerator(name="account_type_id_seq", sequenceName="account_type_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_type_id_seq")
	private int accountTypeID;
	
	@Column(name="name")
	private String name;

	public AccountType(int accountTypeID, String name) {
		this.accountTypeID = accountTypeID;
		this.name = name;
	}

	public AccountType() {}

	public int getAccountTypeID() {
		return accountTypeID;
	}

	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

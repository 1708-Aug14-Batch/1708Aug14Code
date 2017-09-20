package com.bank.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accSeq")
	@SequenceGenerator(allocationSize=1,name="accSeq", sequenceName="ACC_SEQ")
	@Column(name="ACC_ID")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.REMOVE)
	private AccountType type;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private BankUser owner;
	
	@Column
	private double balance;

	public Account(){}
	
	public Account(int id, AccountType type, BankUser owner, double balance) {
		super();
		this.id = id;
		this.type = type;
		this.owner = owner;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public BankUser getOwner() {
		return owner;
	}

	public void setOwner(BankUser owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	
	

}

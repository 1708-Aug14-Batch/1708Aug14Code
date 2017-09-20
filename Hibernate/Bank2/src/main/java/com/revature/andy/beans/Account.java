package com.revature.andy.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="ACCOUNT_ID")
	@SequenceGenerator(name="ACCOUNTID_SEQ", sequenceName="ACCOUNTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNTID_SEQ")
	private int id;
	@Column(nullable = false)
	private double balance;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	@JoinColumn(name="USER_ID", nullable = false)
	private User u;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	@JoinColumn(name="TYPE_ID", nullable = false)
	private AccountType at;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int id, double balance, User u, AccountType at) {
		super();
		this.id = id;
		this.balance = balance;
		this.u = u;
		this.at = at;
	}
	
	public Account(double balance, User u, AccountType at) {
		super();
		this.balance = balance;
		this.u = u;
		this.at = at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public AccountType getAt() {
		return at;
	}

	public void setAt(AccountType at) {
		this.at = at;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", u=" + u + ", at=" + at + "]";
	}
	
	
	
}

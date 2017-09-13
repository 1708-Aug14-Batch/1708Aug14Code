package com.bank.pojos;

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
@Table(name = "ACCOUNT")
public class Account 
{
	@Id
	@Column(name = "ACCOUNT_ID")
	@SequenceGenerator(name = "ACC_ID_SEQ",sequenceName = "ACC_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_ID_SEQ")
	private int id;
	@Column
	private double balance;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private User user;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID")
	private AccountType type;
	
	public Account() {};
	
	public Account(double balance, User user, AccountType type) {
		super();
		this.balance = balance;
		this.user = user;
		this.type = type;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", user=" + user + ", type=" + type + "]";
	}
	
	
	
}

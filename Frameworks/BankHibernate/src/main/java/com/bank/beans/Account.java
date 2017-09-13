package com.bank.beans;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	@Column(name="Account_ID")
	@SequenceGenerator(name = "Account_ID_SEQ", sequenceName="Account_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Account_ID_SEQ")
	private int accountID;
	
	@Column
	private BigDecimal balance;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="INSTRUCTOR_ID")
	private AccountType type;

	public Account() {
		super();
	}

	public Account(int accountID, BigDecimal balance, User user, AccountType type) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.user = user;
		this.type = type;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
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
		return "Account [accountID=" + accountID + ", balance=" + balance + ", user=" + user + ", type=" + type + "]";
	}
	
	
}

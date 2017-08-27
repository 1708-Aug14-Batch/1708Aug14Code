package com.bank.pojos;

import java.sql.Date;

public class Account {
	private int id;
	private User user;
	private AccountType accountType;
	private double balance;
	private Date openDate;
	private Date closeDate;
	
	
	public Account() {}

	public Account(int id, User user, int accountType) {
		super();
		this.id = id;
		this.user = user;
		this.accountType = new AccountType(accountType);
		this.balance = 0;
	}
	
//	public Account(int id, User user, AccountType accountType) {
//		super();
//		this.id = id;
//		this.user = user;
//		this.accountType = accountType;
//		this.balance = 0;
//	}

//	public Account(int aid, int type, double balance2) {
//		this.id = aid;
//		this.accountType = new AccountType(type);
//		this.balance = balance;
//	}

	public Account(int id, int type, double balance, Date open, Date close) {
		this.id = id;
		this.accountType = new AccountType(type);
		this.balance = balance;
		this.openDate = open;
		this.closeDate = close;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	
	
	
}

package com.bank.pojo;

import java.math.BigDecimal;

public class Account {
	private int accountID;
	private BigDecimal balance;
	private int userID;
	private int typeID;
	
	public Account() {
	}
	public Account(int accountID) {
		this.accountID = accountID;
	}
	public Account(BigDecimal balance, int userID, int typeID) {
		super();
		this.balance = balance;
		this.userID = userID;
		this.typeID = typeID;
	}
	public Account(int accountID, BigDecimal balance, int userID, int typeID) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.userID = userID;
		this.typeID = typeID;
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
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", userID=" + userID + ", typeID=" + typeID
				+ "]";
	}
	
}

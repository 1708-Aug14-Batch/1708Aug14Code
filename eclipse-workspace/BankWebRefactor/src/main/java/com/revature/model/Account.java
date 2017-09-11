package com.revature.model;

import java.math.BigDecimal;

/**
 * Models a bank account.
 * @author Will Underwood
 */
public class Account {
	
	private int accountID;
	private BigDecimal balance;
	private int userID;
	private int accountTypeID;
	
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
	
	public int getAccountTypeID() {
		return accountTypeID;
	}
	
	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", userID=" + userID + ", accountTypeID="
				+ accountTypeID + "]";
	}

}

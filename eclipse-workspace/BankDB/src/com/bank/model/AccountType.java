package com.bank.model;

/**
 * Specifies a type for a bank account.
 * Such as checking, savings, student checking, student savings, etc.
 * @author Will Underwood
 */
public class AccountType {
	
	private int accountTypeID;
	private String accountTypeName;
	
	public int getAccountTypeID() {
		return accountTypeID;
	}
	
	public void setAccountTypeID(int accountTypeID) {
		this.accountTypeID = accountTypeID;
	}
	
	public String getAccountTypeName() {
		return accountTypeName;
	}
	
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	
	@Override
	public String toString() {
		return "AccountType [accountTypeID=" + accountTypeID + ", accountTypeName=" + accountTypeName + "]";
	}

}

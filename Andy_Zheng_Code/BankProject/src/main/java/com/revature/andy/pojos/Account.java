package com.revature.andy.pojos;

public class Account {
			 
	private int accountID;
	private double balance;
	private User user;
	private AccountType type;
	
	public Account() {}
	
	public Account(int accountID, double balance, User user, AccountType type) {
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
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
		return "Account ID: " + accountID + 
				", Balance: " + balance + 
				", User: " + user.getFName() + " " + user.getLName() + 
				", Type: " + type.getType();
	}

	
}

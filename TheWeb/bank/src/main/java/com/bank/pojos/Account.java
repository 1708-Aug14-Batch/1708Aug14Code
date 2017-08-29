package com.bank.pojos;

public class Account {


	private int id;
	private double balance;
	private User user;
	private AccountType type;
	
	public Account(){}
	
	public Account(int id, double balance, User user, AccountType type) {
		super();
		this.id = id;
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

	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", user=" + user + ", type=" + type + "]";
	}
	
	
	
	
	
}

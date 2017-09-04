package com.bank.pojos;

public class Account {
	
	private int id;
	private double balance;
	private User nUser;
	private int type;      //refers to the id in AccountType (0,1)
	private int userid;
	
	public Account() {};
	
	public Account(int id, double balance, User nUser, int type) {
		this.id = id;
		this.balance = balance;
		this.nUser = nUser;
		this.type = type;
	}

	public Account(int id, double balance, int userid, int type) {
		this.id = id;
		this.balance = balance;
		this.userid = userid;
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
		return nUser;
	}

	public void setUser(User nUser) {
		this.nUser = nUser;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account Holder: " + nUser.getFirstname() + nUser.getLastname() + "\nAccount balance: " + balance + "\n " +
			   "Account type: " + type + "\n";
	}

}

package com.bank.pojos;

public class Account {

	private int id;
	private double balance;
	private int userid;
	private String name;
	private AccountType type;
	
	public Account(int id, double balance, String name, int userid, AccountType type) {
		super();
		this.id = id;
		this.balance = balance;
		this.userid = userid;
		this.name = name;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", user=" + userid + ", name=" + name + ", type=" + type
				+ "]";
	}
	
}

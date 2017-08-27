package com.bank.pojos;

public class Account {

	private int id;
	private int balance;
	private int userId;
	private int type;
	private String status;

	public Account() {};
	public Account(int id, int balance, int userid, int type, String status) {
		super();
		this.id = id;
		this.balance = balance;
		this.userId = userid;
		this.type = type;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", user=" + userId + ", type=" + type + "]";
	}
	
	
}

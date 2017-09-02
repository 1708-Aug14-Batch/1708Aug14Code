package com.bank.pojos;

import java.math.BigDecimal;


public class Account {
	private int id;
	private AccountType type;
	private User user;
	private BigDecimal balance;
	
	public Account() {
		
	}
	
	public Account(int id, AccountType type, User user, BigDecimal balance) {
		this.id = id;
		this.type = type;
		this.user = user;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void setType(AccountType type) {
		this.type = type;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public void setUser(User user){ 
		this.user = user;
	}
	
	public AccountType getType() {
		return type;
	}
	
	public User getUser() {
		return user;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void deposit(BigDecimal amt) {
		balance = balance.add(amt);
	}
	
	public boolean withdraw(BigDecimal amt) {
		if (amt.compareTo(balance) > 0)
			return false;
		balance = balance.subtract(amt);
		return true;
	}
}

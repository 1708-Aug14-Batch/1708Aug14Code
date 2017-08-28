package com.bank.pojos;

import java.math.BigDecimal;

public class Account {
	
	private int id;
	private AccountType type;
	private BigDecimal balance;
	//private String openDate;
	//private String closeDate;
	private User owner;
	private boolean is_active;
	
	public Account() {}
	
	public Account(AccountType type, User owner) {
		super();
		this.type = type;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/*
	public String getOpenDate() {
		return openDate;
	}
	
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	
	public String getCloseDate() {
		return closeDate;
	}
	
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	 */
	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public boolean getIsActive() {
		return is_active;
	}
	
	public void setIsActive(boolean active) {
		this.is_active = active;
	}

	@Override
	public String toString() {
		return "(" + id + ") " + type.toString() + ": $" + balance;
	}
	
}

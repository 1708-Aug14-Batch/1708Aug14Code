package com.bank.pojos;

import java.math.BigDecimal;

import com.rev.utils.InsufficientFundsException;

public class Account {
	private AccountType type;
	private User user;
	private BigDecimal balance;
	
	public Account(AccountType type, User user, BigDecimal balance) {
		this.type = type;
		this.user = user;
		this.balance = balance;
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
	
	public void withdraw(BigDecimal amt) throws InsufficientFundsException {
		if (amt.compareTo(balance) > 0)
			throw new InsufficientFundsException();
		balance = balance.subtract(amt);
	}
}

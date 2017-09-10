package com.bank.dto;

import java.util.List;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public class DTO {
	
	private User user;
	private List<Account> accounts;
	
	public DTO(User user, List<Account> accounts) {
		super();
		this.user = user;
		this.accounts = accounts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Dto [user=" + user + ", accounts=" + accounts + "]";
	}
}

package com.revature.andy.dto;

import java.util.HashSet;

import com.revature.andy.pojos.Account;
import com.revature.andy.pojos.User;

public class DTO {
	private User user;
	private HashSet<Account> accounts;
	
	public DTO() {}

	public DTO(User user, HashSet<Account> accounts) {
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

	public HashSet<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashSet<Account> accounts) {
		this.accounts = accounts;
	}
	
}

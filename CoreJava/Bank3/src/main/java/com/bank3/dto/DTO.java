package com.bank3.dto;

import java.util.ArrayList;

import com.bank3.pojos.Account;
import com.bank3.pojos.User;

public class DTO {
	private User user;
	private ArrayList<Account> accounts;
	
	public DTO() {}
	
	public DTO(User user, ArrayList<Account> accounts) {
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

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "DTO [user=" + user + ", accounts=" + accounts + "]";
	}
	
	
}

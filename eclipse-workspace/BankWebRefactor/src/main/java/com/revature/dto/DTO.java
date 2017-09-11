package com.revature.dto;

import java.util.ArrayList;

import com.revature.model.*;

public class DTO {
	
	private User user;
	private ArrayList<Account> accounts;
	
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

}

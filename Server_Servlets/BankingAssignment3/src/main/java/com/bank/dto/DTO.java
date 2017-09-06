package com.bank.dto;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.BankUser;

/*
 * This is a single object needed to transfer objects necessary for
 * a single user logged in
 */

public class DTO {
	
	private BankUser user;
	private ArrayList<Account> accounts;
	
	public DTO() {}

	public DTO(BankUser user, ArrayList<Account> accounts) {
		super();
		this.user = user;
		this.accounts = accounts;
	}

	public BankUser getUser() {
		return user;
	}

	public void setUser(BankUser user) {
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

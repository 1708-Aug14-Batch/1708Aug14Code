package com.bank.dao;

import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.BankUser;

public interface Dao {
	
	public BankUser addUser(BankUser u);
	public void addType(AccountType at);
	public List<BankUser> getUsers();
	public Account addAccount(Account a);
}

package com.bank.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bank.model.Account;
import com.bank.model.AccountType;
import com.bank.model.BankUser;


@Repository
public interface Dao {
	
	public BankUser getUserByUsername(String name);
	public BankUser addUser(BankUser u);
	public void addType(AccountType at);
	public List<BankUser> getUsers();
	public Account addAccount(Account a);
	public List<String> getEmails();
}

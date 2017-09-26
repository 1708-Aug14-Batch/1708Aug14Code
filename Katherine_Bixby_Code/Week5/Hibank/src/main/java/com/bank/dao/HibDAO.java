package com.bank.dao;

import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;

public interface HibDAO {

	public User addUser(User u);
	public Account addAccount(Account a);
	public AccountType addType(AccountType at);
	public List<User> getUsers();
	public List<String> getEmails();
	
}

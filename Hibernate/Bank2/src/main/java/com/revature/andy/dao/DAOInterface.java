package com.revature.andy.dao;

import java.util.List;

import com.revature.andy.beans.Account;
import com.revature.andy.beans.AccountType;
import com.revature.andy.beans.User;

public interface DAOInterface {

	public User addUser(User u);
	
	public Account addAccount(Account a);
	
	public List<User> getAllUsers();
	public List<Account> getAllAccounts();
	public List<Account> getAccountsByUser(User u);
	
	AccountType addAccountType(AccountType at);
	
}

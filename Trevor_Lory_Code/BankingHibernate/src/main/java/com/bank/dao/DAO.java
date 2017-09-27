package com.bank.dao;

import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;

public interface DAO {

	public User addUserNew(User u);
	
	public List<String> getAllEmails();
	
//	public List<User> getAllUsers();
//	
//	public void addUser(User u);
//	
//	public List<Account> getAllAccounts();
//	
//	public List<AccountType> getAllAccountTypes();
	
}

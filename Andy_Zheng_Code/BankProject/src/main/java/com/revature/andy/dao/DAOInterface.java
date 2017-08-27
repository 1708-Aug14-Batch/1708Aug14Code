package com.revature.andy.dao;

import java.util.ArrayList;
import java.util.HashSet;

import com.revature.andy.pojos.Account;
import com.revature.andy.pojos.AccountType;
import com.revature.andy.pojos.User;

public interface DAOInterface {
	
	// Accounts
	public int addAccount(User u, int typeID);
	
	public int updateAccount(User user, int accountID, double balance);
	
	public HashSet<Account> getAccounts(User user);

	public Account getAccount(User user, int accountID);

	public int deleteAccount(User user, int accountID);
	
	
	// Users
	public int addUser(User u);

	public int updateUser(User u);
	
	public User getUser(String email, String pwd);
	
	// AccountType
	
	public AccountType getAccountTypeFromID(int accountTypeID);

}

package com.bank.dao;

import java.util.ArrayList;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;

public interface DAO {

	/*
	 * The contract we make for the information that
	 * we will need to send to and receive from the data source.
	 * 
	 * 
	 * addUser  - new user added to the data
	 * getUsers - grab all users
	 * rewriteUsers - takes list of users and enters all information 
	 */
	
	User addUser(User user);
	User getUser(int id);
	User getUser(String usr, String pwd);
	boolean existsUsername(String username);
	void updateUser(User user);
	void deleteUser(User user);
	
	Account addAccount(Account account);
	Account getAccount(int accountID);
	ArrayList<Account> getAccounts(int userID);
	void updateAccount(Account account);
	void deleteAccount(Account account);
	AccountType addType(AccountType type);
	
	
}

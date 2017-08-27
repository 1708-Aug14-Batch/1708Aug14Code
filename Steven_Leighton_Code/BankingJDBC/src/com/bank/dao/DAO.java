package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojo.Account;
import com.bank.pojo.User;

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
	
	int addUser(User user);
	User getUser(int id);
	User getUser(String usr, String pwd);
	void updateUser(User user);
	void deleteUser(User user);
	
	int addAccount(int userID, int typeID);
	Account getAccount(int accountID);
	ArrayList<Account> getAccounts(int userID);
	void updateAccount(Account account);
	void deleteAccount(Account account);
	
	
}

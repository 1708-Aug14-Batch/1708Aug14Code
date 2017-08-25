package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAOInterface {
	
	// Accounts
	public void addAccount(Account a);
	
	public void updateAccount(Account a);
	
	
	// Users
	public void addUser(User u);
	
	public void updateUser(User u);
	
	//public void deleteUser(User s);
	
	
	// Get All ?
	public ArrayList<Account> getAllAccounts();
	
	public ArrayList<User> getAllUsers();
	
	// Get Specific
	public User getUser(String email, String pwd);
	
	public ArrayList<Account> getAccount(int userID);
	
	
	// Delete???
	public void deleteAccount(String email, String pwd);

}

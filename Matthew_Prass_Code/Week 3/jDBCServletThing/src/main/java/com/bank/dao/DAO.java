package com.bank.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {

	//creating
	public int addUser(String fn,String ln,String email,String pw);
	public Account creatAccount(User u, int typeid);
	//getting all
	public ArrayList<User> getAllUsers();
	public ArrayList<Account> getAllAccountsForUser(int userid);
	public ArrayList<AccountType> getAllAccountTypes();
	//getting one
	public User getUser(int id);
	public AccountType getAccountType(int id);
	//updating
	public void updateUser(User u);
	public void updateAccount(Account a);
	//deleting
	public void deleteUser(User u);
	public void deleteAccount(Account a);
	
	
	
	public User getUserByID(int id);
	public HashMap<Integer, String> getEmails();
}
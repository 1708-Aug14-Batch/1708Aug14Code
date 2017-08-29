package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {

	public int addUser(String fn, String ln, String em, String psw);
	public Account createAccount(User u, int typeid, String AccountName);
	public boolean updateUser(User u);
	public User getUser(String email, String password);
	public ArrayList<Account> getUserAccount(User u);
	public boolean updateAccount(Account a);
	public boolean closeAccount(Account a);
	
}

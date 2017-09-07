package com.bank3.dao;

import java.util.ArrayList;

import com.bank3.pojos.Account;
import com.bank3.pojos.User;

public interface DAO {
	// adduser
	// add account
	// etc.
	
	public void addUser(String fn, String ln, String username, String password);
	
	public void createAccount(int userid, int typeId);
	
	public void editUser(String fn, String ln, String pw, int id);
	
	public int getUserID(String username, String pw);
	
	public User getUser(int id);
	
	public double getBalance(int id, int typeid);
	
	public void updateBalance(int id, int typeid, double deposit);
	
	public void deleteAcct(int id, int typeid);
	
	public ArrayList<Account> getAccountsByUser(int id);

}

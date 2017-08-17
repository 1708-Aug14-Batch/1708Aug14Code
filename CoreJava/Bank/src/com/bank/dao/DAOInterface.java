package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;

public interface DAOInterface {
	
	// contract
	// send and receive from data source
	
	// addUser
	// editUser - fn, ln, email, PW, balance
	// getUser
	
	public void addAccount(Account s);
	
	public void editAccount(Account s);
	
	public ArrayList<Account> getAll();
	
	public void clearUsers();
	
	//public void deleteTextFile()
	
	public Account getAccount(String email, String pwd);
	
	//public void 

}

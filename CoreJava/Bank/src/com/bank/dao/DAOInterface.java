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
	
	public void clearAccounts();
	
	public void updateAccounts(ArrayList<Account> al);
	
	public Account getAccount(String email, String pwd);
	
	public void deleteAccount(String email, String pwd);

}

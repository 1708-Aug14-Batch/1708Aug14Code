package com.bank.dao;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {
	/*
	 * add user
	 * add account
	 * get balance
	 * get account
	 * 
	 * 
	 */
	public int addUser(String fn, String ln, String email, String password);
	
	public Account createAccount(int u, int typeId); 

}

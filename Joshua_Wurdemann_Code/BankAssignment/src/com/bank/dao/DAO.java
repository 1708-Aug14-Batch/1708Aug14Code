package com.bank.dao;

import java.util.ArrayList;

import com.bankassignment.pojos.User;

public interface DAO {
	//the contract we make for the information that we will need to sent to and
	//receive from the data source

	
	
	
		
	/** login**/
	public int login(String email, String Password);

	public String getAccountId(String email, String password);

	public int withdraw(String accountId, double parseDouble);

	public String getBalance(String accountId);

	public int deposit(String accountId, double parseDouble);

	public ArrayList<String> readAccount(String accountId);

	public ArrayList<User> read();

	public void write(ArrayList<User> list);

	
}

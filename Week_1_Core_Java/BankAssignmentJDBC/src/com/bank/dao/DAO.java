package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {
	int addUser(String fn, String ln, String em, String pw);
	
	public Account createAccount(User u, int typeid);
	ArrayList<User> readUser();
	ArrayList<AccountType> readAccountType();
	ArrayList<Account> readAccount();
//	void editUser(ArrayList<User> u);
	
	//AddUser
	//AddAccount
	//AddaccountType
	//get account
	//So forth and so forth
}

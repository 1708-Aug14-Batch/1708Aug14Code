package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {
	
	public int addUser(String fn, String ln, String usr, String pwd);
	int addAccount(User u, int type);
	//getAccount()
	int getUser(String usr);
//	ArrayList<Object> getAll();
	
	

}

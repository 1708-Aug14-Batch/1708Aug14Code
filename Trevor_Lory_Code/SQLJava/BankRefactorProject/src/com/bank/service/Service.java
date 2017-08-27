package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {

	static DAO dao = new DAOImpl();
	
	public User addUser(String fn, String ln, String em, String psw) {
		//validate email address so no crash
		int id = dao.addUser(fn, ln, em, psw);
		User u = new User(id, fn, ln, em, psw);
		return u;
	}
	
	public User getUser(String email, String password) {
		return dao.getUser(email, password);
	}
	
	public boolean updateUser(User u) {
		return dao.updateUser(u);
	}
	
	public Account createAccount(User u, int typeid, String AccountName) {
		return dao.createAccount(u, typeid, AccountName);
	}
	
	public boolean closeAccount(Account a) {
		return dao.closeAccount(a);
	}
	
	public ArrayList<Account> getAccounts(User u) {
		return dao.getUserAccount(u);
	}
	
	public boolean updateAccount(Account a) {
		return dao.updateAccount(a);
	}
}

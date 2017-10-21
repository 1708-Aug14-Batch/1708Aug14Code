package com.bank.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {
	private static DAOImpl dao;

	//used for adding
	public User addUser(String fn, String ln, String usr, String pwd) {
		User u;
		dao = new DAOImpl();
		//verify that username does not exist already
		int id = dao.addUser(fn,ln,usr,pwd);
		if(id>0){
			u = new User(id, fn,ln,usr,pwd);
			return u;
		}
		else {
			return null;
		}
	}

	public Account addAccount(User u, int typeid) {
		if(getOpenAccounts(u).size() < 7) {
			Account account;
			dao = new DAOImpl();
			int accountId = dao.addAccount(u, typeid);
			account = new Account(accountId, u, typeid);
			return account;
		}
		else {
			return null;
		}
	}

	//used for logging in
	public static User login(String usr, String pwd) {
		dao = new DAOImpl();
		User u = null;
		int id = dao.getUser(usr);
		if(id < 0) {
			return u;
		}
		else {
			String info = dao.getUser(id);
			String[] inf = info.split(":");
			String pass = inf[0];
			String fn = inf[1];
			String ln = inf[2];
			if(pass.equals(pwd)) {
				u = new User(id,fn,ln,usr,pass);
				return u;
			}
			else {				
				return null;
			}
		}
	}

	public ArrayList<Account> getOpenAccounts(User u) {
		ArrayList<Account> accounts;
		int id = u.getUserId();
		dao = new DAOImpl();
		accounts = dao.getAccounts(id);
		//add the user to each account
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getCloseDate()!=null) {
				accounts.remove(i);
			}
			else {
				accounts.get(i).setUser(u);
			}
		}
		return accounts;
	}

	public double closeAccount(Account acnt) {
		double balance = acnt.getBalance();
		int id = acnt.getId();
		dao = new DAOImpl();
		dao.closeAccount(id);
		return balance;
	}

	public void updateUser(User u) {
		dao = new DAOImpl();
		int id = u.getUserId();
		String fn = u.getFirstname();
		String ln = u.getLastname();
		String usr = u.getUsername();
		String pwd = u.getPassword();
		dao.updateUsers(id, fn, ln, usr, pwd);
	}

	public Account withdraw(Account act, double change) {
		dao = new DAOImpl();
		double bal = act.getBalance() - change;
		if(bal > 0) {
			act.setBalance(bal);
			int id = act.getId();
			dao.updateBalance(id, bal);
			return act;
		}
		else {
			return null;
		}
	}

	public Account deposit(Account act, double change) {
		dao = new DAOImpl();
		double bal = act.getBalance() + change;
		act.setBalance(bal);
		int id = act.getId();
		dao.updateBalance(id, bal);
		return act;
	}

	public Account[] transfer(Account w, Account d, double amount) {
		Account[] account = new Account[2];
		Account withdraw = withdraw(w, amount);
		if(withdraw == null) {return null;}
		else{
			account[0] = withdraw;
			account[1] = deposit(d, amount);
			return account;
		}
	}
	
	
}

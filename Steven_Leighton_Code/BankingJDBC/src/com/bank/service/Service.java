package com.bank.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DBDAO;
import com.bank.pojo.Account;
import com.bank.pojo.User;

public class Service {

	/*
	 * The logic before the information is passed to DAO.
	 * Functionality with the user.
	 * 
	 */

	private DAO dao; 

	public Service(){
		dao = new DBDAO();
	}

	/*
	 * add a new user to users if username is available
	 * return id = -1 if user not found
	 */
	public User addUser(User user){
		int id  = dao.addUser(user);
		user.setId(id);
		return user;
	}
	
	/*
	 * get the user with a particular id
	 * empty user if not found
	 */
	public User getUser(int id) {
		User user = dao.getUser(id);
		return user;
	}
	
	/*
	 * find user with given username and password
	 * return user if found
	 * empty user if not found
	 */
	public User getUser(String username, String password){
		User user = dao.getUser(username, password);
		//return null if none found
		return user;
	}
	
	
	/*
	 * update info functions
	 */

	public void updateUser(User user){
		//get user from all users, then change info, then rewrite
		dao.updateUser(user);
	};
	
	public ArrayList<Account> getAccounts(int userid){
		return dao.getAccounts(userid);
	}

	
	//return account with updated balance
	public Account withdraw(Account account, BigDecimal x){

		account.setBalance(account.getBalance().subtract(x));
		dao.updateAccount(account);
		return account;
	}
	//return Account with updated balance
	public Account deposit(Account account, BigDecimal x){
		account.setBalance(account.getBalance().add(x));
		dao.updateAccount(account);
		return account;
	}

	/*
	 * Transfer x amount of money from 
	 * Account a to account b
	 * 
	 */
	
	public void transfer(Account a, Account b, BigDecimal x){
		a.setBalance(a.getBalance().subtract(x));
		b.setBalance(b.getBalance().add(x));
		dao.updateAccount(a);
		dao.updateAccount(b);
	}
	
	/*
	 * Add new account
	 */
	
	public int addAccount(Account account){
		int id = dao.addAccount(account.getUserID(), account.getTypeID());
		return id;
	}
	/*
	 * Update account given
	 */
	public void updateAccount(Account account){
		dao.updateAccount(account);
	}
	
	/*
	 * Remove user from data
	 */
	
	public void removeUser(User user){
		dao.deleteUser(user);
	}
	
	/*
	 * Remove account
	 */
	
	public void removeAccount(Account account){
		dao.deleteAccount(account);
	}
}

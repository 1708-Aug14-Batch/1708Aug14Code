package com.bank.service;

import java.util.ArrayList;

import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {

	DAOImpl dao = new DAOImpl();
	ArrayList<Account> theAccounts = new ArrayList<Account>();
	
	public void getAllAccounts() {
		theAccounts = dao.allAccounts();
	}
	
	public int getThatId(String userName) {
		int uid = dao.unameToID(userName);
		return uid;
	}
	
	/*
	 * Check if user exists
	 */
	public int validateUser(String userName) {
		int uid = dao.unameToID(userName);
		if(uid>0) {
			return uid;
		}
		else {
			return -1;
		}
	}
	
	/*
	 * Check login credentials
	 */
	public User login(int theUid,String password) {
		if (theUid>0){
			User theUser = dao.getUser(theUid);
			if (theUser.getId()==theUid&&theUser.getPassword().equals(password)) {
				return theUser;
			}
		}
		return null;
	}
	
	/*
	 * Add new user
	 */
	public User addUser(String fn, String ln, String email, String pass){
		// validate email address
		int id = dao.addUser(fn, ln, email, pass);
		User u = new User(fn, ln, email, pass);
		u.setId(id);
		return u;
	}
	
	/*
	 * Add new account
	 */
	public Account addAccount(int userId,int typeId) {
		User theUser = dao.getUser(userId);
		Account theAccount = dao.createAccount(theUser, typeId);
		return theAccount;
	}
	
	
	/*
	 * Edit a user
	 */
	public void editEmail(int userId,String newEmail) {
		dao.editEmail(userId, newEmail);
	}
	public void editFirstName(int userId,String fn) {
		dao.editFirstName(userId, fn);
	}
	public void editLastName(int userId,String ln) {
		dao.editLastName(userId, ln);
	}
	public void editPassword(int userId,String pass) {
		dao.editPassword(userId, pass);
	}
	
	
	/*
	 * Check balance of accounts
	 */
	public void getBalance(int userId) {
		getAllAccounts();
		int totalAccounts = 0;
		for (Account i:theAccounts) {
			if(i.getUser().getId()==userId) {
				totalAccounts++;
				System.out.println("Your "+i.getType().getName()+" account has a balance of: $"+i.getBalance());
			}
		}
		if (totalAccounts==0) {
			System.out.println("You have no accounts. Please set up an account!");
		}
	}
	
	
	public Account findAccount(int userId,int accType) {
		getAllAccounts();
		for(Account i:theAccounts) {
			if(i.getUser().getId()==userId) {
				if(i.getType().getId()==accType) {
					return i;
				}
			}
		}
		return null;
	}
	
	
	
	/*
	 * Withdraw/deposit money
	 */
	public void changeBalance(int uid,int accId,double changeAmount) {
		dao.editBalance(uid,accId,changeAmount);
	}
	
	
	/*
	 * Transfer funds
	 */
	
	
	
	
	
	
}

package com.bank.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.bank.pojos.Account;
import com.bank.pojos.User;

/*
 * This class will have the following functionality:
 * - add user
 * - add account
 * - get user
 * - get account
 * - Service's edit user method calls these methods
 * 	 that DAOImpl implements
 * 	-> update user information (fn, ln, email, password)
 * 	-> update user account (balance)
 */

public interface DAO {
	
	//checks all emails 
	public HashMap<Integer, String> getEmails();
	
	//adds a new user to the database
	public int addUser(String fn, String ln, String email, String pass);
	
	//adds a new account for the user of a certain type 
	public Account createAccount(User u, int typeid);
	
	//sets current user
	public User setUserInfo(String email);
	
	//gets account(s) by the user object
	public ArrayList<Account> getUserAccounts(User u);
	
	//gets a user by their user id
	public User getUserById(int id);
	
	//updates the user's information
	public void updateUserFName(String email, String newFN);
	public void updateUserLName(String email, String newLN);
	public void updateUserEmail(String email, String newEm);
	public void updateUserPass(String email, String newPass);
	
	//updates the user's account 
	public void updateUserAccount(double change, String email, String choice);
	public void updateUserAccounts(double change, String rFundsEmail, String aFundsEmail);
	
	//closes a user account by setting the close date
	public void closeUserAccount(String cEmail);
}

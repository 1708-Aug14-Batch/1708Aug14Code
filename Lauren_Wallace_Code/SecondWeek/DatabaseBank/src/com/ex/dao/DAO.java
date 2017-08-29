package com.ex.dao;

import java.util.ArrayList;

import com.ex.pojos.Account;
import com.ex.pojos.User;

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
	
	//adds a new user to the database
	public int addUser(String fn, String ln, String email, String pass);
	
	//adds a new account for the user of a certain type 
	public Account createAccount(User u, int typeid);
	
	//checks if user exists
	public boolean doesUserWithEmailExist(String email);
	
	//sets current user
	public User setUserInfo(String email);
	
	//gets account(s)
	public ArrayList<Account> getUserAccounts(User u);
	
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

package com.bank.dao;

import java.util.ArrayList;
import com.bank.pojos.User;

public interface DAO {
	
	/*
	 * The contract we make for the information that
	 * we will need to send to & receive from the data source
	 * 
	 * methods in this interface:
	 * writeUser, readUsers, getUser, editUser 
	 * 
	 */
	
	/*
	 * writeUser
	 * will write the user information into the text file
	 */
	void writeUser(User newUser);
	
	/*
	 * readUsers
	 * will read in the current users in the file and produce
	 * an arrayList<User> of all registered users
	 */
	ArrayList<User> readUsers();
	
	/*
	 * editUser<String/Double> - change firstName, lastName, userName or email,
	 * password, or balance
	 * 
	 */
	void updateUserFName(String change);
	void updateUserLName(String change);
	void updateUserName(String change);
	void updateUserPass(String change);
	void updateBalance(double change, String choice);
	
	/*
	 * getUser
	 * returns the current user object 
	 */
	User getUser();	
}

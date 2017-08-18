package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

public interface DAO {
	
	//Contract make for the information
	//that we will need to send & receive from data source
	/*
	 * editUser (update) - change fn, ln, email, PW, or balance
	 * getUser
	 *  
	 */
	//public void create();
	//public ArrayList<Object> update();
	//addUser(){}
	public Object getUser();
	public void addUser(User newUser);
	public void update(ArrayList<User> user);
	
	
	

}

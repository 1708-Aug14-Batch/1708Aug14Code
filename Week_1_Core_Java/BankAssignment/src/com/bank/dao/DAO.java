package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

public interface DAO { //Interface


	//Abtract methods for the interface to implement
	void addUser(User u);
	ArrayList<User> readUser();
	void editUser(ArrayList<User> u);
	
	
	

	
}

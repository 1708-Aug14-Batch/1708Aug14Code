package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

public interface DAO {
	
	//ArrayList<T> getUser();
	void addUser(User user);

	ArrayList<User> getUser();

}

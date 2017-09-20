package com.banking.DAO;

import java.util.List;

import com.banking.pojos.User;


public interface DAO {

	
	public void addUser(User u);
	public List getUsers();
	
	
	
}

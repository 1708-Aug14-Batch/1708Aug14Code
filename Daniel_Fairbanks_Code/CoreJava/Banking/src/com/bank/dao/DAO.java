package com.bank.dao;

import com.bank.pojos.User;

public interface DAO {

	public User addUser(User u);
	public User editUser(int id, User u);
	public User getUser(String email, String password);
}

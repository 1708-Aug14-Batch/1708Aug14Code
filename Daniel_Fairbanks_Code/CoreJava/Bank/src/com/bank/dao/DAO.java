package com.bank.dao;

import java.util.Map;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public interface DAO {
	
	public int addUser(User u);
	public Account addAccount(Account a);
	public User editUser(int id, User u);
	public User getUser(String email, String password);
	public Map<Integer, User> getAllUsers();
}

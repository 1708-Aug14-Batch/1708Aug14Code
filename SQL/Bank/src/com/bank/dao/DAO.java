package com.bank.dao;

import java.util.HashMap;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {
	
	public int addUser(String fn, String ln, String email, String pass);
	
	public HashMap<Integer, String> getEmails();
	
	public User getUserById(int id);
	
	public Account createAccount(User u, int typeId);
	
		public Account viewAccount();
		public double withdraw(double withdrawAmount);
		public double deposit(double depositAmount);
		
}

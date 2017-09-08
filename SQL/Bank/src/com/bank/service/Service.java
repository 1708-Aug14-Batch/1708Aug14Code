package com.bank.service;

import java.util.HashMap;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.User;

public class Service {
	
	static DAO dao = new DAOImpl();
	
	public User addUser(String fn, String ln, String email, String pass){
		int id = dao.addUser(fn, ln, email, pass);
		User u = new User(fn, ln, email, pass);
		u.setId(id);
		return u;
	}
	
	public int validateUser(String email){
		int id = -1;
		HashMap<Integer, String> users = dao.getEmails();

		for(Integer n:users.keySet()){
			if(users.get(n).equalsIgnoreCase(email)){
				id = n;
			}
		}

		return id;
	}
	
	public User login(int id, String pass){
		User u = dao.getUserById(id);
		if(u.getPassword().equalsIgnoreCase(pass)){
			return u;
		}
		else return null;
	}
	
	public double withdraw(double amount)	{
		double balance = dao.withdraw(amount);
		balance = balance - amount;
		return balance;
			
	}
	
	public double deposit(double amount)	{
		double balance = dao.deposit(amount);
		balance = balance + amount;
		return balance;
			
	}
}

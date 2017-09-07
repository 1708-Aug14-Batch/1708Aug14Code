package com.bank.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service {
	static DAOImpl dao = new DAOImpl();
	static User user = new User();
	static Scanner scan;
	
	public int addUser(String fn, String ln, String email, String password){	
		
		int id = dao.addUser(fn, ln, email, password);
		return id;
		
	}
	
	public User getUser(String email, String password){
		
		 User user =  dao.getUser(email, password);
		
		return user;
	}
	public Account createAccount(int u, int typeId){
		Account acc = dao.createAccount(u, typeId);
		return acc;
	}
	public static Account getAccount(int user_id){
		Account acc = dao.getAccount(user_id);
		return acc;
	}
	
	public double getbalance(Account acc){
		double bal = acc.getBalance();		
		return bal;		
	}
	
	public double deposit(int bal, int amt, int aId){
		bal+=amt;		
		
		return bal;
	}
	public double withdrawal(int bal, int amt, int aId){
		bal-=amt;
		
		return bal;
	}
	public double transfer(){
		System.out.println("Still to come:");
		return 0;
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

}

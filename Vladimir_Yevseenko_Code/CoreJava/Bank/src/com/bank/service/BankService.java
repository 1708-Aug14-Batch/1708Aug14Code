package com.bank.service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.dao.DAO;
import com.bank.dao.DAOTextFile;
import com.bank.pojos.Field;
import com.bank.pojos.User;

public class BankService {
	private DAO<User> dao;
	private List<User> users;
	private User curUser;
	
	public BankService(String path) {
		dao = new DAOTextFile(path);
		users = dao.read();
	}
	
	public void createNewUser(String first, String last, String email, String password) {
		User u = new User();
		u.setFirst(first);
		u.setLast(last);
		u.setEmail(email);
		u.setPassword(password);
		users.add(u);
		commit();
	}
	
	public boolean login(String email, String password) {
		for (User usr: users)
			if (usr.getEmail().equals(email) && usr.getPassword().equals(password)) {
				curUser = usr;
				return true;
			}
		return false;
	}
	
	public void deposit(String funds)  {
		curUser.deposit(new BigDecimal(funds));
		System.out.println("\nDeposit successful\n");
		commit();
	}
	
	public void withdraw(String funds)  {
		if (curUser.withdraw(new BigDecimal(funds)))
			System.out.println("\nWithdraw successful\n");
		else
			System.out.println("\nInsufficient funds\n");
		commit();
	}
	
	public void modify(Field which, String to) {
		switch (which) {
			case FIRST: curUser.setFirst(to); break;
			case LAST: curUser.setLast(to); break;
			case EMAIL: curUser.setEmail(to); break;
			case PASSWORD: curUser.setPassword(to); break;
		}
		commit();
	}
	
	public void displayBalance() {
		System.out.println("\nCurrent balance: $" + curUser.getBalance().toString() + "\n");
	}
	
	public void commit() {
		dao.write(users);
	}
}
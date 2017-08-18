package com.bank.service;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.bank.dao.DAO;
import com.bankassignment.pojos.User;

public class Service {
	User myUser;
	DAO dao;

	public Service(){
		dao = new DaoTextImpl();
		myUser = new User();
	}


	public int login(String email, String password)
	{

		if (Pattern.matches(email, password))
		{
			int something = dao.login(email, password);
			if(something == 2) {
				String accountId = dao.getAccountId(email, password);
				myUser.setAccountId(accountId);
			}
			return something;
		} else {
			return 4;
		}
	}
	public void logout() {
		myUser.setAccountId(null);
	}
	public boolean isOpen() {
		return myUser.getAccountId() != null;
	}

	public String getBalance() {
		return dao.getBalance(myUser.getAccountId());
	}
	public int withdraw(String amount)
	{
		String pattern = "([1-9]\\d{0,3}([.]\\d{2})?)|([0]?[.]\\d{2})";
		boolean isValid = Pattern.matches(pattern, amount);
		if(isValid)
		{
			return dao.withdraw(myUser.getAccountId(), Double.parseDouble(amount));
		}
		else {
			return 4;
		}
	}
	public int deposit(String amount) {
		String pattern = "([1-9]\\d{0,3}([.]\\d{2})?)|([0]?[.]\\d{2})";
		boolean isValid = Pattern.matches(pattern, amount);
		if(isValid)
		{
			return dao.deposit(myUser.getAccountId(), Double.parseDouble(amount));
		}
		else {
			return 4;
		}
	}
	public ArrayList<String> readAccount() {
		return dao.readAccount(myUser.getAccountId());
	}

	public void registerUser(User newUser) {
		
		ArrayList<User> list = dao.read();
		list.add(newUser);
		dao.write(list);

	}
}




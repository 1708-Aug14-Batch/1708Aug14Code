package com.bank.service;

import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.dao.DAO;
import com.bank.dao.DAOTextImpl;
import com.bank.pojos.User;

public class Service {
	
	//create DAO object based on data source
	
	static DAO dao = new DAOTextImpl();
	//I create the static variable theList to make sure that I have the most updated
	//version of the user list at all times without having to call getUser often
	static ArrayList<User> theList;
	
	@SuppressWarnings("unchecked")
	public static User login(String username) {
		User tryUser = null;
		//creates an empty User to be returned
		theList = (ArrayList<User>) dao.getUser();
		//retrieves ArrayList given by DAO
		for(User u: theList) {
			if(u.getEmail().equalsIgnoreCase(username)) {
				//searches through ArrayList for User
				return u;
				//If it finds the User, it will return it to RunBank
			}
		}
		return tryUser;
		//if the use was not found, this will return null
	}

	public static boolean checkPassword(User currentUser, String tryPassword) {
		if(currentUser.getPassword().equals(tryPassword)) {
			return true;
		}
		else {return false;}	
	}

	public static User createAccount(String newName, String newLast, String newUsername, String newPassword) {
		int id = 0;
		BigDecimal balance = new BigDecimal(0);
		theList = (ArrayList<User>) dao.getUser();
		for(User u: theList) {
			if(id==u.getId()) {
				id++;
			}
		}
		User aNewUser = new User(id,newName,newLast,newUsername,newPassword,balance);
		dao.addUser(aNewUser);
		return aNewUser;
		
	}
	public void createFirstUser(User user) {
		dao.addUser(user);
	}

	public static boolean withdraw(User thisUser, double amount) {
		BigDecimal current = thisUser.getBalance();
		if(current.compareTo(new BigDecimal(amount))<0) {
			return false;
		}
		else {
			thisUser.setBalance(current.subtract(new BigDecimal(amount)));
			update(thisUser);
			return true;
		}
	}
	public static void deposit(User thisUser, double amount) {
		BigDecimal current = thisUser.getBalance();

		thisUser.setBalance(current.add(new BigDecimal(amount)));
		update(thisUser);
	}
	
	
	public static void changeName(User thisUser, String firstname, String lastname) {
		update(thisUser);
	}

	public static void changeEmail(User thisUser, String email) {
		thisUser.setEmail(email);
		update(thisUser);
	}
	
	public static void update(User thisUser) {
		//theList = (ArrayList<User>) dao.getUser();
		for(int i=0;i<theList.size(); i++) {
			if(theList.get(i).getId()==thisUser.getId()) {
				theList.remove(i);
				theList.add(thisUser);
			}
		}
		dao.update(theList);
	}

	public static void deleteAccount(User thisUser) {
		theList = (ArrayList<User>) dao.getUser();
		for(int i=0;i<theList.size(); i++) {
			if(theList.get(i).getId()==thisUser.getId()) {
				theList.remove(i);
			}
		}
		dao.update(theList);
	}

}

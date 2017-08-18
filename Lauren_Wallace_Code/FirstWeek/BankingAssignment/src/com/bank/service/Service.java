package com.bank.service;

import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DAOTextImpl;
import com.bank.pojos.User;

/*
 * The services that we will provide to the user through the console
 * we will need to call methods from DAOTextImpl to perform the services
 * 
 * methods in this interface:
 * loginUser, logoutUser, addUser, editUser, viewUser, checkUserStatus
 * 
 * static vars in this interface:
 * 
 * 
 */

public class Service {
	
	//use this object to manipulate data
	DAOTextImpl dao;
	static String userName;
	static String password;
	
	/*
	 * login functionality 
	 * what do you want to do functionality
	 */
	
	//creates a default dao object and scanner to use for user input
	public Service() {
		this.dao = new DAOTextImpl();
	}
	
	//logs in a user by taking the user input & calling doesUserExist to
	//setup 
	public void loginUser(Scanner in) {
		
		System.out.println("Enter your userName:");
		userName = in.nextLine();
		System.out.println("Enter your password:");
		password = in.nextLine();
		doesUserExist(userName, password);
	}
	
	public void addUser(Scanner in) {
		
		int i = 0;
		
		System.out.println("Enter your first name");
		String fn = in.nextLine().trim();
		
		System.out.println("Enter your last name");
		String ln = in.nextLine().trim();
		
		System.out.println("Enter your username");
		String userName = in.nextLine().trim();
		
		System.out.println("Enter your password");
		String password = in.nextLine().trim();
		
		if (doesUserExist(userName, password) == true) {
			System.out.println("The credentials are already taken.");
			addUser(in);
		}
		else {
			User newUser = new User(i++, fn, ln, userName, password);
		
			//writes to the file containing students
			dao.writeUser(newUser);
		}
	}
	
	boolean doesUserExist(String userName, String password) {
		
		dao.readUsers().stream().filter(user -> {
			if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return true;
			}
			return false;
		});
		return false;
	}
	
	public void editUserFName(String choice) {
		dao.updateUserFName(choice);
	}
	
	public void editUserLName(String choice) {
		dao.updateUserLName(choice);
	}
	
	public void editUserName(String choice) {
		dao.updateUserName(choice);
	}
	
	public void editUserPass(String choice) {
		dao.updateUserPass(choice);
	}
	
	public void editBalance(double b, String type) {
		dao.updateBalance(b, type);
	}
	
	public void viewUser() {
		
		dao.getUser().toString();
	}

}

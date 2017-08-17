package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;

import java.math.BigDecimal;
import java.util.*;

public class Service { //The service layer

	
	static DAO test = new DaoTextImpl();
	static boolean unique = true;
	//login functionality
	//what do you want to do functionality
	public void login() {
		Scanner input = new Scanner(System.in);
		String email;
//		createUser();

		System.out.print("Welcome to the Bank!\nPlease enter an email:\n");
		email = input.nextLine().trim();
		checkEmail(email);
		
	}
	public void logout() {
		
	}
	static void createUser() {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Enter your first name: ");
		String fn = input.nextLine().trim();
		System.out.println("Enter your last name: ");
		String ln = input.nextLine().trim();
		
	
		System.out.println("Enter your email: ");
		String email = input.nextLine().trim();
	
		
		System.out.println("Create a password: ");
		String pw = input.nextLine().trim();
		
		Integer id = random.nextInt(9999);
		String idString = id.toString();
		BigDecimal bal = new BigDecimal(0.00);
		String balString = bal.toString();
		
		User u = new User(idString,fn,ln,email,pw,balString);
		
		test.addUser(u);
	}
	static void displayUser() {
		ArrayList<User> users = test.readUser();
		for(User u: users)
			System.out.println(u);	
	}
	static boolean checkEmail(String str) {
		
	}
	
}

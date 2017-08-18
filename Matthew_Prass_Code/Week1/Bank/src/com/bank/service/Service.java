package com.bank.service;

import java.math.BigDecimal;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;

public class Service {

	DAO dao = new DaoTextImpl();
	
	
	
	public void mainMenu()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Login or create account? (1 for login, 2 for create account, 3 for exit)");	
		int choice = s.nextInt();
		
		
		switch(choice)
		{
		case 1:
			login();
			running();
			break;
		case 2:
			create();
			break;
		case 3:
			quit();
			break;
		default: 
			System.out.println("Please enter a corresponding number.");	
		}
		
	}



	private void quit() {
		System.out.println("Goodbye.");
		System.exit(0);
	}


	User create() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("First Name: ");
		String fn = s.nextLine();
		
		System.out.println("Last Name: ");
		String ln = s.nextLine();
		
		System.out.println("Email: ");
		String email = s.nextLine();
		
		System.out.println("Password: ");
		String pass = s.nextLine();
		
		System.out.println("Balance: ");
		String balance = s.nextLine();
		
		int id = (int) Math.floor(10000000*Math.random());
		
		User temp = new User();
		temp.setId(id);
		temp.setFirstname(fn);
		temp.setLastname(ln);
		temp.setEmail(email);
		temp.setPassword(pass);
		temp.setBalance(new BigDecimal(balance));
		
		User newUser = dao.addUser(temp);
		
		
		return newUser;
	}


	User login() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Email: ");
		String email = s.nextLine();
		
		System.out.println("Password: ");
		String pass = s.nextLine();
		
		
		return dao.getUser(email, pass);
		
	}
	
	void running() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("What would you like to do? (1 for updating your balance, 2 for checking your balance, 3 for edit you info, 4 to quit");
		int choice = s.nextInt();
	
		
		switch(choice)
		{
		case 1:
			updateBalance(login());
			break;
		case 2:
			checkBalance(login());
			break;
		case 3:
			editAccount(login());
		case 4:
			quit();
			break;
		default: 
			System.out.println("Please enter a valid option.");
		}
		
		
	}
	
	
	void updateBalance(User u)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Deposit or Withdraw? (1 or 2, or 3 to go back to the menu)");
		int choice = s.nextInt();
		System.out.println("Amount: ");
		BigDecimal amt = new BigDecimal(s.nextInt());
	
		
		switch(choice)
		{
		case 1: 
			u.setBalance(u.getBalance().add(amt));
			break;
		case 2:
			u.setBalance(u.getBalance().subtract(amt));
			break;
		case 3:
			running();
			break;
		default:
			System.out.println("Please enter a valid option.");
		}
		dao.editUser(u);

	}
	
	void checkBalance(User u)
	{
		System.out.println("Balance: " + u.getBalance());
		
	}
	
	void editAccount(User u)
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("First Name: ");
		String fn = s.nextLine();
		
		System.out.println("Last Name: ");
		String ln = s.nextLine();
		
		System.out.println("Email: ");
		String email = s.nextLine();
		
		System.out.println("Password: ");
		String pass = s.nextLine();
		
		
		u.setFirstname(fn);
		u.setLastname(ln);
		u.setEmail(email);
		u.setPassword(pass);
		
		dao.editUser(u);
		
		
	}
}

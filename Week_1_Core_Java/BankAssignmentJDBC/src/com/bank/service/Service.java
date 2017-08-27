package com.bank.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DAOImpl;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.pojos.User;

public class Service {
	
	static DAO test = new DAOImpl();
	
	public void login() {
		
		String email;
		String pass = "";
		boolean passCheck = false;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Welcome to the Bank!\nPlease enter an email:\n");
		email = input.nextLine().trim();
		boolean check = checkEmail(email);
		while(check != true) {
			System.out.println("Email not found. Please enter valid email: ");
			email = input.nextLine().trim();
			check = checkEmail(email);
		}
		if(check == true) {
			System.out.println("Please enter your password:");
			pass = input.nextLine().trim();
			passCheck = checkPassword(pass);
			while(passCheck != true) {
				System.out.println("Password Invalid. Please enter password:");
				pass = input.nextLine().trim();
				passCheck = checkPassword(pass);
		}
			if(passCheck == true) {
				if(pass.equals("admin"))
					adminMenu();
				else
					menu(email);
			}
			
		}
		
		
		
		
	
	}
	
	
	static boolean checkEmail(String str) {
		ArrayList<User> users = test.readUser();
		
		for(User u : users) {
			
			if(u.getEmail().equals(str))
				return true;
		}
		return false;
	}
	
	static boolean checkPassword(String str) {
		ArrayList<User> users = test.readUser();
		
		for(User u: users) {
			
			if(u.getPassword().equals(str))
				return true;

		}
		return false;
	}
	
	static void adminMenu() {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Good Day System Admin. Would you like to do the following?\n"
				+ "1.Add User\n"
				+ "2.Logout");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice != 3) {
			System.out.println("Invalid selection. Please choose again:\n"
					+ "1.Add User\n"
					+ "2.Logout");
			choice = input.nextInt();
		}
		if(choice == 1) {
			createUser();
		}
		else if(choice == 2) {
			logout();
		}
	}
	
	static void menu(String str) {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		String userInfo = str;
		ArrayList<User> users = test.readUser();
		
		for(User u: users) {
			if(u.getEmail().equals(str)) {
		System.out.println("Welcome to The Bank " + u.getFirstname() + " " + u.getLastname() + "! What would you like to do?\n"
				+ "1.Add Account\n"
				+ "2.View Balance\n"
				+ "3.Deposit\n"
				+ "4.Withdraw\n"
				+ "5.Edit Account\n"
				+ "6.Transfer Funds\n"
				+ "7.Open or Close An Account\n"
				+ "8.Logout");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice !=3 && choice != 4 && choice !=5 && choice != 6 && choice != 7 && choice!=8) {
			System.out.println("Please enter a valid selection.");
			System.out.println("Welcome to The Bank " + u.getFirstname() + " " + u.getLastname() + "! What would you like to do?\n"
					+ "1.Add Account\n"
					+ "2.View Balance\n"
					+ "3.Deposit\n"
					+ "4.Withdraw\n"
					+ "5.Edit Account\n"
					+ "6.Transfer Funds\n"
					+ "7.Open or Close an Account\n"
					+ "8.Logout");
			choice = input.nextInt();
		}
			}
		}
		switch(choice) {
		case(1):
			AddAccount(userInfo);
		case(2):
			viewBalance(userInfo);
		case(3):
			deposit(userInfo);
		case(4):
			withdraw(userInfo);
		case(5):
			editUser(userInfo);
		case(6):
			transferFunds(userInfo);
		case(7):
			openClose(userInfo);
		case(8):
			logout();
	}
		}
	
	static void createUser() {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Enter the first name: ");
		String fn = input.nextLine().trim();
		System.out.println("Enter the last name: ");
		String ln = input.nextLine().trim();
		
	
		System.out.println("Enter the email: ");
		String email = input.nextLine().trim();
		boolean check = alreadyExists(email);
		while(check == true) {
			System.out.println("This email already exists, please input another: ");
			email = input.nextLine().trim();
			check = alreadyExists(email);
		}
		
		System.out.println("Create a password: ");
		String pw = input.nextLine().trim();
		
	
		
		
		
		test.addUser(fn,ln,email,pw);
		adminMenu();
	}

	static boolean alreadyExists(String em) {
		ArrayList<User> users = test.readUser();
		
		for(User u : users) {
			
			if(u.getEmail().equals(em))
				return true;
		}
		return false;
		
	}
	
	

	
	static void AddAccount(String str) {
		ArrayList<User> users = test.readUser();
	
		ArrayList<AccountType> acctType = test.readAccountType();
		Scanner input = new Scanner(System.in);
		int choice, accountNum = 0;
		
		System.out.println("What kind of Account would you like to make? \n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit\n");
		choice = input.nextInt();
		
		if(choice == 1)
			accountNum = 1;
		else if (choice == 2)
			accountNum = 2;
		else if (choice == 3)
			accountNum = 3;
		
		for(User u: users) {
			
			if(u.getEmail().equals(str)) {
				
				test.createAccount(u,accountNum, "Open");
				
				System.out.println("Account Successfully Created!");
				
			}
		}
		menu(str);
		
	}
	
	
	static void viewBalance(String str) {
		ArrayList<User> users = test.readUser();
		User temp = new User();
		ArrayList<Account> acct = test.readAccount();
		ArrayList<Account> tempAcct = new ArrayList<Account>();
		ArrayList<AccountType> type = test.readAccountType();
		ArrayList<Integer> multiAccount = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		
		for(User u: users) {
			if(u.getEmail().equals(str)) {
				temp.setId(u.getId());
				}
			}
			
		for(Account a: acct) {
			if(temp.getId() == a.getUserId()) {
				tempAcct.add(a);
			}
			}
			System.out.println("Please choose an account type: \n"
					+ "1. Checking\n"
					+ "2. Saving\n"
					+ "3. Credit");
			choice = input.nextInt();
		for(Account a: tempAcct) {
			if(choice == a.getType()) {
				System.out.println("You have $" + a.getBalance() + " in this account");
			}

			}
			menu(str);
		}
		
		

	static void deposit(String str) {
		ArrayList<User> users = test.readUser();
		User temp = new User();
		ArrayList<Account> accounts = test.readAccount();
		ArrayList<Account> tempAcct = new ArrayList<Account>();
		int money = 0;
		int choice = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("How much money are you depositing today? ");
		money = input.nextInt();
		while(money <= 0) {
			System.out.println("Please enter an amount higher than 0");
			System.out.println("How much money are you depositing today? ");
			money = input.nextInt();
		}
		
		for(User u: users) {
			if(u.getEmail().equals(str)) {
				temp.setId(u.getId());
				}
			}
		for(Account a: accounts) {
			if(temp.getId() == a.getUserId()) {
				tempAcct.add(a);
			}
			}
		
		System.out.println("Choose an account: \n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit");
		choice = input.nextInt();
			for(Account a: tempAcct) {
				if(a.getStatus().equals("Open"))
					if(choice == a.getType()) {
						if(temp.getId() == a.getUserId()){
							money += a.getBalance();
							a.setBalance(money);
							test.UpdateBalance(a);
							System.out.println("Your total balance after deposit is $" + a.getBalance());
					}
			}
		}
		
		menu(str);
	}
	
	static void withdraw(String str) {
		ArrayList<User> users = test.readUser();
		User temp = new User();
		ArrayList<Account> accounts = test.readAccount();
		ArrayList<Account> tempAcct = new ArrayList<Account>();
		int money = 0;
		int choice = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("How much money are you withdrawing today? ");
		money = input.nextInt();
		while(money < 0) {
			System.out.println("Please enter an amount higher than 0");
			System.out.println("How much money are you withdrawing today? ");
			money = input.nextInt();
		}
		
		
		for(User u: users) {
			if(u.getEmail().equals(str)) {
				temp.setId(u.getId());
				}
			}
		for(Account a: accounts) {
			if(temp.getId() == a.getUserId()) {
				tempAcct.add(a);
			}
			}
		
		System.out.println("Choose an account: \n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit");
		choice = input.nextInt();
			for(Account a: tempAcct) {
				if(a.getStatus().equals("Open"))
					if(choice == a.getType()) {
						if(temp.getId() == a.getUserId()){
							money = a.getBalance() - money;
							System.out.println(money);
							if(money <= 0) {
								System.out.println("You have $0 after withdrawal");
								money = 0;
							}
							a.setBalance(money);
							test.UpdateBalance(a);
							System.out.println("Your total balance after deposit is $" + a.getBalance());
					}
			}
		}
		menu(str);
	}
	
	static void editUser(String str) {
		ArrayList<User> users = test.readUser();
		int choice = 0;
		String change;
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("What would you like to change?\n"
				+ "1.First Name\n"
				+ "2.Last Name\n"
				+ "3.Email\n"
				+ "4.Password\n");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice !=3 && choice != 4) {
			System.out.println("Invalid selection, please try again");;
			System.out.println("What would you like to change?\n"
					+ "1.First Name\n"
					+ "2.Last Name\n"
					+ "3.Email\n"
					+ "4.Password\n");
			choice = input.nextInt();
		}
		
		for(User u: users) {
			if(choice == 1) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new first name: ");
				change = input.next().trim();
				u.setFirstname(change);
				test.editUser(u);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			else if(choice == 2) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new last name: ");
				change = input.next().trim();
				u.setLastname(change);
				test.editUser(u);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			else if(choice == 3) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new email: ");
				change = input.next().trim();
				u.setEmail(change);
				test.editUser(u);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			else if(choice == 4) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new password: ");
				change = input.next().trim();
				u.setPassword(change);
				test.editUser(u);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			
		}
	}
	
	static void transferFunds(String str) {
		ArrayList<User> users = test.readUser();
		ArrayList<Account> accts = test.readAccount();
		User temp = new User();
		int choice = 0;
		int money = 0;
		int total = 0;
		Scanner input = new Scanner(System.in);
		
		for(User u: users) {
			if(u.getEmail().equals(str))
				temp.setId(u.getId());
		}
		
		System.out.println("What account do you want to transfer money from? \n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit");
		choice = input.nextInt();
		
		System.out.println("How much money do you wish to withdraw?");
		money = input.nextInt();
	
		for(Account t: accts) {

			if(temp.getId() == t.getUserId()) {
				
					if(t.getType() == choice) {
						
						total = t.getBalance() - money;
						t.setBalance(total);
						test.UpdateBalance(t);
						System.out.println("Withdrawal successful. You have $" + t.getBalance() + " left on this account.");
				}
			}
		}
		
		System.out.println("What account do you want to transfer to?\n"
				+ "1. Checking\n"
				+ "2. Savings\n"
				+ "3. Credit \n");
		choice = input.nextInt();
		
		for(Account t:accts) {
			if(temp.getId() == t.getUserId()) {
					
					if(t.getType() == choice){
						money += t.getBalance();
						t.setBalance(money);
						test.UpdateBalance(t);
						System.out.println("Deposit successful. You now have $" + t.getBalance() + " on this account");
				}
			}
		}
		
		
		menu(str);
	}
	
	static void openClose(String str) {
		ArrayList<User> users = test.readUser();
		ArrayList<Account> accts = test.readAccount();
		User temp = new User();
		Scanner input = new Scanner(System.in);
		int choice =0;
		
		
		for(User u : users){
			if(u.getEmail().equals(str)) {
				temp.setId(u.getId());
			}
		}
		
		System.out.println("Would you like to open or close an account?\n"
				+ "1. Open\n"
				+ "2. Close");
		choice = input.nextInt();
		
		if(choice == 1) {
			System.out.println("Choice an account to open:\n"
					+ "1.Checking\n"
					+ "2.Savings\n"
					+ "3.Credits");
			choice = input.nextInt();
			for(Account t: accts) {
				if(temp.getId() == t.getUserId())
					if(t.getType() == choice) {
						t.setStatus("Open");
						test.UpdateAccount(t);
						System.out.println("This account has been opened. ");
					}
			}
		}
		else if (choice == 2) {
			System.out.println("Choice an account to close:\n"
					+ "1.Checking\n"
					+ "2.Savings\n"
					+ "3.Credits");
			choice = input.nextInt();
			for(Account t: accts) {
				if(temp.getId() == t.getUserId())
					if(t.getType() == choice) {
						t.setStatus("Close");
						test.UpdateAccount(t);
						System.out.println("This account has been closed. ");
					}
			}
		}
		
		
		
		
		
		menu(str);
	}
	
	static void logout() { //Simple logout function for logging out.
		System.exit(0);
	}
	
	/*
	 * The following is for the admin to create a user in the system.
	 * It will have the admin input the first name, last name, email, and password.
	 * Since its a new user we assume that they start off with a 0 dollar balance.
	 * The ID is a randomly generated 4 digit number between 0 to 9999
	 * The new user is appended to the text file, and finally the admin is sent back to the admin menu
	 */
	
	
}
 
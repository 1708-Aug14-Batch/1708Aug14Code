package com.bank.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.User;
import com.bank.pojos.Account;
import com.bank.service.Service;

public class RunBank {
	static Scanner scan;
	static Service bankService;
	static int attempts = 0;

	public static void main(String[] args) {
		User user = null;
		Account account;
		ArrayList<Account> accounts = null;
		bankService = new Service();
		Scanner scan;
		Scanner scanner = scan = new Scanner(System.in);
		System.out.println("Hello. Welcome to The Bank. Are you already a user?");
		String input = scan.nextLine();
		boolean valid = true;
		while(valid) {
			if(input.trim().equalsIgnoreCase("YES") || input.trim().equalsIgnoreCase("Y")) {
				valid = false;
				user = login();	
			}
			else if (input.trim().equalsIgnoreCase("NO") || input.trim().equalsIgnoreCase("N")){
				valid = false;
				user = createUser();
			}
			else {
				System.out.println("I'm sorry, that was not a valid response. Try entering \"yes\" or \"no\"");
			}
		}
		if (user == null) {input = "logout";}
		else{accounts = bankService.getOpenAccounts(user);}
		while(!input.equals("logout")) {
			int option = printOptions();
			switch(option) {
			case(1):
				if(accounts.size() < 7) {
					System.out.println("To select the type of account you would like to open,");
					System.out.println("press 1) for Checking, 2) for Savings, or 3) for Credit");
					input = scan.nextLine();
					account = bankService.addAccount(user, Integer.parseInt(input));
					System.out.println(account.getAccountType().getDescription()+" account created");
					System.out.println(" the account number is "+account.getId());
					accounts.add(account);
				}
				else {
					System.out.println("Sorry, you have too many accounts open. Try closing an existing account first.");
				}
			break;
			case(2):
				System.out.println("Which account would you like to close?");
			System.out.println("Press ");
			for(int i=0;i<accounts.size();i++) {
				System.out.println(i+" for "+accounts.get(i).getAccountType().getDescription()
						+" account "+accounts.get(i).getId()+" with "+accounts.get(i).getBalance()+" ,");
			}
			input = scan.nextLine();
			Account closing = accounts.get(Integer.parseInt(input));
			bankService.closeAccount(closing);
			accounts.remove(Integer.parseInt(input));
			String tran = "no";
			if(accounts.size() != 0) {
				System.out.println("Would you like to transfer the remaining balance to an existing account? (yes / no)");
				tran = scan.nextLine();
			}
			if(tran.equalsIgnoreCase("yes")) {
				System.out.println("Which account would you like to transfer to?");
				System.out.println("Press ");
				for(int i=0;i<accounts.size();i++) {
					System.out.println(i+" for "+accounts.get(i).getAccountType().getDescription()
							+" account "+accounts.get(i).getId()+" with balance: "+accounts.get(i).getBalance());
				}
				input = scan.nextLine();
				Account deposit = accounts.get(Integer.parseInt(input));
				bankService.transfer(closing, deposit, closing.getBalance());
				System.out.println(closing.getBalance()+ " successfuly transfered, account "+closing.getId()+" succcessfully closed.");
			}
			else {
				System.out.println("The remaining balance will be sent in the mail.");
			}
			break;
			case(3):
				System.out.println("From which account would you like to withdraw?");
			System.out.println("Press ");
			for(int i=0;i<accounts.size();i++) {
				System.out.println(i+" for "+accounts.get(i).getAccountType().getDescription()
						+" account "+accounts.get(i).getId()+" with balance: "+accounts.get(i).getBalance());
			}
			input = scan.nextLine();
			Account withdraw = accounts.get(Integer.parseInt(input));
			System.out.println("How much would you like to withdraw? $"+withdraw.getBalance()+ " available");
			input = scan.nextLine();
			account = bankService.withdraw(withdraw, Double.parseDouble(input));
			if(account != null) {
				accounts.remove(withdraw);
				accounts.add(account);
			}
			else {
				System.out.println(Double.parseDouble(input)+" successfully wuthdrawn");
			}
			break;
			case(4):
				System.out.println("Which account would you like to deposit to?");
			System.out.print("Press ");
			for(int i=0;i<accounts.size();i++) {
				System.out.println(i+" for "+accounts.get(i).getAccountType().getDescription()
						+" account "+accounts.get(i).getId()+" with balance: "+accounts.get(i).getBalance());
			}
			input = scan.nextLine();
			Account deposit = accounts.get(Integer.parseInt(input));
			System.out.println("How much would you like to deposit? This account currently has $"+deposit.getBalance());
			input = scan.nextLine();
			account = bankService.deposit(deposit, Double.parseDouble(input));
			accounts.remove(deposit);
			accounts.add(account);
			System.out.println(Double.parseDouble(input)+" successfully deposited");

			break;
			case(5):
				System.out.println("From which account would you like to transfer?");
			System.out.print("Press ");
			for(int i=0;i<accounts.size();i++) {
				System.out.println(i+" for "+accounts.get(i).getAccountType().getDescription()
						+" account "+accounts.get(i).getId()+" with balance: "+accounts.get(i).getBalance());
			}
			input = scan.nextLine();
			withdraw = accounts.get(Integer.parseInt(input));
			System.out.println("Which account would you like to transfer into?");
			System.out.print("Press ");
			for(int i=0;i<accounts.size();i++) {
				System.out.println(i+" for "+accounts.get(i).getAccountType().getDescription()
						+" account "+accounts.get(i).getId()+" with balance: "+accounts.get(i).getBalance());
			}
			input = scan.nextLine();
			deposit = accounts.get(Integer.parseInt(input));
			System.out.println("How much would you like to transfer? $"+withdraw.getBalance()+" available");
			input = scan.nextLine();
			bankService.transfer(withdraw, deposit, Double.parseDouble(input));
			System.out.println(Double.parseDouble(input)+" successfully transferred");
			break;
			case(6):
				System.out.println("Your current open accounts are ");
			double bigbal =0;
			for(Account a: accounts) {
				System.out.println(a.getAccountType().getDescription()
						+" account "+a.getId()+" with balance: "+a.getBalance());
				bigbal += a.getBalance();
			}
			System.out.println("Your total available funds are $"+bigbal);
			break;
			case(7):
				String edit = "yes";
			while(edit.equalsIgnoreCase("yes")){
				switch(editInfo()) {
				case 1:
					System.out.println("Enter new first name");
					input = scan.nextLine();
					user.setFirstname(input);
					bankService.updateUser(user);
					System.out.println("Name successfuly changed to "+user.getFirstname());
					break;
				case 2:
					System.out.println("Enter new last name");
					input = scan.nextLine();
					user.setLastname(input);
					bankService.updateUser(user);
					System.out.println("Last name successfuly changed to "+user.getLastname());
					break;
				case 3:
					System.out.println("Enter new username");
					input = scan.nextLine();
					user.setUsername(input);
					bankService.updateUser(user);
					System.out.println("Username successfuly changed to "+user.getUsername());
					break;
				case 4:
					System.out.println("Enter new password");
					input = scan.nextLine();
					user.setPassword(input);
					bankService.updateUser(user);
					System.out.println("Password successfuly changed");
					break;

				}
				System.out.println("Is there anything else you would like to edit?");
				edit = scan.nextLine();
			}
			option = 7;
			break;
			case(8):
				input = "logout";
			break;
			}
		}
		System.out.println("Goodbye.");
		user = null;
		accounts = null;
		account = null;

	}

	private static User login() {
		while(attempts<6) {	
			User u;
			scan = new Scanner(System.in);
			System.out.println("Please enter your username ");
			String username = scan.nextLine();
			System.out.println("Enter password: ");
			String pwd = scan.nextLine();
			u = Service.login(username, pwd);
			//bankService.login returns the Use associated with this email if it exists
			//it returns null if it does not exist
			if(u!=null) {
				System.out.println("Welcome back "+ u.getFirstname());
				return u;
			}
			else {
			System.out.println("Invalid username or password");
			attempts += 1;
			return login();
			}
		}
		System.out.println("Too many failed attempts. Try again later");
		return null;
	}

	private static User createUser() {
		User user;
		bankService = new Service();
		scan = new Scanner(System.in);
		System.out.println("To create a new account, enter your first name");
		String fn = scan.nextLine();
		System.out.println("Enter your last name ");
		String ln = scan.nextLine();
		System.out.println("Enter a username");
		String usr = scan.nextLine();
		System.out.println("Enter a password");
		String pwd = scan.nextLine();
		user = bankService.addUser(fn, ln, usr, pwd);
		while(user==null) {
			System.out.println("This username already exists, enter a new one, "
					+ "or enter \"login\" to login with an existing username.");
			usr = scan.nextLine();
			if(usr.equals("login")) {
				login();
				return null;
			}
			else {
				user = bankService.addUser(fn, ln, usr, pwd);
				System.out.println("New user created! Welcome to The Bank "+fn+".");
			}
		}
		return user;
	}

	private static int printOptions() {
		scan = new Scanner(System.in);
		System.out.println("What woud you like to do today? Enter a number to choose");
		System.out.println("1) add an account"); 
		System.out.println("2) close an account");
		System.out.println("3) withdraw funds");
		System.out.println("4) deposit funds"); 
		System.out.println("5) transfer funds");
		System.out.println("6) view current balance");
		System.out.println("7) edit information such as name or password"); 
		System.out.println("8) logout");
		int input = scan.nextInt();
		return input;
	}

	private static int editInfo() {
		System.out.println("Press 1) to change your first name");
		System.out.println("Press 2) to change your last name");
		System.out.println("Press 3) to change your username");
		System.out.println("Press 4) to change your password");
		return scan.nextInt();

	}


}

package com.bank.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.daoimpl.DAO;
import com.bank.daoimpl.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;

public class Service 
{
	//belongs to every instance of service class
	static DAO dao = new DaoImpl();
	//create a new user per service
	User user = new User();
	
	//welcome screen
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
		s.close();
	}


	//quitting the program
	private void quit() {
		System.out.println("Goodbye.");
		System.exit(0);
	}

	//creating a new user
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
		
		//call the add user method from daoimpl, 
		//store their resulting id as the id
		//of the new user
		//set that new user equal to the user
		//declared at the top
		int id = dao.addUser(fn, ln, email, pass);
		User newUser = new User(fn,ln,email,pass);
		newUser.setId(id);
		user = newUser;
		return user;
	}

	//existing user login
	User login() {
		
		ArrayList<User> list = dao.getAllUsers();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Email: ");
		String email = s.nextLine();
		
		System.out.println("Password: ");
		String pass = s.nextLine();
		
		//find their credentials
		for(User u:list)
		{
			if(u.getEmail().equals(email) && u.getPassword().equals(pass) )
			{ 
				user = dao.getUser(u.getId());
			}
		}
		return user;
	}
	
	//moreso the main menu than mainMenu()...
	void running() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("What would you like to do? (1 for viewing accounts, 2 for updating your info, 3 to quit)");
		int choice = s.nextInt();
	
		switch(choice)
		{
		case 1:
			checkAccounts(user);
			break;
		case 2:
			updateInfo(user);
			break;
		case 3:
			quit();
			break;
		default: 
			System.out.println("Please enter a valid option.");
		}
		
	}
	
	//checking all your accounts held at the bank
	public void checkAccounts(User u)
	{
		ArrayList<Account> list = dao.getAllAccountsForUser(u.getId());
		Scanner s = new Scanner(System.in);
		//checking to see if you have any, if you don't, offers to create one
		if(list.isEmpty())
		{
			System.out.println("You have no accounts here, create a new one?(1 for yes, 2 to quit");
			int choice  = s.nextInt();
			switch(choice)
			{
			case 1:
				newAccount(user);
				break;
			case 2:
				quit();
				break;
			default:
				System.out.println("Not a valid input!");
			}
		}
		else
		{
			//show your accounts
			for(Account a:list)
				System.out.println(a.toString());
			
			System.out.println("Would you like to...");
			System.out.println("Update funds?(press 1)");
			System.out.println("Transfer funds? (press 2)");
			System.out.println("Open another account? (press 3)");
			System.out.println("Close and account? (press 4");
			System.out.println("Quit? (press 5)");
			
			int choice2 = s.nextInt();
			switch(choice2)
			{
			case 1:
				updateFunds(user);
				break;
			case 2:
				transferFunds(user);
				break;
			case 3:
				newAccount(user);
				break;
			case 4:
				closeAccount(user);
			case 5:
				quit();
			default: 
				System.out.println("Please enter a valid option.");
			}
		}
		
		
	}


	//add a new account that isn't the same type as another account held
	public void newAccount(User u)
	{
		ArrayList<Account> list = dao.getAllAccountsForUser(u.getId());
		Account newAct;
		//cannot create more than 3 accounts
		if(list.size() >= 3)
			System.out.println("Cannout creat anymore accounts!");
		else {
			Scanner s = new Scanner(System.in);
			System.out.println("What kind of account would you like to create?(1 for checking, 2 for savings, 3 for credit)");
			int choice = s.nextInt();
			//checking to see if you have the account already
			for(Account a:list)
			{
				if(a.getType().getId() == choice )
				{
					System.out.println("Cannout creat more accounts of that type!");
					return;
				}
			}
			switch(choice)
			{
			case 1:
				newAct = new Account(0,u,dao.getAccountType(1));
				dao.creatAccount(u, 1);
				list.add(newAct);
				break;
			case 2:
				newAct = new Account(0,u,dao.getAccountType(2));
				dao.creatAccount(u, 2);
				list.add(newAct);
				break;
			case 3:
				newAct = new Account(0,u,dao.getAccountType(3));
				dao.creatAccount(u, 3);
				list.add(newAct);
				break;
			default: 
				System.out.println("Please enter a valid option.");
			}
		}
	}
	
	//depositing and withdrawing funds from your accounts
	//also checks to see if you have the account you wish to update
	void updateFunds(User u)
	{
		ArrayList<Account> list = dao.getAllAccountsForUser(u.getId());
		Scanner s = new Scanner(System.in);
		System.out.println("Into which account?(1 for checking,2 for savings, 3 for credit)");
		int choice = s.nextInt();
		switch(choice)
		{
		case 1: 
			for(Account a:list)
				if(a.getType().getId() == 1)
				{
					System.out.println("Deposit or withdraw? (1 for deposit, 2 for withdraw)");
					int choice2 = s.nextInt();
					System.out.println("How much?");
					double amt = s.nextDouble();
					if(choice2 == 1)
					{
						a.setBalance(a.getBalance()+amt);
						dao.updateAccount(a);
						break;
					}
					else if(choice2 == 2)
					{
						a.setBalance(a.getBalance()-amt);
						dao.updateAccount(a);
						break;
					}
				}
				else
				{
					break;
				}
			//System.out.println("Account doesn't exist!");
			break;
		case 2:
			for(Account a:list)
				if(a.getType().getId() == 2)
				{
					System.out.println("Deposit or withdraw? (1 for deposit, 2 for withdraw)");
					int choice2 = s.nextInt();
					System.out.println("How much?");
					double amt = s.nextDouble();
					if(choice2 == 1)
					{
						a.setBalance(a.getBalance()+amt);
						dao.updateAccount(a);
						break;
					}
					else if(choice2 == 2)
					{
						a.setBalance(a.getBalance()-amt);
						dao.updateAccount(a);
						break;
					}
				}
				else
				{
					continue;
				}
			//System.out.println("Account doesn't exist!");
			
			break;
		case 3:
			for(Account a:list)
				if(a.getType().getId() == 3)
				{
					System.out.println("Deposit or withdraw? (1 for deposit, 2 for withdraw)");
					int choice2 = s.nextInt();
					System.out.println("How much?");
					double amt = s.nextDouble();
					if(choice2 == 1)
					{
						a.setBalance(a.getBalance()+amt);
						dao.updateAccount(a);
						break;
					}
					else if(choice2 == 2)
					{
						a.setBalance(a.getBalance()-amt);
						dao.updateAccount(a);
						break;
					}
				}
				else
				{
					continue;
				}
			//System.out.println("Account doesn't exist!");
			break;
		default:
			System.out.println("Please enter a valid option.");
		}
	}
	//transferring funds from account to account
	public void transferFunds(User user) 
	{
		ArrayList<Account> list = dao.getAllAccountsForUser(user.getId());
		Scanner s = new Scanner(System.in);
		if(list.size() <= 1) {
			System.out.println("You must have more than 1 account to transfer.");
			return;
		}
		//print the accounts for convenience
		System.out.println("Select the account you would like to transfer from: (Enter the account type id)");
		for(Account a :list)
		{
			System.out.println(a);
		}
		int choice = s.nextInt();
		switch(choice)
		{
		//checking to savings 
		case 1:
			System.out.println("To which account? (1 for savings, 2 for credit)");
			int choice2 = s.nextInt();
			System.out.println("Amount?");
			double amt = s.nextDouble();
			if(choice2 == 1) {
				for(Account a: list)
				{
					if(a.getType().getId() == 1)
					{
						for(Account ta:list)
						{
							if(ta.getType().getId() == 2)
							{
								a.setBalance(a.getBalance()-amt);
								dao.updateAccount(a);
								ta.setBalance(ta.getBalance()+amt);
								dao.updateAccount(ta);
							}
						}
					}
				}
			}
			//checking to credit
			else {
				for(Account a: list)
				{
					if(a.getType().getId() == 1)
					{
						for(Account ta:list)
						{
							if(ta.getType().getId() == 3)
							{
								a.setBalance(a.getBalance()-amt);
								dao.updateAccount(a);
								ta.setBalance(ta.getBalance()+amt);
								dao.updateAccount(ta);
							}
						}
					}
				}
			}
			break;
		//savings to checking
		case 2:
			System.out.println("To which account? (1 for checking, 2 for credit)");
			int choice3 = s.nextInt();
			System.out.println("Amount?");
			double amt2 = s.nextDouble();
			if(choice3 == 1) {
				for(Account a: list)
				{
					if(a.getType().getId() == 2)
					{
						for(Account ta:list)
						{
							if(ta.getType().getId() == 1)
							{
								a.setBalance(a.getBalance()-amt2);
								dao.updateAccount(a);
								ta.setBalance(ta.getBalance()+amt2);
								dao.updateAccount(ta);
							}
						}
					}
				}
			}
			//savings to credit
			else {
				for(Account a: list)
				{
					if(a.getType().getId() == 2)
					{
						for(Account ta:list)
						{
							if(ta.getType().getId() == 3)
							{
								a.setBalance(a.getBalance()-amt2);
								dao.updateAccount(a);
								ta.setBalance(ta.getBalance()+amt2);
								dao.updateAccount(ta);
							}
						}
					}
				}
			}
			break;
		//credit to checking
		case 3: 
			System.out.println("To which account? (1 for checking, 2 for savings)");
			int choice4 = s.nextInt();
			System.out.println("Amount?");
			double amt3 = s.nextDouble();
			if(choice4 == 1) {
				for(Account a: list)
				{
					if(a.getType().getId() == 3)
					{
						for(Account ta:list)
						{
							if(ta.getType().getId() == 1)
							{
								a.setBalance(a.getBalance()-amt3);
								dao.updateAccount(a);
								ta.setBalance(ta.getBalance()+amt3);
								dao.updateAccount(ta);
							}
						}
					}
				}
			}
			//credit to savings
			else {
				for(Account a: list)
				{
					if(a.getType().getId() == 3)
					{
						for(Account ta:list)
						{
							if(ta.getType().getId() == 2)
							{
								a.setBalance(a.getBalance()-amt3);
								dao.updateAccount(a);
								ta.setBalance(ta.getBalance()+amt3);
								dao.updateAccount(ta);
							}
						}
					}
				}
			}
			break;
		}
		
		
	}
	//updating the user info or deleting the profile
	void updateInfo(User u)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Would you like to update your info or delete your profile? (1 for updating, 2 for deleting)");
		int choice = s.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("First Name: ");
			String fn = s.next();
			
			System.out.println("Last Name: ");
			String ln = s.next();
			
			System.out.println("Email: ");
			String email = s.next();
			
			System.out.println("Password: ");
			String pass = s.next();
			
			u.setId(u.getId());
			u.setFirstname(fn);
			u.setLastname(ln);
			u.setEmail(email);
			u.setPassword(pass);
			
			dao.updateUser(u);
			break;
		case 2:
			ArrayList<Account> list = dao.getAllAccountsForUser(u.getId());
			for(Account a: list)
			{
				dao.deleteAccount(a);
			}
			dao.deleteUser(u);
		}
		
	}
	//close a specified account
	public void closeAccount(User u) 
	{
		ArrayList<Account> list = dao.getAllAccountsForUser(u.getId());
		Scanner s = new Scanner(System.in);
		System.out.println("Which account would you like to delete?(1 for checking, 2 for savings, 3 for credit)");
		int choice = s.nextInt();
		for(Account a: list)
		{
			if(a.getType().getId() == choice)
			{
				dao.deleteAccount(a);
				list.remove(a);
				break;
			}
		}
	}
}



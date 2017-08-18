package com.bank.service;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl; //Importing in the DAO and Pojos for use in the Service layer
import com.bank.pojos.User;


import java.util.*; //Bringing in util for Scanners and the ArrayList

public class Service { //The service layer

	
	static DAO test = new DaoTextImpl(); //Setting up a variable to pull from DAO throughout the program
//	static boolean unique = true;
	
	public void login() { //Login function
		
//		User user1 = new User("0001", "System", "Admin", "sysadmin@bank.com", "admin", 0);
//		User user2 = new User("1234", "Andrew", "Bonds", "apbonds1@gmail.com", "testtest", 0);
//		User user3 = new User("5678", "Sara", "Thomason", "sthomason@gmail.com", "anothertest", 100);
//		test.addUser(user1);
//		test.addUser(user2);
//		test.addUser(user3);
		
		
		/*
		 * Establishing some variables for the main login function.
		 * I have ID's being established, but I use the email for validation throughout the program.
		 * Most of the functions will have email passed as an argument to confirm the user before making any changes/outputs
		 */
		String email;
		String pass = "";
		boolean passCheck = false;
		Scanner input = new Scanner(System.in);

		/*
		 * The login screen. Users enter an email, it gets checked that its in the program, then the same is for the password.
		 * Both email and password have some input validation that runs a loop if the user inputs invalid information and won't leave until its correct.
		 * Finally I use the password to determine if its a normal user or the system admin. Each have their own unique menus.
		 */
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
	public static void logout() { //Simple logout function for logging out.
		System.exit(0);
	}
	
	/*
	 * The following is for the admin to create a user in the system.
	 * It will have the admin input the first name, last name, email, and password.
	 * Since its a new user we assume that they start off with a 0 dollar balance.
	 * The ID is a randomly generated 4 digit number between 0 to 9999
	 * The new user is appended to the text file, and finally the admin is sent back to the admin menu
	 */
	static void createUser() {
		
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("Enter the first name: ");
		String fn = input.nextLine().trim();
		System.out.println("Enter the last name: ");
		String ln = input.nextLine().trim();
		
	
		System.out.println("Enter the email: ");
		String email = input.nextLine().trim();
	
		
		System.out.println("Create a password: ");
		String pw = input.nextLine().trim();
		
		Integer id = random.nextInt(9999);
		String idString = id.toString();
		Integer bal = new Integer(0);
		;
		
		User u = new User(idString,fn,ln,email,pw,bal);
		
		test.addUser(u);
		adminMenu();
	}
	
	/*
	 * I was having issues with deleting users, as overwriting those values caused errors when stepping through again.
	 */
//	static void deleteUser() {
//		ArrayList<User> users = test.readUser();
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter the ID of the person you want deleted");
//		String temp = input.nextLine().trim();
//		for(User u: users) {
//			if(u.getUserID().equals(temp)) {
//				users.clear();
//			}
//		}
//	}
	

	/*
	 * The following two boolean functions are for checking the email and the password
	 * It creates an arraylist of Users, steps through each user, and if the email/password is correct return true to continue. 
	 */
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
			
			if(u.getPassWord().equals(str))
				return true;

		}
		return false;
	}
	
	
	/*
	 * The following three functions are used for displaying and editing user balance for the normal user.
	 * Each function has the email passed through as an argument to grab the appropriate user info.
	 * The first function is viewBalance() which simple steps through and outputs the appropriate balance of the user
	 * The second function is deposit(). Using an int variable called money it adds the amount inputted by the user to their balance and displays the new total.
	 * The third function, withdrawal(), is similar to deposit() except it takes away instead of adds. If the user inputs a number below 0 it runs a loop until the user puts in an accurate number.
	 * 
	 */
	
	static void viewBalance(String str) {
		ArrayList<User> users = test.readUser();
		for(User u: users) {
			if(u.getEmail().equals(str))
				System.out.println("Your total balance is $" + u.getBalance());
		}
		menu(str);
	}
	static void deposit(String str) {
		ArrayList<User> users = test.readUser();
		int money = 0;
		
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
				money += u.getBalance();
				u.setBalance(money);
				test.editUser(users);
				System.out.println("Your total balance after deposit is $" + u.getBalance());
			}
		}
		menu(str);
	}
	
	static void withdraw(String str) {
		ArrayList<User> users = test.readUser();
		int money = 0;
		
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
				money = u.getBalance() - money;
				if(money <= 0) {
					System.out.println("You have $0 after withdrawal");
					money = 0;
				}
				u.setBalance(money);
				test.editUser(users);
				System.out.println("Your total balance after withdrawal is $" + u.getBalance());
			}
		}
		menu(str);
	}
	
	/*
	 * This function, editUser(), is used by the Normal User to edit their information (except for the ID and balance).
	 * First we determine with the user what they want changed. Inputing anything else will cause a loop until they put in a correct value.
	 * Then we step through the User array and then go to the if statement associated with their selection.
	 * They input their change, its set to the user pulled, and then afterwards its written back into the text file.
	 */
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
				u.setFirstName(change);
				test.editUser(users);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			else if(choice == 2) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new last name: ");
				change = input.next().trim();
				u.setLastName(change);
				test.editUser(users);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			else if(choice == 3) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new email: ");
				change = input.next().trim();
				u.setEmail(change);
				test.editUser(users);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			else if(choice == 4) {
				if(u.getEmail().equals(str)) {
				System.out.println("Enter your new password: ");
				change = input.next().trim();
				u.setPassWord(change);
				test.editUser(users);
				System.out.println("Change Successful");
				menu(str);
				}
			}
			
		}
	}
	
	/*
	 * These last two functions are the menus used by the Admin and the Normal User.
	 * It displays a selection that the user chooses. In the event they put something other than whats provided it loops until they do.
	 */
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
		System.out.println("Welcome to The Bank " + u.getFirstName() + " " + u.getLastName() + "! What would you like to do?\n"
				+ "1.View Balance\n"
				+ "2.Deposit\n"
				+ "3.Withdraw\n"
				+ "4.Edit Account\n"
				+ "5.Logout");
		choice = input.nextInt();
		while(choice != 1 && choice != 2 && choice !=3 && choice != 4 && choice !=5) {
			System.out.println("Please enter a valid selection.");
			System.out.println("Welcome to The Bank " + u.getFirstName() + " " + u.getLastName() + "! What would you like to do?\n"
					+ "1.View Balance\n"
					+ "2.Deposit\n"
					+ "3.Withdraw\n"
					+ "4.Edit Account\n"
					+ "5.Logout");
			choice = input.nextInt();
		}
			}
		}
		switch(choice) {
		case(1):
			viewBalance(userInfo);
		case(2):
			deposit(userInfo);
		case(3):
			withdraw(userInfo);
		case(4):
			editUser(userInfo);
		case(5):
			logout();
	}
		}
	}
	


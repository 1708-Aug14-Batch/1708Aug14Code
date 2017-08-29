package com.bank.run;

import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.service.Service;

public class RunBank {
	
	public static int loggedIn;
	private static Service bankService;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		bankService = new Service();
		loggedIn = -1;
		viewOptions();		
	}
	
	/**
	 * The recursive method that displays the options a user has to them, and makes calls to the bank scanner accordingly.
	 * Once the current call completes, the method calls itself again, repeating the cycle.
	 * If someone is currently logged in, it gives them a certain set of menu options, and if not, it gives them a different set.
	 * If the user inputs an option that doesn't exist, they are asked to provide a different response.
	 */
	static void viewOptions() {
		int selection = 0;
		if(loggedIn==-1) {
			System.out.println("===========================================");
			System.out.println("What would you like to do?: ");
			System.out.println("| 1. Login");
			System.out.println("| 2. New User");
			System.out.println("===========================================");
			selection = scan.nextInt();
			if(selection==1) {
				login();
			}
			else if(selection==2) {
				addUser();
			}
			else {
				System.out.println("Please select an option.");
			}
		}
		else {
			System.out.println("===========================================");
			System.out.println("What would you like to do?: ");
			System.out.println("| 1. Withdraw Funds");
			System.out.println("| 2. Deposit Funds");
			System.out.println("| 3. Edit Account Details");
			System.out.println("| 4. View Account Balance");
			System.out.println("| 5. Create new account");
			System.out.println("| 6. Logout");
			System.out.println("===========================================");
			selection = scan.nextInt();
			if(selection==1) {
				int accId = getTheAccountId();
				if(accId!=-1) {
					System.out.println("How much would you like to withdraw from your account?");
					System.out.println("Enter amount: $");
					double amountChange = scan.nextDouble();
					changeFunds(accId,-amountChange);
				}
			}
			else if(selection==2) {
				int accId = getTheAccountId();
				if(accId!=-1) {
					System.out.println("How much would you like to deposit into your account?");
					System.out.println("Enter amount: $");
					double amountChange = scan.nextDouble();
					changeFunds(accId,amountChange);
				}
			}
			else if(selection==3) {
				System.out.println("What information would you like to update?:");
				System.out.println("|1. Email");
				System.out.println("|2. First Name");
				System.out.println("|3. Last Name");
				System.out.println("|4. Password");
				int select = scan.nextInt();
				if (select==1) {
					String newEmail = "";
					scan.nextLine();
					System.out.println("What would you like your new email to be?: ");
					newEmail = scan.nextLine();
					if(bankService.exists(newEmail)) {
						System.out.println("That email is already in our database. Please login to that account, or try again.");
					}
					else {
						editEmail(newEmail);
					}
				}
				else if(select==2) {
					String newFn = "";
					scan.nextLine();
					System.out.println("What would you like to update your first name to?: ");
					newFn = scan.nextLine();
					editFirstName(newFn);
				}
				else if (select==3) {
					String newLn = "";
					scan.nextLine();
					System.out.println("What would you like to update your last name to?: ");
					newLn = scan.nextLine();
					editLastName(newLn);
				}
				else if (select==4) {
					String newPass="";
					scan.nextLine();
					System.out.println("What would you like to update your password to?: ");
					newPass = scan.nextLine();
					editPassword(newPass);
				}
			}
			else if(selection==4) {
				viewBalance();
			}
			else if(selection==5) {
				addAccount();
			}
			else if(selection==6) {
				logout();
			}
			else {
				System.out.println("Please select what you'd like to do");
			}
		}
		viewOptions();
		scan.close();
	}
	
	
	static int getTheAccountId() {
		System.out.println("What kind of account are you updating?");
		System.out.println("Enter 1 for your checking account, and 2 for your savings: ");
		int selection = scan.nextInt();
		if(selection==1||selection==2) {
			Account theAccount = bankService.findAccount(loggedIn, selection);
			if(theAccount==null) {
				System.out.println("You do not have that kind of account, please try again.");
			}
			else {
				return theAccount.getId();
			}
		}
		else {
			System.out.println("Please select an existing option. Please try again.");
		}
		
		
		return -1;
	}
	
	/**
	 * Prompts the user for a login, and tests to validate if the user is an actual account holding member.
	 * If they are not, it sends you back to the viewOptions method.
	 * Tests for existing username, then asks for password, then tests the username with the password.
	 * If login is successful, the static variable loggedIn is updated to indicate which user is logged in.
	 * Only one user can be logged in at any given time.
	 */
	static void login() {
		System.out.print("Please enter your email: ");
		scan.nextLine().trim();
		String userName = scan.nextLine().trim();
		boolean doesExist = bankService.exists(userName);
		if(doesExist) {
			System.out.print("Please enter your password: ");
			String password = scan.nextLine().trim();
			boolean doLogin = bankService.correctLogin(userName, password);
			System.out.println("");
			if(doLogin) {
				int uid = bankService.getThatId(userName);
				loggedIn = uid;
				System.out.println("Logged in as: "+userName);
			}
			else {
				System.out.println("Incorrect Login/Password Given");
			}
		}
		else {
			System.out.println("That account does not exist, please create a new account!");
		}
	}
	
	
	
	static void addUser() {
		scan.nextLine();
		System.out.println("Press enter after you finish filling in each section.");
		System.out.println("Please enter your first name: ");
		String fn = scan.nextLine();
		System.out.println("Please enter your last name: ");
		String ln = scan.nextLine();
		System.out.println("Please enter your email address: ");
		String email = scan.nextLine();
		System.out.println("Please enter a password: ");
		String pass = scan.nextLine();
		bankService.addUser(fn, ln, email, pass);
		System.out.println("");
	}
	
	/**
	 * Call for creating a new account using the bank service.
	 */
	static void addAccount() {
		System.out.println("What kind of account would you like to open?");
		System.out.println("Enter 1 for checking, 2 for savings: ");
		int selection = scan.nextInt();
		if(selection==1||selection==2) {
			bankService.addAccount(loggedIn,selection);
			System.out.println("Your account has been created.");
		}
		else {
			System.out.println("Not a valid account type, please try again.");
		}
		System.out.println("");
	}
	
	/**
	 * Logs the user out by setting the loggedIn static variable to "".
	 */
	static void logout() {
		loggedIn = -1;
	}
	
	/**
	 * Call for withdrawing funds using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void changeFunds(int accId,double changeAmount) {
		if(loggedIn==-1) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.changeBalance(loggedIn, accId, changeAmount);;
		}
	}
	
	
	/**
	 * Call for viewing the balance using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void viewBalance() {
		if(loggedIn==-1) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.getBalance(loggedIn);
		}
	}
	
	/**
	 * Call for editing info using the bank service.
	 * Tests to ensure that a user is properly logged in before commencing with this action.
	 */
	static void editEmail(String newEmail) {
		if(loggedIn==-1) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.editEmail(loggedIn, newEmail);
		}
	}
	
	static void editFirstName(String fn) {
		if(loggedIn==-1) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.editFirstName(loggedIn, fn);
		}
	}
	
	static void editLastName(String ln) {
		if(loggedIn==-1) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.editLastName(loggedIn, ln);
		}
	}
	
	static void editPassword(String pass) {
		if(loggedIn==-1) {
			System.out.println("-----ACCESS DENIED-----");
		}
		else {
			bankService.editPassword(loggedIn, pass);
		}
	}
	
	
	
	
	
	
	
	
	
	
}

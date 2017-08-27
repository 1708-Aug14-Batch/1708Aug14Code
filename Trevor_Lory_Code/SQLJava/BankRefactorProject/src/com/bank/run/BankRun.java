package com.bank.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class BankRun {

	public static void main(String[] args) {
		Service ser = new Service();
		//ser.addUser("rrr", "rrr", "rrr", "rrr");
		run(ser);
	}
	
	public static void run(Service ser) {
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while(running) {
			System.out.println("Login / Create User / Exit (1/2/3): ");
			switch(scan.nextLine()) {
			case "1":
				boolean running2 = true;
				User u = null;
				while(running2) {
					System.out.println("Email: ");
					String em = scan.nextLine();
					System.out.println("Password: ");
					String ps = scan.nextLine();
					u = ser.getUser(em, ps);
					if(u != null) {
						break;
					}
					System.out.println("Wrong email or password, Try again or exit? (1/2):");
					switch(scan.nextLine()) {
					case "1":
						//do nothing just let things happen again
						break;
					case "2":
						running2 = false;
						break;
					default:
						System.out.println("Invalid input, going back to menu.");
						running2 = false;
						break;
					}
				}
				if(running2 != false) {
					RunUser(u, ser, scan);
				}
				break;
			case "2":
				boolean running3 = true;
				User u1 = null;
				while(running3) {
					System.out.println("FirstName: ");
					String fn = scan.nextLine();
					System.out.println("LastName: ");
					String ln = scan.nextLine();
					System.out.println("Email: ");
					String em = scan.nextLine();
					System.out.println("Password: ");
					String ps = scan.nextLine();
					u1 = ser.addUser(fn, ln, em, ps);
					if(u1.getId() != -1) {
						running3 = false;
						RunUser(u1, ser, scan);
						break;
					}
					System.out.println("Already Used Email, Please try again or exit: (1/2)");
					switch(scan.nextLine()) {
					case "1":
						//dp nothing to continue onwards
						break;
					case "2":
						running3 = false;
						break;
					default:
						System.out.println("Invalid input, returning to menu.");
						running3 = false;
						break;
					}
				}
				break;
			case "3":
				running = false;
				break;
			default:
				System.out.println("Invalid Input please try again.");
				break;
			}
		}
		scan.close();
	}
	
	public static void RunUser(User u, Service ser, Scanner scan) {
		boolean running = true;
		ArrayList<Account> list = ser.getAccounts(u);
		while(running) {
			System.out.println(u.toString());
			System.out.println("Withdraw / Deposit / Transfer funds / Change Stuff / Manage Accounts / Log Out (1/2/3/4/5/6)");
			switch(scan.nextLine()) {
			case "1":
				withdraw(u, list, ser, scan);
				break;
			case "2":
				deposit(u, list, ser, scan);
				break;
			case "3":
				transfer(u, list, ser, scan);
				break;
			case "4":
				changeStuff(u, ser, scan);
				break;
			case "5":
				manageAccounts(u, list, ser, scan);
				list = ser.getAccounts(u);
				break;
			case "6":
				running = false;
				break;
			default:
				System.out.println("Invalid Input, please try again.");
				break;
			}
		}
	}
	
	public static void withdraw(User u, ArrayList<Account> list, Service ser, Scanner scan) {
		if(list.isEmpty()) {
			System.out.println("You have no accounts to withdraw from, please try again.");
			return;
		}
		System.out.println("Which Account do you want to withdraw from (enter account number)");
		int num = -1;
		while(true) {
			try {
				num = scan.nextInt();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Account Number, please try again.");
			}
			if(num < 0 || num > list.size() - 1) {
				System.out.println("Invalid Account Number, please try again.");
			}
		}
		System.out.println("How much do you want to withdraw: ");
		double d = 0;
		while(true) {
			try {
				d = scan.nextDouble();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Number, please try again.");
			};
		}
		list.get(num).setBalance(list.get(num).getBalance() - d);
		ser.updateAccount(list.get(num));
		System.out.println("Balance updated in Account: " + list.get(num).getName());
	}
	
	public static void deposit(User u, ArrayList<Account> list, Service ser, Scanner scan) {
		if(list.isEmpty()) {
			System.out.println("You have no accounts to Deposit from, please try again.");
			return;
		}
		System.out.println("Which Account do you want to Deposit from (enter account number)");
		int num = -1;
		while(true) {
			try {
				num = scan.nextInt();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Account Number, please try again.");
			}
			if(num < 0 || num > list.size() - 1) {
				System.out.println("Invalid Account Number, please try again.");
			}
		}
		System.out.println("How much do you want to Deposit: ");
		double d = 0;
		while(true) {
			try {
				d = scan.nextDouble();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Number, please try again.");
			};
		}
		list.get(num).setBalance(list.get(num).getBalance() + d);
		ser.updateAccount(list.get(num));
		System.out.println("Balance updated in Account: " + list.get(num).getName());
	}
	
	public static void transfer(User u, ArrayList<Account> list, Service ser, Scanner scan) {
		if(list.isEmpty() || list.size() == 1) {
			System.out.println("You have not enough accounts to transfer balance, please try again.");
			return;
		}
		System.out.println("Which Account do you want to Transfer from (enter account number)");
		int num = -1;
		while(true) {
			try {
				num = scan.nextInt();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Account Number, please try again.");
			}
			if(num < 0 || num > list.size() - 1) {
				System.out.println("Invalid Account Number, please try again.");
			}
		}
		
		System.out.println("Which Account do you want to Transfer to (enter account number)");
		int num1 = -1;
		while(true) {
			try {
				num1 = scan.nextInt();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Account Number, please try again.");
			}
			if(num1 < 0 || num1 > list.size() - 1) {
				System.out.println("Invalid Account Number, please try again.");
			}
		}
		
		System.out.println("How much do you want to Transfer: ");
		double d = 0;
		while(true) {
			try {
				d = scan.nextDouble();
				break;
			}
			catch(Exception e) { 
				System.out.println("Invalid Number, please try again.");
			};
		}
		
		list.get(num).setBalance(list.get(num).getBalance() - d);
		list.get(num1).setBalance(list.get(num1).getBalance() + d);
		ser.updateAccount(list.get(num));
		ser.updateAccount(list.get(num1));
		System.out.println("Transfered $" + d + " from " + list.get(num).getName() + " to " + list.get(num1).getName());
	}
	
	public static void changeStuff(User u, Service ser, Scanner scan) {
		boolean running = true;
		while(running) {
			System.out.println("Change firstname / lastname / password / exit (1/2/3/4)");
			switch(scan.nextLine()) {
			case "1":
				System.out.println("New First Name: ");
				u.setFirstname(scan.nextLine());
				ser.updateUser(u);
				break;
			case "2":
				System.out.println("New Last Name: ");
				u.setLastname(scan.nextLine());
				ser.updateUser(u);
				break;
			case "3":
				System.out.println("New Password Name: ");
				u.setPassword(scan.nextLine());
				ser.updateUser(u);
				break;
			case "4":
				running = false;
				break;
			default:
				System.out.println("Invalid Input, please try again.");
				break;
			}
		}
	}
	
	public static void manageAccounts(User u, ArrayList<Account> list, Service ser, Scanner scan) {
		System.out.println("You have " + list.size() + " Accounts.");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i).toString());
		}
		boolean running = true;
		while(running) {
			System.out.println("Create Account / Close Account / exit (1/2/3)");
			switch(scan.nextLine()) {
			case "1":
				System.out.println("What name for the account: ");
				String name = scan.nextLine();
				System.out.println("What type of account: Checking / Savings / Credit (1/2/3): ");
				switch(scan.nextLine()) {
				case "1":
					ser.createAccount(u, 0, name);
					break;
				case "2":
					ser.createAccount(u, 1, name);
					break;
				case "3":
					ser.createAccount(u, 2, name);
					break;
				default:
					System.out.println("Invalid Input, back to menu.");
					break;
				}
				break;
			case "2":
				System.out.println("Which account do you want to close: ");
				int num = -1;
				try {
					num = scan.nextInt();
				}
				catch(Exception e) { 
					System.out.println("Invalid Account Number.");
					break;
				};
				if(num < 0 || num > list.size() - 1) {
					System.out.println("Invalid Account Number."); 
					break;
				}
				ser.closeAccount(list.get(num));
				System.out.println("Account closed.");
				break;
			case "3":
				running = false;
				break;
			default:
				System.out.println("Invalid Input, Please try again.");
				break;
			}
		}
	}
}

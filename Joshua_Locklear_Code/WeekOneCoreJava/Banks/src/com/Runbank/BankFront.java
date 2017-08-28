package com.Runbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import com.pojos.Account;
import com.pojos.User;
import com.service.Service;

public class BankFront {

	static Service bankService;
	static User currentUser;
	static ArrayList<Account> currentAccounts;
	static Scanner userInput;

	public static void main(String[] args) {
		bankService = new Service();

		userInput = new Scanner(System.in);
		System.out.println("Welcome to the bank:");
		home();

	}

	static void home() {
		System.out.println("1 - login");
		System.out.println("2 - register");
		System.out.println("3 - quit");

		String input = userInput.nextLine();
		switch (input) {
		case "1": {
			login();
		}
			break;
		case "2": {
			register();
		}
			break;
		case "3": {
			home();
		}
			break;
		}
	}

	static void register() {
		System.out.println("Enter first name");
		String fn = userInput.nextLine();
		System.out.println("Enter last name: ");
		String ln = userInput.nextLine();
		System.out.println("Enter username: ");
		String username = userInput.nextLine().toLowerCase();
		System.out.println("Enter password: ");
		String password = userInput.nextLine();
		User user = new User(fn, ln, username, password);
		currentUser = bankService.addUser(user);
		currentAccounts = new ArrayList<Account>();
		while (currentUser.getId() == -1) {
			System.out.println("Username in use, enter a different username:");
			username = userInput.nextLine();
			currentUser.setEmail(username);
			currentUser = bankService.addUser(user);
		}
		userMenu();
	}

	static void login() {
		System.out.println("Enter username");
		String username = userInput.nextLine().toLowerCase();

		System.out.println("Enter password:");
		String password = userInput.nextLine();
		currentUser = bankService.getUser(username, password);
		if (!currentUser.equals(new User())) {
			System.out.println("Welcome " + currentUser.getFirstname());
			currentAccounts = bankService.getAccounts(currentUser.getId());
			userMenu();
		} else {
			System.out.println("Incorrect username or password");
			login();
		}
	}

	static void userMenu() {
		System.out.println("Home Page");
		System.out.println("Choose an option:");
		System.out.println("1 - view accounts");
		System.out.println("2 - update your user information");
		System.out.println("3 - logout");

		String input = userInput.nextLine();
		switch (input) {
		case "1": {
			viewBalance();
		}
			break;
		case "2": {
			updateInfo();
		}
			break;
		case "3": {
			logout();
		}
			break;
		default: {
			userMenu();
		}
			break;
		}
	}

	static void logout() {
		currentUser = null;
		currentAccounts.clear();
		System.out.println("Logged out");
		home();
	}

	static void viewBalance() {
		if (currentAccounts.isEmpty()) {
			System.out.println("No Available Accounts");
			System.out.println("1 - open a new account");
			System.out.println("2 - home page");
			String input = userInput.nextLine();
			switch (input) {
			case "1": {
				newAccount();
			}
				break;
			case "2": {
				userMenu();
			}
				break;
			default: {
				viewBalance();
			}
				break;
			}
		} else {
			for (Account a : currentAccounts) {
				switch (a.getTypeID()) {
				case 1:
					System.out.println("Checking:" + a.getBalance());
					break;
				case 2:
					System.out.println("Savings:" + a.getBalance());
					break;
				case 3:
					System.out.println("Credit:" + a.getBalance());
					break;
				}
			}

			System.out.println("1 - make a deposit");
			System.out.println("2 - make a withdrawal");
			System.out.println("3 - make a transfer");
			System.out.println("4 - open a new account");
			System.out.println("5 - close an account");
			System.out.println("6 - User Menu");
			String input = userInput.nextLine();
			switch (input) {
			case "1": {
				deposit();
			}
				break;
			case "2": {
				withdraw();
			}
				break;
			case "3": {
				transfer();
			}
				break;
			case "4": {
				newAccount();
			}
				break;
			case "5": {
				removeAccount();
			}
				break;
			case "6": {
				userMenu();
			}
				break;
			default: {
				viewBalance();
			}
				break;
			}
		}

	}

	static void newAccount() {

		int[] typeIdArray = { 1, 2, 3 };
		for (Account a : currentAccounts) {
			switch (a.getTypeID()) {
			case 1:
				typeIdArray[0] = -1;
				break;
			case 2:
				typeIdArray[1] = -1;
				break;
			case 3:
				typeIdArray[2] = -1;
				break;
			}
		}
		for (int i : typeIdArray) {
			if (i != -1) {
				switch (i) {
				case 1:
					System.out.println("1 - Open checking account");
					break;
				case 2:
					System.out.println("2 - Open savings account");
					break;
				case 3:
					System.out.println("3 - Open a credit account");
					break;
				}
			}
		}
		System.out.println("4 - view accounts");
		System.out.println("5 - User Menu");

		String input = userInput.nextLine();
		Account newAccount;

		switch (input) {
		case "1": {
			newAccount = new Account(new BigDecimal(0), currentUser.getId(), 1);
			newAccount.setAccountID(bankService.addAccount(newAccount));
			currentAccounts.add(newAccount);
			System.out.println("You opened a new checkings account!");
			viewBalance();
		}
			break;
		case "2": {
			newAccount = new Account(new BigDecimal(0), currentUser.getId(), 2);
			newAccount.setAccountID(bankService.addAccount(newAccount));
			currentAccounts.add(newAccount);
			System.out.println("You opened a new savings account!");
			viewBalance();
		}
			break;
		case "3": {
			newAccount = new Account(new BigDecimal(0), currentUser.getId(), 3);
			newAccount.setAccountID(bankService.addAccount(newAccount));
			currentAccounts.add(newAccount);
			System.out.println("You opened a new credit account!");
			viewBalance();
		}
			break;
		case "4": {
			viewBalance();
		}
			break;
		case "5": {
			userMenu();
		}
			break;
		default: {
			System.out.println("Invalid input please would you like to continue ?");
			String userConn = userInput.nextLine();
			if(userConn=="y"){
				newAccount();
			}else{userMenu();}
			
		}
			break;
		}
	}

	static void deposit() {

		int[] typeIdArray = { -1, -1, -1 };

		for (Account a : currentAccounts) {
			switch (a.getTypeID()) {
			case 1:
				typeIdArray[0] = 1;
				break;
			case 2:
				typeIdArray[1] = 2;
				break;
			case 3:
				typeIdArray[2] = 3;
				break;
			}
		}

		for (int i : typeIdArray) {
			if (i != -1) {
				switch (i) {
				case 1:
					System.out.println("1 - Deposit to checking");
					break;
				case 2:
					System.out.println("2 - Deposit to savings");
					break;
				case 3:
					System.out.println("3 - Deposit to credit");
					break;
				}
			}
		}
		System.out.println("4 - view accounts");
		System.out.println("5 - User Menu");

		String input = userInput.nextLine();
		switch (input) {
		case "1": {
			System.out.println("Enter amount: ");
			BigDecimal deposit = userInput.nextBigDecimal();
			while (deposit.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				deposit = userInput.nextBigDecimal();
			}
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 1) {
					currentAccounts.set(i, bankService.deposit(currentAccounts.get(i), deposit));
					break;
				}
			}
		}
			break;
		case "2": {
			System.out.println("Enter amount: ");
			BigDecimal deposit = userInput.nextBigDecimal();
			while (deposit.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				deposit = userInput.nextBigDecimal();
			}
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 2) {
					currentAccounts.set(i, bankService.deposit(currentAccounts.get(i), deposit));
					break;
				}
			}
		}
			break;
		case "3": {
			System.out.println("Enter amount: ");
			BigDecimal deposit = userInput.nextBigDecimal();
			while (deposit.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				deposit = userInput.nextBigDecimal();
			}
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 3) {
					currentAccounts.set(i, bankService.deposit(currentAccounts.get(i), deposit));
					break;
				}
			}
		}
			break;
		case "4": {
			userMenu();
		}
			break;
		case "5": {
			viewBalance();
		}
			break;
		}
		viewBalance();
	}

	static void withdraw() {

		// get available accounts using this array, non-negative if available
		int[] typeIdArray = { -1, -1, -1 };
		for (Account a : currentAccounts) {
			switch (a.getTypeID()) {
			case 1:
				typeIdArray[0] = 1;
				break;
			case 2:
				typeIdArray[1] = 2;
				break;
			case 3:
				typeIdArray[2] = 3;
				break;
			}
		}

		for (int i : typeIdArray) {
			if (i != -1) {
				switch (i) {
				case 1:
					System.out.println("1 - Withdraw from checking");
					break;
				case 2:
					System.out.println("2 - Withdraw from savings");
					break;
				case 3:
					System.out.println("3 - Withdraw from credit");
					break;
				}
			}
		}
		System.out.println("4 - view accounts");
		System.out.println("5 - User Menu");

		String input = userInput.nextLine();
		switch (input) {
		case "1": {
			System.out.println("Enter amount: ");
			BigDecimal withdraw = userInput.nextBigDecimal();
			while (withdraw.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				withdraw = userInput.nextBigDecimal();
			}
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 1) {
					currentAccounts.set(i, bankService.withdraw(currentAccounts.get(i), withdraw));
					break;
				}
			}
		}
			break;
		case "2": {
			System.out.println("Enter amount: ");
			BigDecimal withdraw = userInput.nextBigDecimal();
			while (withdraw.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				withdraw = userInput.nextBigDecimal();
			}
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 2) {

					currentAccounts.set(i, bankService.withdraw(currentAccounts.get(i), withdraw));
					break;
				}
			}
		}
			break;
		case "3": {
			System.out.println("Enter amount: ");
			BigDecimal withdraw = userInput.nextBigDecimal();
			while (withdraw.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				withdraw = userInput.nextBigDecimal();
			}
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 3) {

					currentAccounts.set(i, bankService.withdraw(currentAccounts.get(i), withdraw));
					break;
				}
			}
		}
			break;
		case "4": {
			viewBalance();
		}
			break;
		case "5": {
			userMenu();
		}
			break;
		case "6": {
			userMenu();
		}
			break;
		default: {
			withdraw();
		}
			break;
		}
		withdraw();
	}
	static void transfer() {
		if (currentAccounts.size() <= 1) {
			System.out.println("You need more than 1 account to transfer.");
			newAccount();
			return;
		}
		System.out.println("Choose an account to transfer from: ");
		int[] typeIdArray = { -1, -1, -1 };
		for (Account a : currentAccounts) {
			switch (a.getTypeID()) {
			case 1:
				typeIdArray[0] = 1;
				break;
			case 2:
				typeIdArray[1] = 2;
				break;
			case 3:
				typeIdArray[2] = 3;
				break;
			}
		}

		for (int i : typeIdArray) {
			if (i != -1) {
				switch (i) {
				case 1:
					System.out.println("1 - Checking");
					break;
				case 2:
					System.out.println("2 - Savings");
					break;
				case 3:
					System.out.println("3 - Credit");
					break;
				}
			}
		}
		System.out.println("4 - view accounts");
		String input = userInput.nextLine();
		String transferTo;
		BigDecimal amount;
		System.out.println("Transfer to:");
		if (input.equals("1")) {
			do {
				for (int i : typeIdArray) {
					if (i != -1) {
						switch (i) {
						case 2:
							System.out.println("2 - Savings");
							break;
						case 3:
							System.out.println("3 - Credit");
							break;
						}
					}
				}
				transferTo = userInput.nextLine();
			} while (!transferTo.equals("2") && !transferTo.equals("3"));
			System.out.println("Enter amount: ");
			amount = userInput.nextBigDecimal();
			while (amount.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				amount = userInput.nextBigDecimal();
			}
			if (transferTo.equals("4")) {
				for (Account a : currentAccounts) {
					if (a.getTypeID() == 1) {
						for (Account b : currentAccounts) {
							if (b.getTypeID() == 2) {
								bankService.withdraw(a, amount);
								bankService.deposit(b, amount);
								viewBalance();
								return;
							}
						}
					}
				}
			}
			else {
				for (Account a : currentAccounts) {
					if (a.getTypeID() == 1) {
						for (Account b : currentAccounts) {
							if (b.getTypeID() == 3) {
								bankService.withdraw(a, amount);
								bankService.deposit(b, amount);
								viewBalance();
								return;
							}
						}
					}
				}
			}
		} else if (input.equals("2")) {
			do {
				for (int i : typeIdArray) {
					if (i != -1) {
						switch (i) {
						case 1:
							System.out.println("1 - Checkings");
							break;
						case 3:
							System.out.println("3 - Credit");
							break;
						}
					}
				}
				transferTo = userInput.nextLine();
			} while (!transferTo.equals("1") && !transferTo.equals("3"));

			System.out.println("Enter amount: ");
			amount = userInput.nextBigDecimal();
			while (amount.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				amount = userInput.nextBigDecimal();
			}
			if (transferTo.equals("1")) {
				for (Account a : currentAccounts) {
					if (a.getTypeID() == 2) {
						for (Account b : currentAccounts) {
							if (b.getTypeID() == 1) {
								bankService.withdraw(a, amount);
								bankService.deposit(b, amount);
								viewBalance();
								return;
							}
						}
					}
				}
			} else {
				for (Account a : currentAccounts) {
					if (a.getTypeID() == 2) {
						for (Account b : currentAccounts) {
							if (b.getTypeID() == 3) {
								bankService.withdraw(a, amount);
								bankService.deposit(b, amount);
								viewBalance();
								return;
							}
						}
					}
				}
			}
		} else if (input.equals("3")) {
			do {
				for (int i : typeIdArray) {
					if (i != -1) {
						switch (i) {
						case 1:
							System.out.println("1 - Checking");
							break;
						case 2:
							System.out.println("2 - Savings");
							break;
						}
					}
				}
				transferTo = userInput.nextLine();
			} while (!transferTo.equals("1") && !transferTo.equals("2"));

			System.out.println("Enter amount: ");
			amount = userInput.nextBigDecimal();
			// transfer only if value is greater than 0
			while (amount.doubleValue() <= 0.0d) {
				System.out.println("Enter positive value: ");
				amount = userInput.nextBigDecimal();
			}
			// credit to checkings
			if (transferTo.equals("1")) {
				for (Account a : currentAccounts) {
					if (a.getTypeID() == 3) {
						for (Account b : currentAccounts) {
							if (b.getTypeID() == 1) {
								bankService.withdraw(a, amount);
								bankService.deposit(b, amount);
								viewBalance();
								return;
							}
						}
					}
				}
			}
			else {
				for (Account a : currentAccounts) {
					if (a.getTypeID() == 3) {
						for (Account b : currentAccounts) {
							if (b.getTypeID() == 2) {
								bankService.withdraw(a, amount);
								bankService.deposit(b, amount);
								viewBalance();
								return;
							}
						}
					}
				}
			}
		} else if (input.equals("4")) {
			viewBalance();
		} else {
			transfer();
		}
		viewBalance();
	}
	static void updateInfo() {
		System.out.println("Choose option to change:");
		System.out.println("1 - First name (" + currentUser.getFirstname() + ")");
		System.out.println("2 - Last name (" + currentUser.getLastname() + ")");
		System.out.println("3 - Password");
		System.out.println("4 - User Menu");
		System.out.println("5 - Delete user and accounts");
		String input = userInput.nextLine();
		if (input.equals("d")) {
			userMenu();
			return;
		}
		System.out.println("Enter change: ");
		String change = userInput.nextLine();

		if (input.equals("1")) {
			currentUser.setFirstname(change);
			bankService.updateUser(currentUser);
			System.out.println("Changed your first name");
		} else if (input.equals("2")) {
			currentUser.setLastname(change);
			bankService.updateUser(currentUser);
			System.out.println("Changed your last name");
		} else if (input.equals("3")) {
			currentUser.setPassword(change);
			bankService.updateUser(currentUser);
		} else if (input.equals("4")) {
			System.out.println("Are you sure? (y/n)");
			input = userInput.nextLine();
			if (input.equals("y")) {
				removeUser();
				return;
			}
		} else {
			System.out.println("Try Again");
		}

		updateInfo();

	}
	static void removeAccount() {
		int[] typeIdArray = { -1, -1, -1 };
		for (Account a : currentAccounts) {
			switch (a.getTypeID()) {
			case 1:
				typeIdArray[0] = 1;
				break;
			case 2:
				typeIdArray[1] = 2;
				break;
			case 3:
				typeIdArray[2] = 3;
				break;
			}
		}
		for (int i : typeIdArray) {
			if (i != -1) {
				switch (i) {
				case 1:
					System.out.println("1 - Close checking");
					break;
				case 2:
					System.out.println("2 - Close savings");
					break;
				case 3:
					System.out.println("3 - Close credit");
					break;
				}
			}
		}
		System.out.println("4 - view accounts");
		System.out.println("5 - User Menu");

		String input = userInput.nextLine();

		if (input.equals("1")) {
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 1) {
					bankService.removeAccount(currentAccounts.get(i));
					currentAccounts.remove(i);
					System.out.println("Successfully removed checking");
					break;
				}
			}
		} else if (input.equals("2")) {
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 2) {
					bankService.removeAccount(currentAccounts.get(i));
					currentAccounts.remove(i);
					System.out.println("Successfully removed savings");
					break;
				}
			}
		} else if (input.equals("3")) {
			for (int i = 0; i < currentAccounts.size(); i++) {
				if (currentAccounts.get(i).getTypeID() == 3) {
					bankService.removeAccount(currentAccounts.get(i));
					currentAccounts.remove(i);
					System.out.println("Successfully removed credit");
					break;
				}
			}
		} else if (input.equals("4")) {
			viewBalance();
		} else if (input.equals("5")) {
			userMenu();
		}
		viewBalance();
	}
	static void removeUser() {
		for (Account a : currentAccounts) {
			bankService.removeAccount(a);
		}
		bankService.removeUser(currentUser);
		System.out.println("Successfully removed accounts and user");
		home();
	}

}


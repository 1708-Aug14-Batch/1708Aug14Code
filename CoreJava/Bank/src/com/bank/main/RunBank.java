package com.bank.main;

import java.util.Scanner;

import com.bank.service.Service;

public class RunBank {
	/*
	 * Requirements: As a user I can, - login - create an account - logout -
	 * withdraw or deposit funds - view my* account balance - edit my* information
	 * 
	 * Tech-Specs - core java, file i/o
	 */

	public static boolean login;

	// implementation to actually run bank application
	public static void main(String[] args) {
		Service bankService = new Service();

		bankService.login();
		while (login) {
			presentMenu();
			Scanner scan = new Scanner(System.in);
			String mItem = scan.nextLine().trim();
			switch (mItem) {
			case "1":
				bankService.viewBalance();
				break;
			case "2":
				bankService.depositFunds();
				break;
			case "3":
				bankService.withdrawFunds();
				break;
			case "4":
				bankService.editAcctInfo();
				break;
			case "5":
				bankService.logout();
				break;
			}
		}

	}

	public static void presentMenu() {
		System.out.println();
		System.out.println("*-------------- Menu --------------*");
		System.out.println("* (1) Check Balance                *");
		System.out.println("* (2) Deposit Funds                *");
		System.out.println("* (3) Withdraw Funds               *");
		System.out.println("* (4) Edit Information             *");
		System.out.println("* (5) Logout                       *");
		System.out.println("*----------------------------------*");
		System.out.println("Choose from menu item above");
	}

}
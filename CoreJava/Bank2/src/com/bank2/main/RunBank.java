package com.bank2.main;

import java.util.Scanner;

import com.bank2.service.Service;

public class RunBank {
	public static boolean login;

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
				bankService.deleteAcct();
				break;
			case "6":
				bankService.createSavings();
				break;
			case "7":
				bankService.createChecking();
				break;
			case "8":
				bankService.createCredit();
				break;
			case "9":
				bankService.transferFunds();
				break;
			case "10":
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
		System.out.println("* (5) Close Account                *");
		System.out.println("* (6) Create Savings Account       *");
		System.out.println("* (7) Create Checking Account      *");
		System.out.println("* (8) Create Credit Account        *");
		System.out.println("* (9) Transfer Funds               *");
		System.out.println("* (10) Logout                      *");
		System.out.println("*----------------------------------*");
		System.out.println("Choose from menu item above");
	}

}

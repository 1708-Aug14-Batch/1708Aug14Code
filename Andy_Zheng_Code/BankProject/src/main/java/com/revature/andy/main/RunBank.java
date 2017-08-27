package com.revature.andy.main;

import java.util.Scanner;

import org.apache.log4j.*;

import com.revature.andy.service.Service;
import com.revature.andy.session.PseudoSession;

public class RunBank {


	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		
		start();
		
	}
	
	static void start() {
		// Scanner and Service
		Scanner scan = new Scanner(System.in);
		Service ser = new Service();
		
		// Main Menu
		while(true) {
			System.out.println("\n------------------------------------");
			System.out.println("Please Select From the Following\n"
					+ "Main Menu:\n"
					+ "1: Create Account \n"
					+ "2: Login\n"
					+ "3: Exit");
			System.out.println("------------------------------------");
			
			int input = scan.nextInt();
			
			// Create User Account
			
			if(input == 1) {
				
				// Enter User Information
				System.out.println("Create Account");
				System.out.println("Enter First Name");
				
				// Why is it auto skipping a line?
				scan.nextLine();
				
				String fName = scan.nextLine().trim();
				
				System.out.println("Enter Last Name");
				String lName = scan.nextLine().trim();
				
				System.out.println("Enter Email");
				String email = scan.nextLine().trim();
				
				System.out.println("Enter Password");
				String pwd =  scan.nextLine().trim();
				
				// Create User
				if(ser.createUser(fName, lName, email, pwd)) {
					System.out.println("User Account Created");
				}else {
					System.out.println("Failed To Create User Account");
				}
			}
			// Log in
			else if(input == 2) {

				// Enter Email and Password
				System.out.println("Logging In");
				System.out.println("Enter Email");

				// Why is it auto skipping a line?
				scan.nextLine();
				
				String email = scan.nextLine().trim();
				
				System.out.println("Enter Password");
				String pwd =  scan.nextLine().trim();
				
				// Logging to Session
				
				//System.out.println(PseudoSession.login(email, pwd));
				if(PseudoSession.login(email, pwd)) {
				
					// Login Menu
					while(PseudoSession.getIsLoggedIn()) {
						System.out.println("\n------------------------------------");
						System.out.println("Please Select From the Following\n"
								+ "Options:\n"
								+ "1: Bank Account(s)\n"
								+ "2: User Information\n"
								+ "3: Logout");
						System.out.println("------------------------------------");

						int input2 = scan.nextInt();
					
						// View Account Info
						if (input2 == 1) {
							while(true) {							
								System.out.println("\n------------------------------------");
								System.out.println("Please Select From the Following\n"
										+ "Bank Account(s):\n"
										+ "1: Create Account\n"
										+ "2: View Accounts\n"
										+ "3: Withdraw\n"
										+ "4: Deposit\n"
										+ "5: Transfer Funds\n"
										+ "6: Close Account\n"
										+ "7: Return");
								System.out.println("------------------------------------");
								
								int bankinput = scan.nextInt();
								
								// Create Bank Account
								if(bankinput == 1) {
									System.out.println("\n------------------------------------");
									System.out.println("Please Select From the Following\n"
											+ "Create A Bank Account\n"
											+ "1: Checking\n"
											+ "2: Savings\n"
											+ "3: Credit\n"
											+ "4: Return");
									System.out.println("------------------------------------");
									
									int input4 = scan.nextInt();
									
									// Create Bank Account
									if(input4 == 1 || input4 == 2 || input4 == 3) {
										if(ser.createAccount(input4)) {
											System.out.println("Bank Account Created");
										}else {
											System.out.println("Failed To Create Bank Account");	
										}
									}
									// Return
									else if (input4 == 4) {
										System.out.println("Return");
									}else {
										continue;
									}
								}
								// View all accounts
								else if(bankinput == 2) {
									ser.getAccounts();
								}
								// Withdraw
								else if(bankinput == 3) {
									System.out.println("Withdraw");
									System.out.println("Enter AccountID");
									
									int accountID = scan.nextInt();
									
									System.out.println("Enter Amount");
									
									double amt = scan.nextDouble();
									
									if(ser.changeBalance(accountID, amt, true)) {
										System.out.println("Withdraw Success");
									}else {
										System.out.println("Failed To Withdraw");
									}
									
								}
								// Deposit
								else if(bankinput == 4) {
									System.out.println("Deposit");
									System.out.println("Enter AccountID");
									
									int accountID = scan.nextInt();
									
									System.out.println("Enter Amount");
									
									double amt = scan.nextDouble();
	
									if(ser.changeBalance(accountID, amt, false)) {
										System.out.println("Deposit Success");
									}else {
										System.out.println("Failed To Deposit");
									}
									
								}
								// Transfer funds
								else if(bankinput == 5) {
									System.out.println("Enter AccountID To Recieve Transfer");
									int accountID1 = scan.nextInt();
									System.out.println("Enter AccountID To Transfer From");
									int accountID2 = scan.nextInt();
									System.out.println("Enter Amount");
									double amt = scan.nextDouble();
									
									if(ser.transferFunds(accountID1, accountID2, amt)){
										System.out.println("Transfer Success");
									}else {
										System.out.println("Failed to Transfer");
									}
								}
								// Close account
								else if(bankinput == 6) {
									System.out.println("Enter AccountID To Delete");
									if(ser.deleteAccount(scan.nextInt())){
										System.out.println("Account Closed");
									}else {
										System.out.println("Failed to Close Account");
									}
								}
								// Return
								else if(bankinput == 7) {
									System.out.println("Return");
									break;
								}else {
									continue;
								}	
							}
							
						}
						// Change User Account Information
						else if (input2 == 2) {
							while(true) {
								System.out.println("\n------------------------------------");
								System.out.println("Please Select From the Following\n"
										+ "User Information:\n"
										+ "1: View Information\n"
										+ "2: Change First Name\n"
										+ "3: Change Last Name\n"
										+ "4: Change Email\n"
										+ "5: Change Password\n"
										+ "6: Return");
								System.out.println("------------------------------------");
								
								int userInfoInput = scan.nextInt();
								
								if(userInfoInput == 1) {
									ser.getUser();
								}
								// Change First name
								else if(userInfoInput == 2) {
									// Why is it auto skipping a line?
									scan.nextLine();
									System.out.println("Enter First Name");
									String change = scan.nextLine().trim();
									ser.changeInformation(userInfoInput, change);
								}
								// Change Last name
								else if(userInfoInput == 3) {
									// Why is it auto skipping a line?
									scan.nextLine();
									System.out.println("Enter Last Name");
									String change = scan.nextLine().trim();
									ser.changeInformation(userInfoInput, change);
								}
								// Change Email
								else if(userInfoInput == 4) {
									// Why is it auto skipping a line?
									scan.nextLine();
									System.out.println("Enter Email");
									String change = scan.nextLine().trim();
									ser.changeInformation(userInfoInput, change);
								}
								// Change Password
								else if(userInfoInput == 5) {
									// Why is it auto skipping a line?
									scan.nextLine();
									System.out.println("Enter Password");
									String change = scan.nextLine().trim();
									ser.changeInformation(userInfoInput, change);
								}
								// Return
								else if(userInfoInput == 6) {
									System.out.println("Return");
									break;
								}else {
									continue;
								}
							}
						}
						// Logout
						else if (input2 == 3) {
							PseudoSession.logout();
							System.out.println("Logged Out");
						}
						else {
							continue;
						}
					}					
				}
				// Fail to Log In
				else {
					System.out.println("Invalid Email or Password");
				}
			}else if(input == 3) {
				scan.close();
				System.out.println("Exiting");
				System.exit(0);
			}
			else {
				scan.close();
				System.exit(0);
			}
		}
	}
}

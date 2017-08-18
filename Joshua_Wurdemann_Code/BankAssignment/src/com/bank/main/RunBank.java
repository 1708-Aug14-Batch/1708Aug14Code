package com.bank.main;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import com.bank.service.Service;
import com.bankassignment.pojos.User;



public class RunBank {


	public static void main(String[] args) {
		Service bankService = new Service();
		Scanner scan = new Scanner(System.in);

		boolean loggedIn = false;
		int something;


		while(true)
		{
			while (!loggedIn)
			{	
				System.out.println("\nWelcome to Revature Banking.");

				System.out.println("Enter (1) Login \n"
						+ "(2) Create Acccount.");
				String choice = scan.nextLine();

				switch (choice){
				case "1":
					System.out.println("Please Enter your username/email.");

					String username = scan.nextLine();

					System.out.println("Enter your password.");

					String password = "" + scan.nextLine();

					something = bankService.login(username, password);

					if (something == 2)
					{
						loggedIn = true;
						System.out.println(username + " has logged in.");
					}
					else if(something == 3) {
						System.out.println("ERROR: Invalid input.");
					}
					else if(something == 4)
					{
						System.out.println("Invalid userId Please try again.");
					}
					else {}
					break;
				case "2":


					System.out.println("enter your first name");
					String fn = scan.nextLine().trim();

					System.out.println("enter your Last name");
					String ln = scan.nextLine().trim();

					System.out.println("enter your email");
					String email = scan.nextLine().trim();
					/** Check to see if account already is registered
					 * using an equals method on email to verify if there exists another email*/
					/** Existing file to see if email exists
					 * then continue with program if not 
					 * prompt user with sysout that user all ready exists in a while loop until a new unique valid email is entered.
					 */
					System.out.println("enter your new password");
					String pw = scan.nextLine().trim();
					
					 
					
					

					System.out.println("Enter the amount to be added to account");
					double balance = scan.nextDouble(); //if i have time I will change this to big decimal
					
					String id = "20";
					
					User newUser = new User(fn, ln, email, pw, id, balance);
					bankService.registerUser(newUser);
					
					/** Assign an a unque account id to user starting with 1*/

					}

				while (bankService.isOpen())
				{
					System.out.println("\nWhat would you like to do?");
					System.out.println(   "1:View Balance \n"
							+ "2:Withdraw \n"
							+ "3:Deposit \n"
							+ "4:View History \n"
							+ "5:EditAccount \n"
							+ "6:Logout");
					System.out.print("> ");
					String cho = scan.nextLine();

					something = 0;
					switch (choice){
					case "1":
						System.out.println("Your balance is: $" + new Formatter().format("%,.2f", Double.parseDouble(bankService.getBalance())));
						break;
					case "2":
						System.out.println("Enter the amount to withdraw.");
						try
						{
							something = bankService.withdraw(scan.nextLine());
						}
						catch(Exception e) {
							e.printStackTrace(); 
							something = 5;
						}
						if (something == 2)
						{
							System.out.println("Withdrawal successful.");
							System.out.println("Your balance is: $" + new Formatter().format("%,.2f", Double.parseDouble(bankService.getBalance())));
						}
						else if(something == 5) {
							System.out.println("ERROR: Insufficient funds.");
						}
						else {

						}
						break;
					case "3":
						System.out.println("Enter the amount to deposit.");
						something = bankService.deposit(scan.nextLine());
						if (something == 2)
						{
							System.out.println("Deposit successful.");
							System.out.println("Your balance is: $" + new Formatter().format("%,.2f", Double.parseDouble(bankService.getBalance())));
						}
						else if(something == 4)
						{
							System.out.println("ERROR: Invalid input.");
						}
						else if(something == 5) {
							System.out.println("ERROR: 4");
						}

						break;
					case "4":
						ArrayList<String> data = bankService.readAccount();
						System.out.println("Balance " + "Transaction " + "Date");
						for(String update : data) {
							String[] d = update.split(":");
							System.out.println("$" + new Formatter().format("%,.2f", Double.parseDouble(d[0])) 
									+ " " + d[1] + " " + d[2] + ":" + d[3]);
						}
						break;

					case "5":

					case "6":
						System.out.println("Logging out...");
						bankService.logout();
						loggedIn = bankService.isOpen();
						break;

					}
				}
			}
		}

	}
}

	/**
	 * Requirements: As a user I can,
	 * login
	 * create an acount
	 * logout
	 * withdraw or deposit funds
	 * view my account balance
	 * edit my* information
	 * "should not be able to edit other accounts
	 * 
	 * Tech Specs
	 * - core java, file i/o
	 * 
	 */










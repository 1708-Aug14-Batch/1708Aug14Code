package com.bank.run;

import java.util.Formatter;
import java.util.Scanner;

import com.bank.dao.DAOIm;
import com.bank.pojo.Account;
import com.bank.pojo.AccountType;
import com.bank.pojo.User;
import com.bank.service.Service;


public class TestBank {
	public static User myUser = new User();
	public static void main(String[] args) {

		Service bankService = new Service();
		User myUser = new User();
		Scanner scan = new Scanner(System.in);


		boolean loggedIn = false;

		while(true)
		{
			while (!loggedIn)
			{	
				System.out.println("\nWelcome to Revature Banking.");

				System.out.println("Enter (1) Login \n"
						+ "(2) Create Acccount.");
				String choice = scan.nextLine();

				switch (choice){


				case "1": /**Login*/

					System.out.println("enter email");
					String email = scan.nextLine();

					System.out.println("enter password");
					String password = scan.nextLine();

					boolean statement = bankService.login(email, password);
					System.out.println(statement);// testing remove this before app is ready to go live


					if (statement == true) {
						//loggedIn = true;
						System.out.println(email + " has logged in.");
						myUser = bankService.getUser(email, password);
						System.out.println(myUser);
					}
					//TODO when logging in the and input wrong password the system crashes.
					else if(statement == false) {
						System.out.println("ERROR: Invalid input.");
						continue;
					} else {
						System.out.println("Invalid email Please try again.");
					}

					break;

				case "2":  /** Create User*/

					System.out.println("enter your first name");
					String fn = scan.nextLine().trim();

					System.out.println("enter your Last name");
					String ln = scan.nextLine().trim();

					System.out.println("enter your email");

					String em = scan.nextLine().trim();


					/** Check to see if account already is registered
					 * using an equals method on email to verify if there exists another email*/
					/** Existing file to see if email exists
					 * then continue with program if not 
					 * prompt user with sysout that user all ready exists 
					 * in a while loop until a new unique valid email is entered.
					 */
					System.out.println("enter your new password");
					String pw = scan.nextLine().trim();
					/**adds new user*/
					int addId = bankService.addUser(fn, ln, em, pw);
					myUser = bankService.getUser(em, pw);

					boolean createAccount = false;
					while(!createAccount){
						/** check to see if user was created if so create a type of account*/
						if(addId == bankService.getUserId(em, pw)){

							System.out.println(" Create Account: Enter (1) Checking \n" 
									+ "(2) Saving \n" + "(3) Credit Card");

							int createType = scan.nextInt();


							bankService.addAccount(myUser, createType);
							/** returns the result if the account was created or not*/
							boolean check = bankService.getAccount(myUser);

							/** check to see if account was created if so log in*/
							if(check == true){
								createAccount = true;
								loggedIn = true; // logs into account

							}
							else if(check == false) {
								System.out.println("ERROR: Account was not created.");
								continue;
							}
						}
					}
				} //ends while not loggged in;

				/** while still logged in perform following banking services*/
				while (bankService.isOpen()){

					System.out.println("\nWhat would you like to do?");
					System.out.println(   "1:View Balance \n"
							+ "2:Deposit \n"
							+ "3:Withdraw \n"
							+ "4:Transfer\n"  //between users accounts
							+ "5:EditAccount \n"
							+ "6:Logout");
					System.out.print("> ");
					String cho = scan.nextLine();
					double something = 0;

					switch (cho){
					case "1": /** Get Account Balance*/


						System.out.println( "Your balance is: $" + new Formatter().
								format("%,.2f", Double.parseDouble(bankService.getBalance())));
						break;

					case "2": /**Deposit Funds*/
						System.out.println(myUser);
						System.out.println("Enter the amount to deposit.");
						/** sets the holding balance to the new balance.*/

						something = bankService.deposit(myUser, scan.nextLine());

						

						if (something > 0) {
							System.out.println("Deposit successful.");
							System.out.print("Your balance is: $" + something);
						} else if (something < 0) {
						 	System.out.println("ERROR: Invalid input.");
						 break;
						} else{
						}						
						break;

					case "3": /**WithDraw Funds*/
						double some = 0;

						System.out.println("Enter the amount to Withdraw.");
						some = bankService.withdraw(myUser, scan.nextLine());

						if(some > 0){
							System.out.println("Withdraw successful.");
							System.out.println("Your balance is: $" + some);
						}else if(some < 0) {
							System.out.println("ERROR: Insufficient funds.");
							break;
						}
						else{
						}
						break;

					case "4": /** Transfer Funds*/



						break;

					case "5": /**Edit User Details*/
						String editEmail;
						String editPassword;
						System.out.println(" Enter you new desired email");
						editEmail = scan.nextLine();

						System.out.println(" Enter you new desired password");
						editPassword = scan.nextLine();
						bankService.editUser(myUser, editEmail, editPassword);
						break;
					case "6": /**Logging Out*/
						System.out.println("Logging out...");
						bankService.logout();
						loggedIn = bankService.isOpen();
						break;

					}// end of switch.
				} // end of bankopen while.
			} // end of not logged in while loop.
		}// end of while true.

	}// ends main.
} //Test class main.















//		int id = yo.addUser("joshua", "Wurdemann", "joshwurdemann@gmail.com", "thebig1");
//		int id1 = yo.addUser("Bob", "Wurdemann", "Bob@gmail.com", "hello");
//		System.out.println(id1);





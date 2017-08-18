package com.bank.main;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;
import com.bank.service.Service;


public class RunBank {
	// implementation to actually run bank application
	static Service bankService;
	static Scanner input;
	static User session;
	public static void main(String[] args) {
		bankService = new Service();
		input = new Scanner(System.in);
		System.out.println("Welcome to the Bank:");
		
		userMenu();
	}
	
	static void userMenu(){
		System.out.println("What would you like to do?");
		System.out.println("1-login");
		System.out.println("2-Create new User");
		System.out.println("3-Quit");
		int userInput = input.nextInt();
		input.nextLine();
		switch(userInput){
			case 1: login();
				break;
			case 2: createNewUser();
				break;
			case 3: System.exit(0);
				break;
			default: 
				System.out.println("Try again");
				userMenu();
		}
	}
	static void login(){
		System.out.println("Please enter your Email: ");
		String user = input.nextLine().toLowerCase();
		//input.nextLine();
		System.out.println("Please enter your Password: ");
		String pass = input.nextLine();
		if((session = bankService.getUser(user, pass)) != null){
			System.out.println("Welcome back " + session.getFirstname());
			userMenu2();
		}
		else{
			System.out.println("Incorrect username or password");
			login();
		}
	}
	static void logout(){
		userMenu();
		//System.exit(0);
	}
	static void createNewUser(){
		Random random = new Random();
		int userId = 1000 + random.nextInt(9000);
		System.out.println("Enter your First Name: ");
		String firstName = input.nextLine();
		//input.nextLine();
		System.out.println("Enter your Last Name: ");
		String lastName = input.nextLine();
		System.out.println("Enter your Email: ");
		String email = input.nextLine().toLowerCase();
		System.out.println("Enter your Password: ");
		String pass = input.nextLine();
		System.out.println("Please Enter a begining balance: ");
		double beginBalance = input.nextDouble();
		
		User user = new User(userId , firstName, lastName, email, pass);
		session = bankService.addUser(user);
		session = bankService.depositFunds(session, beginBalance);
		System.out.println("Welcome to the bank " + session.getFirstname());
		userMenu2();
		
	}
	static void userMenu2(){
		System.out.println("What would you like to do today: ");
		System.out.println("1 to view balance :: 2 to make a deposit :: 3"
				+ " to withdrawfunds :: 4 to update information"
				+ "5 to logot::6 to delete");
		int userAnswer = input.nextInt();
		input.nextLine();
		
		switch(userAnswer){
		case 1:{
			//System.out.println("Your Balance is: "+ session.getBalance());;
			balance();
			break;}
		case 2:{
			userDeposit();
			break;}
		case 3:{
			userWithdraw();
			break;}
		case 4:{
			userUpdate();
			break;}
		case 5:{
			logout();
			break;}
		case 6:{
			deleteUser();
			break;}
		default: 
			System.out.println("Invalid Input");
			userMenu2();
		
		}
		userMenu2();
	}
	
	static void deleteUser(){
		bankService.removeUser(session);
		userMenu();
	}

	static void balance(){
		System.out.println("Your Balance is: "+ session.getBalance());;
	}
	static void userUpdate(){
		System.out.println("What would you like to change: ");
		System.out.println("1 for First name");
		System.out.println("2 for Last Name");
		System.out.println("3 for password");
		System.out.println("4 To go back to previous menu");
		int userInput = input.nextInt();
		input.nextLine();
		switch(userInput){
		case 1:{
			System.out.println("What woud you like your first name to be:");
			String fn = input.nextLine();
			bankService.updateFirstName(session, fn);
			break;}
		case 2:{
			System.out.println("What woud you like your Last name to be:");
			String ln = input.nextLine();
			bankService.updateLastName(session, ln);
			break;}
		case 3:{
			System.out.println("What woud you like your Password to be:");
			String ps = input.nextLine();
			bankService.updateFirstName(session, ps);
			break;}
		case 4: userMenu2();
			break;
		default: System.out.println("Invalid Input");
			userUpdate();
		}
		userMenu2();
		
	}
	static void userWithdraw(){
		System.out.println("Enter amout you would like to withdraw");
		Double userWithdraw = new Double(input.nextDouble());
		input.nextLine();
		if(userWithdraw > session.getBalance()){
			System.out.println("Insufficient Funds");
			System.out.println("Would you like to contine");
			String userInputs = input.nextLine().toLowerCase();
			if(userInputs == "yes"){
				userWithdraw();
			}else{userMenu2();}
		}else{
		session = bankService.withdrawFunds(session,userWithdraw);
		System.out.println("Funds Withdrawn: " + userWithdraw);
		System.out.println("New Balance: " + session.getBalance());
		userMenu2();}
	}
	static void userDeposit(){
		System.out.println("Enter the amount you would like to deposit:");
		Double userDeposit = new Double(input.nextDouble());
		session = bankService.depositFunds(session, userDeposit);
		System.out.println("Success");
		System.out.println("New Balance: " + session.getBalance());
		userMenu2();
	}
	
	
	/*
	 * Requirements: As a user I can,
	 * 	- login
	 * 	- create an account
	 * 	- logout
	 * 	- withdraw or deposit funds
	 * 	- view my* account balance
	 * 	- edit my* information
	 * 
	 * Tech-Specs
	 * - core java, file i/o
	 */
	

}
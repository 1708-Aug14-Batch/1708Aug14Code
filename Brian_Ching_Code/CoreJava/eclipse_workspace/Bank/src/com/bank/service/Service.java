package com.bank.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;

public class Service {
	
//	DAO dao = new DaoTextImpl();
	//login functionality
	//what do you want to do functionality
	
	static Scanner sc = new Scanner(System.in);
	static String username;
	static String password;
	static Scanner readFile = null;
	static String line;

	static String filename = "src/Server/test.txt";

	public static void login(){

		System.out.println();
		System.out.println("Enter username: ");
		username = sc.nextLine();

		System.out.println("Enter password: ");
		password = sc.nextLine();

		try
		{
			readFile = new Scanner(new File(filename));
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("Error opening the file " + "test.txt");
			System.exit(0);
		}


		line = readFile.nextLine();
		if (line.equals(username)){
			System.out.println();
			System.out.println("Username is correct");
			
		} else {
			System.out.println();
			System.out.println("Your username is incorrect.  Please try again.");
			login();
		}

		line = readFile.nextLine();

		if (line.equals(password)){
			System.out.println();
			System.out.println("Password is correct");
		} else {
			System.out.println();
			System.out.println("Your password is incorrect.  Please try again.");
			login();
		}

		Options();
	}

	public static void Options(){
		int choice;
		System.out.println();
		System.out.println("Welcome, what options would you like? - (1)Withdraw, (2)Deposit, (3)View Account, (4)Edit my info " );
		choice = sc.nextInt();
		if(choice == 1){
			withdraw();
		}else if(choice == 2){
			deposit();
		}else if(choice == 3){
			viewAccount();
		}else if(choice == 4){
					editInfo();
				}
		//		else{
		//			System.out.println("Pick a selected number");
		//			Options();
		//		}
	}

	public static void withdraw(){

		try(BufferedReader br =
				new BufferedReader(new FileReader(filename));){	

			String line = null;
			while(( br.readLine())!=null){

				if(br.read()=='$'){
					line = br.readLine();
					System.out.println();
					System.out.println("this is your account balance: $" + line);

					int temp = Integer.parseInt(line);
					System.out.println("How much would you like to withdraw?");
					int userWithdraw = sc.nextInt();
					int balanceTotal = temp - userWithdraw;
					System.out.println("This is your new Total: $"+ balanceTotal);
				}
			}
			Options();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void deposit(){ 

		try(BufferedReader br =
				new BufferedReader(new FileReader(filename));){	

			String line = null;
			while(( br.readLine())!=null){

				if(br.read()=='$'){
					line = br.readLine();
					System.out.println();
					System.out.println("this is your account balance: $" + line);

					int temp = Integer.parseInt(line);
					System.out.println("How much would you like to deposit?");
					int depositNow = sc.nextInt();
					int balanceTotaladded = temp + depositNow;
					System.out.println("This is your new Total: $"+ balanceTotaladded);
				}

			}
			Options();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}	

	}



	public static void viewAccount(){ 

		try(BufferedReader br =
				new BufferedReader(new FileReader(filename));){	

			line = br.readLine();
			while( line != null){
				System.out.println(line);
				line = br.readLine();

			}
			Options();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}	
		
	}	
	
	
	public static void editInfo(){
		DaoTextImpl.editinfo();
	}
	
	
	public static void exit(){
		System.exit(0);
		
	}
	
}

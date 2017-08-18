package com.bank.main;

import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
	static User user = new User();
	
	public static void main(String[] args){
		// implementation to actually run bank application
		Service bankService = new Service();
		while(true){
			System.out.println("WELCOME TO REVEATURE BANK SIMULATOR");
			MenuMain(bankService.dao);
		}
	}
	
	static public void MenuMain(DAO dao){
		Scanner input = new Scanner(System.in);
		boolean access=false;
		int userOption;
		
		while(!access){
			System.out.println("0=create new Account");
			System.out.println("1=User Login");
			userOption =input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: {createAccount(dao);
					access=login(dao);
			}break; // create user account
			case 1: access=login(dao); break; // login user account
			default: System.out.println("Invalid user option please try again"); break; // incorrect option
			}
		}
		
		while(access){
			System.out.println("0=EXIT");
			System.out.println("1=View my account information");
			System.out.println("2=Make deposit or withdraw");
			System.out.println("3=Change my account info");
			System.out.println("4=Clsoe my account");
			userOption =input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: access=false; break; // user log out
			case 1: viewAccountInfo(); break; // view my account
			case 2: DepoistOrWithdraw(dao); break; // Deposit or Withdraw
			case 3: EditMyAccountInfo(dao); break; // change my info
			case 4: {
				CloseMyAccount(dao);
				access=false;
			}break; // close my account
			default: System.out.println("Invalid user option please try again"); break; // incorrect option
			}
		}
		user=null;
	}
	
	static public boolean login(DAO dao){
		Scanner input = new Scanner(System.in);
		int userOption=0;
		boolean exit=false;
		boolean access=false;
		
		while(!exit){
			System.out.println("0=EXIT");
			System.out.println("1=User Login");
			userOption =input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: exit=true; break;
			case 1: {
				System.out.println("please enter user ID:");
				int id =input.nextInt();
				input.nextLine();
				System.out.println("plese enter user password:");
				String password =input.nextLine();
				user=dao.authentication(id, password);
				if(user==null)
					System.out.println("user infromation incorrect please try again");
				else{
					exit=true;
					access=true;
					System.out.println("login sucessfull");
				}
			} break;
			default: System.out.println("Invalid user option please try again"); break; // incorrect option
			}
		}
		return access;
	}
	
	static public void createAccount(DAO dao){
		Scanner input = new Scanner(System.in);
		System.out.println("please enter your firstname:");
		String firstname=input.nextLine();
		System.out.println("please eneter your lastname:");
		String lastname=input.nextLine();
		System.out.println("plese enter your email:");
		String email=input.nextLine();
		System.out.println("plese enter your password:");
		String password=input.nextLine();
		System.out.println("plese enter your stating balance:");
		String balance=input.nextLine();
		String id = Integer.toString(dao.userIDgeneration());
		dao.addUser(id, firstname, lastname, email, password, balance);
	}
	
	static public void viewAccountInfo(){
		System.out.println("User ID = "+user.getID());
		System.out.println("FirstName = "+user.getFirstname());
		System.out.println("LastName = "+user.getLastname());
		System.out.println("Email = "+user.getEmail());
		System.out.println("Balance = "+user.getBalance());
	}
	
	static public void DepoistOrWithdraw(DAO dao){
		User tempUser = user;
		Scanner input = new Scanner(System.in);
		int userOption=0;
		int amount=0;
		boolean exit=false;
		
		while(!exit){
			System.out.println("0=EXIT discard change");
			System.out.println("1=Depoist");
			System.out.println("2=Withdraw");
			System.out.println("3=EXIT save change");
			userOption=input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: {
				tempUser=null;
				exit=true;
				System.out.println("your change is not saved");
			} break;
			case 1: {
				System.out.println("please enter amount to despoit:");
				amount=input.nextInt();
				input.nextLine();
				tempUser=dao.changeBalance(tempUser, amount, true);
			} break;
			case 2: {
				System.out.println("please enter amount to withdraw: ");
				amount=input.nextInt();
				input.nextLine();
				tempUser=dao.changeBalance(tempUser, amount, true);
			} break;
			case 3: {
				user=tempUser;
				dao.updateUser(user);
				exit=true;
				System.out.println("Commited your transaction");
				System.out.println("your reminding balance: "+user.getBalance());
			} break;
			default: System.out.println("Invalid user option please try again"); break;
			}
		}
	}
	
	static public void EditMyAccountInfo(DAO dao){
		User tempUser = user;
		Scanner input = new Scanner(System.in);
		boolean exit=false;
		while(!exit){
			System.out.println("0=EXIT discard change");
			System.out.println("1=change user first name");
			System.out.println("2=change user last name");
			System.out.println("3=change user email");
			System.out.println("4=change user password");
			System.out.println("5=EXIT save change");
			int userOption =input.nextInt();
			input.nextLine();
				
			switch(userOption){
			case 0: {
				tempUser=null;
				exit=true;
				System.out.println("your change is not saved");
			} break;
			case 1: {
				System.out.println("please enter your new firstname:");
				String changeFirst =input.nextLine();
				tempUser.setFirstname(changeFirst);
				System.out.println("you changed your firstname to: "+changeFirst);
			}break;
			case 2: {
				System.out.println("please enter your new lastname:");
				String changeLast =input.nextLine();
				tempUser.setLastname(changeLast);
				System.out.println("you changed your lastname to: "+changeLast);
			}break;
			case 3: {
				System.out.println("please enter your new email:");
				String changeEmail =input.nextLine();
				tempUser.setEmail(changeEmail);
				System.out.println("you changed your email to: "+changeEmail);
			}break;
			case 4: {
				System.out.println("please enter your new password:");
				String changePass =input.nextLine();
				tempUser.setPassword(changePass);
				System.out.println("you changed your password to "+changePass);
			}break;
			case 5: {
				user=tempUser;
				dao.updateUser(user);
				exit=true;
				System.out.println("your account information is updated");
			}break;
			default: System.out.println("invalid input please try again"); break;
			}
		}
	}
	
	static public void CloseMyAccount(DAO dao){
		dao.deleteUser(user);
	}

	// Requirements: As a user I can:
	// - login
	// - create an account
	// - logout
	// - withdraw or deposit
	// - view my account balance
	// - edit my information
	
	// TechSpects
	// - core java, file I/O
	// [user] --> text file <--> [DAO interface, DAO implementation] --> [service] <-- [RunBank]
}

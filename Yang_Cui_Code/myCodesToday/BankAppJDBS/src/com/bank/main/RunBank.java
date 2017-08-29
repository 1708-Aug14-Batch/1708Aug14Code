package com.bank.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;
import com.bank.pojos.Account;
import com.bank.pojos.User;
import com.bank.service.Service;

public class RunBank {
	static int userID;
	
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
		userID=-1;
		int userOption;
		
		while(userID<0){
			System.out.println("0=create new User");
			System.out.println("1=User Login");
			userOption =input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: {createUser(dao);
					userID=login(dao);
			}break; // create user account
			case 1: userID=login(dao); break; // login user account
			default: System.out.println("Invalid user option please try again"); break; // incorrect option
			}
		}
		
		while(userID>0){
			System.out.println("0=EXIT");
			System.out.println("1=Create new account");
			System.out.println("2=View my account information");
			System.out.println("3=Make deposit or withdraw");
			System.out.println("4=Change my User info");
			System.out.println("5=Clsoe my account");
			userOption =input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: userID=-1; break; // user log out
			case 1: OpenAccount(dao); break;
			case 2: viewAccountInfo(dao); break; // view my account
			case 3: DepoistOrWithdraw(dao); break; // Deposit or Withdraw
			case 4: EditMyAccountInfo(dao); break; // change my info
			case 5: CloseMyAccount(dao); break; // close my account
			default: System.out.println("Invalid user option please try again"); break; // incorrect option
			}
		};
	}
	
	static public int login(DAO dao){
		Scanner input = new Scanner(System.in);
		User user =new User();
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
		return user.getID();
	}
	
	static public void createUser(DAO dao){
		Scanner input = new Scanner(System.in);
		System.out.println("please enter your firstname:");
		String firstname=input.nextLine();
		System.out.println("please eneter your lastname:");
		String lastname=input.nextLine();
		System.out.println("plese enter your email:");
		String email=input.nextLine();
		System.out.println("plese enter your password:");
		String password=input.nextLine();
		dao.addUser(firstname, lastname, email, password);
	}
	
	public static void OpenAccount(DAO dao){ //<-- open new account at this user id
		Scanner input = new Scanner(System.in);
		int userOption=0;
		boolean exit=false;
		
		User user =dao.getUser(userID);
		if(user==null){
			System.out.println("User does not exist");
		}
		else{
			while (!exit){
				System.out.println("0=EXIT");
				System.out.println("1=Create a Checking Account");
				System.out.println("2=Create a Saving Account");
				System.out.println("3=Create a Credit Union");
				userOption=input.nextInt();
				input.nextLine();
				
				switch(userOption){
				case 0: exit=true; break;
				case 1: createAccount(dao,user,userOption); break;
				case 2: createAccount(dao,user,userOption); break;
				case 3: createAccount(dao,user,userOption); break;
				default:System.out.println("Invalid user option please try again");break;
				}
			}
		}
	}
	
	public static void createAccount(DAO dao, User user, int accType){
		ArrayList<Account> acclist=dao.getAccount(user);
		int hasAccount=0;
		for(Account acc : acclist){
			if(acc.getID()==accType)
				hasAccount++;
		}
		
		if(hasAccount>4)
			System.out.println("You already have maximum number of this type of account");
		else{
			int x=-1;
			x=dao.addAccount(user, accType);
			if(x>-1)
				System.out.println("Account Created type "+accType);
			else
				System.out.println("Failed to create account");
		}
	}
	
	static public void viewAccountInfo(DAO dao){
		User user = dao.getUser(userID);
		ArrayList<Account> acclist = dao.getAccount(user);
		
		System.out.println("User ID = "+(user.getID()));
		System.out.println("FirstName = "+user.getFirstname());
		System.out.println("LastName = "+user.getLastname());
		System.out.println("Email = "+user.getEmail());
		
		for(Account acc : acclist){
			System.out.println("Account ID = "+acc.getID());
			System.out.println("Account Balance ="+acc.getBalance());
			System.out.println("Account Type ="+acc.getType().getID());
			System.out.println("Account Type ="+acc.getType().getName());
		}
	}
	
	static public void DepoistOrWithdraw(DAO dao){
		Scanner input = new Scanner(System.in);
		int userOption=0;
		int amount=0;
		int accID=-1;
		boolean exit=false;
		
		while(!exit){
			System.out.println("0=EXIT");
			System.out.println("1=Depoist");
			System.out.println("2=Withdraw");
			System.out.println("3=Transfer");
			userOption=input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: {
				exit=true;
				System.out.println("your change is not saved");
			} break;
			case 1: {
				System.out.println("please enter your account ID:");
				accID=input.nextInt();
				input.nextLine();
				if(IsMyAccount(dao,accID));
				else
					break;
				System.out.println("please enter amount to despoit:");
				amount=input.nextInt();
				input.nextLine();
				Account tempAcct = dao.getAnAccount(accID);
				tempAcct.setBalance(tempAcct.getBalance()+amount);
				tempAcct=dao.changeBalance(tempAcct);
				if(tempAcct==null)
					System.out.println("Something went wrong despoit not effective");
				else
					System.out.println("$"+amount+" added to your account");
			} break;
			case 2: {
				System.out.println("please enter your account ID:");
				accID=input.nextInt();
				input.nextLine();
				if(IsMyAccount(dao,accID));
				else
					break;
				System.out.println("please enter amount to withdraw: ");
				amount=input.nextInt();
				input.nextLine();
				Account tempAcct = dao.getAnAccount(accID);
				tempAcct.setBalance(tempAcct.getBalance()-amount);
				tempAcct=dao.changeBalance(tempAcct);
				if(tempAcct==null)
					System.out.println("Something went wrong despoit not effective");
				else
					System.out.println("$"+amount+" subtracted from your account");
			} break;
			case 3: {
				Transfer(dao);
			} break;
			default: System.out.println("Invalid user option please try again"); break;
			}
		}
	}
	
	static public void Transfer(DAO dao){
		Scanner input = new Scanner(System.in);
		int fromID=-1;
		int toID=-1;
		int transfer=0;
		boolean bothAccount=false;
		
		System.out.println("Enter amount to transfer:");
		transfer=input.nextInt(); input.nextLine();
		
		while(!bothAccount){
			System.out.println("Enter account ID transfer from:");
			fromID=input.nextInt(); input.nextLine();
			System.out.println("Enter account ID transfer to:");
			toID=input.nextInt(); input.nextLine();
			if(IsMyAccount(dao,fromID) && IsMyAccount(dao,toID))
				bothAccount=true;
			else
				bothAccount=false;
		}
		
		Account tempAcct1=dao.getAnAccount(fromID);
		Account tempAcct2=dao.getAnAccount(toID);
		
		double balanceFrom=tempAcct1.getBalance();
		double balanceTo=tempAcct2.getBalance();
		
		tempAcct1.setBalance(tempAcct1.getBalance()-transfer);
		tempAcct2.setBalance(tempAcct2.getBalance()+transfer);
		
		tempAcct1=dao.changeBalance(tempAcct1);
		tempAcct2=dao.changeBalance(tempAcct2);
		
		if(tempAcct1!=null && tempAcct2!=null)
			System.out.println("Transfer sucessfull");
		else{
			System.out.println("Transfer not sucessfull");
			tempAcct1.setBalance(balanceFrom);
			tempAcct2.setBalance(balanceTo);
			tempAcct1=dao.changeBalance(tempAcct1);
			tempAcct2=dao.changeBalance(tempAcct2);
		}
	}
	
	static public void EditMyAccountInfo(DAO dao){
		User tempUser = dao.getUser(userID);
		Scanner input = new Scanner(System.in);
		boolean exit=false;
		while(!exit){
			System.out.println("0=EXIT");
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
				dao.updateUser(tempUser);
				exit=true;
				System.out.println("your account information is updated");
			}break;
			default: System.out.println("invalid input please try again"); break;
			}
		}
	}
	
	static public void CloseMyAccount(DAO dao){
		Scanner input = new Scanner(System.in);
		int accID;
		int userOption;
		boolean exit=false;
		while(!exit){
			System.out.println("0=EXIT");
			System.out.println("1=Close your account");
			userOption=input.nextInt();
			input.nextLine();
			
			switch(userOption){
			case 0: exit = true; break;
			case 1: {
				System.out.println("Enter account ID to close account:");
				accID=input.nextInt();
				input.nextLine();
				if(IsMyAccount(dao,accID));
				else
					break;
				int close=dao.closeAccount(dao.getAnAccount(accID));
				if(close>-1)
					System.out.println("Account "+accID+" is closed");
				else
					System.out.println("Something went wrong");
			}break;
			default: System.out.println("invalid input please try again"); break;
			}
		}
	}
	
	static public boolean IsMyAccount(DAO dao, int accID){
		boolean myAccount = dao.accountVarify(dao.getUser(userID), accID);
		if(myAccount);
		else
			System.out.println("This account does not exist");
		return myAccount;
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

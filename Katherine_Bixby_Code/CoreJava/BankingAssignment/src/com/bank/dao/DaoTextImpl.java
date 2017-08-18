package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.User;


/**
 * Class that implements the DAO interface. It is the direct line between the service class and the data file.
 * @author Katie
 *
 */
public class DaoTextImpl implements DAO{

	static String filename="src/com/bank/data/users.txt";	// the data file
	
	/**
	 * Writes  in a new User, person, into the text file at filename.
	 * @param person
	 * 		The new User to add in.
	 */
	public void writeUser(User person) {
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filename,true))) {
			String text = "";
			text = text.concat(Integer.toString(person.getUserID())+":");
			text = text.concat(person.getFirstName()+":");
			text = text.concat(person.getLastName()+":");
			text = text.concat(person.getUserName()+":");
			text = text.concat(person.getPassword()+":");
			text = text.concat(person.getBalance()+"\n");
			
			bw.write(text);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads in all the users and stores them in a User-based ArrayList.
	 * @return
	 * 		The ArrayList<User> with all of the Users from the txt file, filename.
	 */
	public ArrayList<User> readUser(){
		ArrayList<User> list = new ArrayList<User>();
		
		try(BufferedReader br =
				new BufferedReader(
						new FileReader(filename));) {
			
			String line = null;
			while((line=br.readLine())!=null) {
				User temp = new User();
				String[] states = line.split(":");	// Delineated by ':' 
				temp.setUserID(Integer.parseInt(states[0]));	// first index is unique UID
				temp.setFirstName(states[1]);
				temp.setLastName(states[2]);
				temp.setUserName(states[3]);
				temp.setPassword(states[4]);
				BigDecimal theBalance = new BigDecimal(Integer.parseInt(states[5]));	// Converting the text of the .txt file into the BigDecimal value of the object User
				temp.setBalance(theBalance);
				list.add(temp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	@Override
	public void addUser(Scanner scan, ArrayList<User> theUsers) {
		User newUser = new User();
		scan.nextLine();
		System.out.println("Enter your first name: ");
		String fn="";
		fn = scan.nextLine().trim();
		System.out.println("Enter your last name: ");
		String ln="";
		ln = scan.nextLine().trim();
		System.out.println("Enter a username: ");
		String uname="";
		uname = scan.nextLine().trim();
		System.out.println("Enter a password: ");
		String pass="";
		pass = scan.nextLine().trim();
		int theID = 0;
		if(theUsers.size()==0) {
			theID = 1;
		}
		else {
			theID = theUsers.get(theUsers.size()-1).getUserID()+1;
		}
		BigDecimal bal = new BigDecimal(0.0);
		boolean writeYes = false;
		if(theUsers.size()==0) {
			newUser = new User(theID,fn,ln,uname,pass,bal);
			writeUser(newUser);
		}
		else {
			for(User i:theUsers) {
				if(i.getUserName().equals(uname)) {
					System.out.println("Try again! That username is already taken!");
					System.out.println("Please press enter to try again!");
					addUser(scan,theUsers);
					break;
				}
				else {
					writeYes = true;
					break;
				}
			}
			if(writeYes) {
				newUser = new User(theID,fn,ln,uname,pass,bal);
				writeUser(newUser);
			}
		}
	}
	

	@Override
	public ArrayList<User> editUser(ArrayList<User> theUsers, String allowedUser, Scanner scan) {
		scan.nextLine().trim();
		int userIDNum = nameToID(allowedUser, theUsers);
		User updatedUser = new User();
		ArrayList<User> updatedUserList = new ArrayList<User>();
		int tempUserID;
		
		for (int i=0;i<theUsers.size();i++) {
			tempUserID = theUsers.get(i).getUserID();
			if(userIDNum==tempUserID) {
				System.out.println("Enter new first name: ");
				String newFn = scan.nextLine().trim();
				System.out.println("Enter new last name: ");
				String newLn = scan.nextLine().trim();
				System.out.println("Enter new username: ");
				String newUName = scan.nextLine().trim();
				System.out.println("Enter new password: ");
				String newPass = scan.nextLine().trim();
				updatedUser.setBalance(theUsers.get(i).getBalance());
				updatedUser.setFirstName(newFn);
				updatedUser.setLastName(newLn);
				updatedUser.setUserName(newUName);
				updatedUser.setPassword(newPass);
				updatedUserList.add(updatedUser);
			}
			else {
				updatedUserList.add(theUsers.get(i));
			}
		}
		return updatedUserList;

		
	}
	
	/**
	 * Method for withdrawing money from the user allowedAccount's account balance.
	 * @param theUsers
	 * 		The list of existing users.
	 * @param allowedAccount
	 * 		The username of the account who is allowed to withdraw (logged in)
	 * @param scan
	 * 		The scanner used throughout the program
	 * @return
	 * 		The updated User list to be put into the text file as replacement data.
	 */
	public ArrayList<User> withdrawal(ArrayList<User>theUsers,String allowedAccount,Scanner scan) {
		System.out.println("Please enter the dollar amount you would like to withdraw:");
		BigDecimal curBal = getBalance(theUsers,allowedAccount);
		System.out.print("Current Balance: $"+curBal+"\n");
		System.out.print("Amount to withdraw: $");
		BigDecimal takeOut = scan.nextBigDecimal();
		ArrayList<User> newList = new ArrayList<User>();
		if(takeOut.compareTo(curBal)==1) {
			System.out.println("You cannot take out that much money.");
		}
		else {
			BigDecimal newBal = curBal.subtract(takeOut);
			newList = updateMoney(theUsers,allowedAccount,newBal);
		}
		return newList;
	}
	
	
	
	/**
	 * Method for depositing money to the user allowedAccount's account balance.
	 * @param theUsers
	 * 		The list of existing users.
	 * @param allowedAccount
	 * 		The username of the account who is allowed to withdraw (logged in)
	 * @param scan
	 * 		The scanner used throughout the program
	 * @return
	 * 		The updated User list to be put into the text file as replacement data.
	 */
	public ArrayList<User> deposit(ArrayList<User>theUsers,String allowedAccount,Scanner scan) {
		System.out.println("Please enter the dollar amount you would like to deposit:");
		BigDecimal curBal = getBalance(theUsers,allowedAccount);
		System.out.print("Current Balance: $"+curBal+"\n");
		System.out.print("Amount to deposit: $");
		BigDecimal putIn = scan.nextBigDecimal();
		BigDecimal newBal = curBal.add(putIn);
		ArrayList<User> newList = updateMoney(theUsers,allowedAccount,newBal);
		return newList;
	}
	
	
	/**
	 * An updating money method used only within the DaoTextImpl class.
	 * Used in the deposit and withdraw methods to create the new updated User list
	 * with the new balance for the given user updated.
	 * @param theUsers
	 * 		The existing user list
	 * @param username
	 * 		The username of the account whose balance will be changed
	 * @param newMoney
	 * 		The new balance amount (which is calculated in deposit and withdraw individually)
	 * @return
	 * 		The updated User list to be put into the text file as replacement data.
	 */
	private static ArrayList<User> updateMoney(ArrayList<User>theUsers,String username, BigDecimal newMoney){
		for (User i:theUsers) {
			if(i.getUserName().equals(username)) {
				i.setBalance(newMoney);
			}
		}
		return theUsers;
	}
	
	/**
	 * A balance showing method for whichever User has the username 'account'.
	 * Used only within the DaoTextImpl class.
	 * Used in the withdraw and deposit methods to show the user what their
	 * balance is before deposit or withdrawl, and then is used to calculate the
	 * new balance post doing one of those actions.
	 * @param theUsers
	 * 		The existing user list
	 * @param account
	 * 		The account whose bank balance should be viewed.
	 * @return
	 * 		The account balance of User with username 'account'
	 */
	private static BigDecimal getBalance(ArrayList<User>theUsers,String account) {
		BigDecimal curBal = new BigDecimal(0);
		for(User i:theUsers) {
			if(i.getUserName().equals(account)) {
				curBal  = new BigDecimal(i.getBalance().toBigInteger());
			}
		}
		return curBal;
	}
	
	/**
	 * The public checkBalance method to be used by the Service class for instances
	 * where the User would like to simply view their own account balance.
	 * @param theUsers
	 * 		The existing user list.
	 * @param allowedAccount
	 * 		The account whose balance is to be viewed.
	 * @return
	 * 		The User's balance.
	 */
	public BigDecimal checkBalance(ArrayList<User>theUsers,String allowedAccount) {
		
		boolean userAllowed = false;
		User allowedUser = new User();
		for(User i:theUsers) {
			if(i.getUserName().equals(allowedAccount)) {
				userAllowed=true;
				allowedUser = i;
			}
		}
		BigDecimal curBal = new BigDecimal(0);
		if(userAllowed) {
			curBal = new BigDecimal(allowedUser.getBalance().toBigInteger());
			System.out.println("Your current balance is: $"+curBal);
		}
		else {
			System.out.println("-----ACCESS DENIED-----");
		}
		return curBal;
	}
	
	/**
	 * Converts a given username to the unique user ID (though the usernames are also
	 * all unique, this is simply another way to test that in a sense).
	 * Also, it makes no sense for the User to ever have to input their UID,
	 * so this method converts between the two behind the scenes.
	 * @param uName
	 * 		The String username.
	 * @param theUsers.
	 * 		The existing users
	 * @return
	 * 		That user's UID based on their username.
	 */
	public int nameToID(String uName,ArrayList<User> theUsers) {
		for(User i:theUsers) {
			if (i.getUserName().equals(uName)) {
				return i.getUserID();
			}
		}
		return 0;
	}

	@Override
	public User getUser(int uniqueID,ArrayList<User> theUsers) {
		User foundUser = new User();
		for(User i:theUsers) {
			if(i.getUserID()==uniqueID) {
				return i;
			}
		}
		return foundUser;
	}
	

	
}

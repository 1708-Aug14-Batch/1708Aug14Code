package com.bank.service;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;

/**
 * The Service class. Serves as the bridge between the User Interface and the Dao (which access the text file of data). 
 * @author Katie
 *
 */
public class Service {
	
	DaoTextImpl dao = new DaoTextImpl();
	static ArrayList<User> theUsers;
	
	/**
	 * Checks if a user exists in the database.
	 * @param userName
	 * 		The inputted username to search for in the database.
	 * @return
	 * 		Whether or not the user exists.
	 */
	public boolean exists(String userName) {
		theUsers = dao.readUser();
		int uID = dao.nameToID(userName, theUsers);
		if(uID==0) {	// UID will only be 0 if the name does not exist (default is 1 and it increments up when new user added)
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Checks if the users loggin is correct.
	 * Will only be run with a username we've already checked exists in the database
	 * (via the exists method), so now we are comparing the password of the person
	 * with that username to the password given by the current user.
	 * @param userName
	 * 		The given username to check.
	 * @param password
	 * 		The password to check with the username.
	 * @return
	 * 		Whether or not the password matches the username.
	 */
	public boolean correctLogin(String userName,String password) {
		theUsers = dao.readUser();
		User thatUser = dao.getUser(dao.nameToID(userName,theUsers),theUsers);
		if(thatUser.getUserName().equals(userName)) {
			if(thatUser.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adding a new user to the database. This is a simple method but it is needed
	 * because we cannot just call the dao's readUser() from the RunBank class,
	 * as there is no direct instance of the DAO in the RunBank class.
	 * @param scan
	 * 		The scanner used throughout the program.
	 */
	public void addNewUser(Scanner scan) {
		theUsers = dao.readUser();
		dao.addUser(scan, theUsers);
	}
	
	/**
	 * The method for editing a user. This part of the method in here calls the editUser in the dao,
	 * and then once the dao has edited what it needs to edit it passes back the updated User list
	 * here, which this method then takes and writes into the text file, which it wipes, then adds
	 * each user from that updated list to one user at a time.
	 * @param access
	 * 		Whether or not the user currently has access to an account
	 * @param allowedUser
	 * 		The allowed user
	 * @param scan
	 * 		The scanner being used throughout the code.
	 */
	public void editAUser(boolean access, String allowedUser, Scanner scan) {
		theUsers = dao.readUser();
		if(access) {
			ArrayList<User> newList = dao.editUser(theUsers, allowedUser, scan);
			String filename="src/com/bank/data/users.txt";
			try {
				PrintWriter pw = new PrintWriter(filename);
				pw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			User person;
			for(int i=0;i<newList.size();i++) {
				try(BufferedWriter bw = 
						new BufferedWriter(new FileWriter(filename,true))) {
					person = newList.get(i);
					String text = "";
					text = text.concat(Integer.toString(i+1)+":");
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
		}
	}
	
	/**
	 * Running the dao's methods for checking the balance of the logged in user.
	 * @param access
	 * 		Whether or not the user is logged in.
	 * @param allowedUser
	 * 		The username of the person logged in.
	 */
	public void checkBalance(boolean access, String allowedUser) {
		theUsers = dao.readUser();
		if(access) {
			dao.checkBalance(theUsers,allowedUser);
		}
	}
	
	/**
	 * Calls the dao's method for withdrawing money.
	 * Here in this class, it writes the updated list that is returned by that method
	 * into the text file (replacing what was there before, and filling it in with
	 * the new users one at a time).
	 * @param access
	 * 		Whether or not the user is logged in.
	 * @param allowedUser
	 * 		The username of the person logged in.
	 * @param scan
	 * 		The scanner being used throughout the program.
	 */
	public void withdrawMoney(boolean access, String allowedUser, Scanner scan) {
		theUsers = dao.readUser();
		if(access) {
			ArrayList<User> newList = dao.withdrawal(theUsers, allowedUser,scan);
			String filename="src/com/bank/data/users.txt";
			try {
				PrintWriter pw = new PrintWriter(filename);
				pw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			User person;
			for(int i=0;i<newList.size();i++) {
				try(BufferedWriter bw = 
						new BufferedWriter(new FileWriter(filename,true))) {
					person = newList.get(i);
					String text = "";
					text = text.concat(Integer.toString(i+1)+":");
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
		}
	}
	
	/**
	 * Calls the dao's method for deposting money.
	 * Here in this class, it writes the updated list that is returned by that method
	 * into the text file (replacing what was there before, and filling it in with
	 * the new users one at a time).
	 * @param access
	 * 		Whether or not the user is logged in.
	 * @param allowedUser
	 * 		The username of the person logged in.
	 * @param scan
	 * 		The scanner being used throughout the program.
	 */
	public void depositMoney(boolean access, String allowedUser, Scanner scan) {
		theUsers = dao.readUser();
		if(access) {
			ArrayList<User> newList = dao.deposit(theUsers, allowedUser,scan);
			String filename="src/com/bank/data/users.txt";
			try {
				PrintWriter pw = new PrintWriter(filename);
				pw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			User person;
			for(int i=0;i<newList.size();i++) {
				try(BufferedWriter bw = 
						new BufferedWriter(new FileWriter(filename,true))) {
					person = newList.get(i);
					String text = "";
					text = text.concat(Integer.toString(i+1)+":");
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
		}
	}
	
}

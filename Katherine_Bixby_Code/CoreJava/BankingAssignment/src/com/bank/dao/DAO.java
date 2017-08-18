package com.bank.dao;

import java.util.ArrayList;
import java.util.Scanner;

import com.bank.pojos.User;

public interface DAO {
	
	/**
	 * Adding in a new User to the data file.
	 * If the new User tries to use a username that is already taken,
	 * the method runs again, to force them to input new information.
	 * Once the data is accepted, it writes the new user into the data file.
	 * @param scan
	 * 		The scanner being used throughout the program
	 * @param theUsers
	 * 		The list of existing users.
	 * 		This is used for the purpose of comparing new username to existing ones.
	 */
	void addUser(Scanner scan,ArrayList<User> theUsers);
	/**
	 * This is the method for when a user has requested to update their information.
	 * It prompts them to fill in which new data they want for each field,
	 * with the exceptions of balance, and unique ID, which stay the same.
	 * @param theUsers
	 * 		The existing Users, to get the User to be editied.
	 * @param allowedUser
	 * 		The username of the User who is allowed to be edited.
	 * @param scan
	 * 		The scanner being used throughout the program.
	 * @return
	 * 		The updated list of existing users.
	 * 		This is then to be written into the text file.
	 * 		That text file will be CLEANED, then each of these
	 * 		Users will be written into it one by one.
	 */
	ArrayList<User> editUser(ArrayList<User> theUsers,String allowedUser, Scanner scan);
	
	/**
	 * Gets the User who has the ID, uniqueID, and returns the instance of that User
	 * @param uniqueID
	 * 		The uniqueID of the user to be gotten.
	 * @param theUsers
	 * 		The list of existing users to scan through for the sought after user.
	 * @return
	 * 		The User object with the values of the User sought after.
	 */
	User getUser(int uniqueID,ArrayList<User> theUsers);
	
	
}

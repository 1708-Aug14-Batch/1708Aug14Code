package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.User;

/**
 * Provides methods for user CRUD operations.
 * @author will underwood
 */
public interface DAO {
	
	/**
	 * Adds a new user to the file.
	 * @precondition User cannot be null
	 * @param user - new user to be added
	 * @postcondition A new user was added to the file
	 */
	void createUser(User user);
	
	/**
	 * Returns all users from the file
	 * @precondition None.
	 * @param None.
	 * @return A collection of all users
	 */
	ArrayList<User> readAllUsers();
	
	/**
	 * Re-adds the edited user to the file.
	 * @precondition Edited User cannot be null
	 * @param editedUser - User to be updated
	 * @postcondition User data was updated
	 */
	void updateUser(User editedUser);
	
	/**
	 * Deletes the data of the specified user.
	 * @precondition User cannot be null
	 * @param user - User whose data will be deleted
	 * @return True if the data was successfully deleted. False otherwise.
	 */
	void destroyUser(User user);

}

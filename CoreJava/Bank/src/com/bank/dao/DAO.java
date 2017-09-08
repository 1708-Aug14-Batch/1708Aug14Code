package com.bank.dao;

<<<<<<< HEAD
import java.util.ArrayList;

import com.bank.pojos.User;

=======
>>>>>>> a3d401426b647d7925ad2c6a5500154ce783b45c
public interface DAO {
	
	// The contract we make for the information that
	// we will need to send to and receive from the data source
	
	// addUser
	// editUser - change fn, ln, email, PW, or balance
	// getuser
<<<<<<< HEAD
	
	public void addUser(User user);
	
	public void editUser(User user);
	
	public ArrayList<User> getAllUsers();
	
	public ArrayList<User> getUser(int id);
	
	public int getUserID(String fn, String ln);
	
	public int getNextID();
	
	public void updateID(String id);
	
	public void deleteFile();
}
=======
}
>>>>>>> a3d401426b647d7925ad2c6a5500154ce783b45c

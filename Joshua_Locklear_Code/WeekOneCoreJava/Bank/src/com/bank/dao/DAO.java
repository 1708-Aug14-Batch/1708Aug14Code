package com.bank.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.pojos.User;

public interface DAO {
	
	// The contract we make for the information that
	// we will need to send to and receive from the data source
	
	// addUser
	// editUser - change fn, ln, email, PW, or balance
	// getuser
	void addUser(User user);
	//void deleteUser(User user);
	List<User> readUsers();
	void rewriteUsers(List<User> users);
}

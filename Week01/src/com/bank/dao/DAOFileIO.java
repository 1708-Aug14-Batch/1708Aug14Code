package com.bank.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.pojos.User;

/**
 * Implements the methods specified by its super interface.
 * @author will underwood
 *
 */
public class DAOFileIO implements DAO {
	
	private final String FILE_NAME = "src/com/bank/data/users.txt";
	//private ArrayList<User> allUsers;

	@Override
	public void createUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			String fileText = "";
			//fileText += user.getId() + ":";
			fileText += user.getFirstName() + ":";
			fileText += user.getLastName() + ":";
			fileText += user.getUsername() + ":";
			fileText += user.getPassword() + ":";
			fileText += user.getBalance() + "\n";
			writer.write(fileText);
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public ArrayList<User> readAllUsers() {
		ArrayList<User> allUsers = new ArrayList<User>();
		try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			User temp = new User();
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] data = line.split(":");
				//temp.setId(Integer.parseInt(data[0]));
				temp.setFirstName(data[0]);
				temp.setLastName(data[1]);
				temp.setUsername(data[2]);
				temp.setPassword(data[3]);
				temp.setBalance(new BigDecimal(Double.parseDouble(data[4])));
				allUsers.add(temp);
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public void updateUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		ArrayList<User> allUsers = this.readAllUsers();
		User userToEdit = null;
		for(User currentUser : allUsers) {
			if (currentUser.getUsername().equals(user.getUsername())) {
				userToEdit = currentUser;
				break;
			}
		}
		this.eraseAllUserData();
		if(allUsers.remove(userToEdit)){
			allUsers.add(user);
		}
		this.rewriteAllUserData(allUsers);
	}
	
	private void eraseAllUserData() {
		try {
			PrintWriter printer = new PrintWriter(FILE_NAME);
			printer.write("");
			printer.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}

	private void rewriteAllUserData(ArrayList<User> allUsers) {
		for(User currentUser : allUsers) {
			this.createUser(currentUser);
		}
	}

	@Override
	public void destroyUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null");
		}
		ArrayList<User> allUsers = this.readAllUsers();
		User userToRemove = null;
		for(User currentUser : allUsers) {
			if (user.getUsername().equals(currentUser.getUsername())) {
				userToRemove = currentUser;
				break;
			}
		}
		allUsers.remove(userToRemove);
		this.eraseAllUserData();
		this.rewriteAllUserData(allUsers);
	}

}

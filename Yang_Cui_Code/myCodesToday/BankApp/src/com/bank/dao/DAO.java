package com.bank.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.pojos.User;

public interface DAO {
	//the contract we make for the information that we will need to send to and receive from the data source
	
	//getUser
	//addUser
	//editUSer - change firstname, lastname, email, PW, or balance
	//deleteUser
	
	public User getUser(int id);
	public void addUser(String id, String firstname, String lastname, String email, String password, String balance);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User changeBalance(User user, int amount, boolean deposit);
	
	public User authentication(int id, String password);
	public int userIDgeneration();
	
	public void writeUser(User user);
	public void writeUser(ArrayList<User> users);
	public ArrayList<User> readUser();
}

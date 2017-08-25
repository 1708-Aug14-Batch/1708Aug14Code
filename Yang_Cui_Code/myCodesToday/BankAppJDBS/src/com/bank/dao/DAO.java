package com.bank.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.User;

public interface DAO {
	//the contract we make for the information that we will need to send to and receive from the data source
	
	//getUser
	//addUser
	//editUSer - change firstname, lastname, email, PW, or balance
	//deleteUser
	
	public User getUser(int id);
	public int addUser(String fn, String ln, String email, String pwd);
	public int updateUser(User user);
	public void deleteUser(User user);
	public User changeBalance(User user, int amount, boolean deposit);
	public int addAccount(User u, int typeId);
	
	public User authentication(int id, String password);
	public ArrayList<User> getAllUser();
}

package com.revature.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.revature.pojo.Account;
import com.revature.pojo.AccountType;
import com.revature.pojo.User;

public interface DAO {
	//the contract we make for the information that we will need to send to and receive from the data source
	
	//getUser
	//addUser
	//editUSer - change firstname, lastname, email, PW, or balance
	//deleteUser
	
	public User getUser(int id);
	public int addUser(String fn, String ln, String email, String pwd);
	public int updateUser(User user);
	public int deleteUser(User user);
	public User authentication(int id, String password);
	public ArrayList<User> getAllUser();
	
	public Account changeBalance(Account acc);
	public int addAccount(User user, int typeId);
	public int closeAccount(Account acc);
	public ArrayList<Account> getAccount(User user);
	public ArrayList<Account> getAllAccount();
	public Account getAnAccount(int id);
	
	public AccountType getAccountType(int id);
	public ArrayList<AccountType> getAllAccountType();
	public boolean accountVarify(User user, int accID);
}

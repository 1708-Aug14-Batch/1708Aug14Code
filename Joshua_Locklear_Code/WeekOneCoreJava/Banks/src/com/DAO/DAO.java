package com.DAO;

	import java.util.ArrayList;

	import com.pojos.Account;
	import com.pojos.User;

	public interface DAO {
		
		int addUser(User user);
		User getUser(int id);
		User getUser(String usr, String pwd);
		void updateUser(User user);
		void deleteUser(User user);
		
		int addAccount(int userID, int typeID);
		Account getAccount(int accountID);
		ArrayList<Account> getAccounts(int userID);
		void updateAccount(Account account);
		void deleteAccount(Account account);
		
	}

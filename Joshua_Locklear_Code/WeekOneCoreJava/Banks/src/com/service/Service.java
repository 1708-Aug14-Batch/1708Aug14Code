package com.service;
import java.math.BigDecimal;
//import java.math.BigDecimal;
import java.util.ArrayList;

import com.DAO.DAO;
import com.DAO.DAOImpl;
//import com.DAO.DABDAO;
import com.pojos.Account;
import com.pojos.User;

	public class Service {

		private DAO dao = new DAOImpl();
		public Service(){
			dao = new DAOImpl();
		}
		public User addUser(User user){
			int id  = dao.addUser(user);
			user.setId(id);
			return user;
		}
		public User getUser(int id) {
			User user = dao.getUser(id);
			return user;
		}
		public User getUser(String username, String password){
			User user = dao.getUser(username, password);
			//return null if none found
			return user;
		}
		public void updateUser(User user){
			//get user from all users, then change info, then rewrite
			dao.updateUser(user);
		}
		public ArrayList<Account> getAccounts(int userid){
			return dao.getAccounts(userid);
		
		}
		public Account withdraw(Account account, BigDecimal x){

			account.setBalance(account.getBalance().subtract(x));
			dao.updateAccount(account);
			return account;
		}
		//return Account with updated balance
		public Account deposit(Account account, BigDecimal x){
			account.setBalance(account.getBalance().add(x));
			dao.updateAccount(account);
			return account;
		}
		public int addAccount(Account account){
			int id = dao.addAccount(account.getUserID(), account.getTypeID());
			return id;
		}
		public void updateAccount(Account account){
			dao.updateAccount(account);
		}
		public void removeUser(User user){
			dao.deleteUser(user);
		}
		public void removeAccount(Account account){
			dao.deleteAccount(account);
		}
		
	}
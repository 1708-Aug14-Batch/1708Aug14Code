package com.bank.service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.dao.DAO;
import com.bank.dao.TextDAO;
import com.bank.pojo.User;

public class Service {

	/*
	 * The logic before the information is passed to DAO.
	 * Functionality with the user.
	 * 
	 * addUser
	 * updateUser
	 * deleteUser
	 * 
	 */

	private DAO dao; 
	private List<User> users;

	public Service(){
		dao = new TextDAO();
		users = dao.getUsers();
	}

	/*
	 * add a new user to users if username is available
	 */
	public User addUser(User user){
		for (User u : users) {
			if(u.getUsername().equals(user.getUsername())) {
				System.out.println("Username taken");
				return null;
			}
		}
		users.add(user);
		dao.addUser(user);
		return user;
	}
	
	/*
	 * get the user with a particular id
	 */
	public User getUser(int id) {
		for (User user : users) {
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	/*
	 * find user with given username and password
	 * return user
	 */
	public User getUser(String username, String password){
		for (User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		//return null if none found
		return null;
	}
	
	/*
	 * Function to find a new unique id
	 */

	public int getNewUserId(){
		int highest = 0;
		for (User user : users) {
			if(user.getId() > highest) highest = user.getId();
		}
		return highest + 1;
	}
	
	/*
	 * update info functions
	 */

	public void updateFirstName(User user, String fn){
		//get user from all users, then change info, then rewrite
		User updateUser = users.get(users.indexOf(user));
		updateUser.setFirstname(fn);
		dao.rewriteUsers(users);
	};
	public void updateLastName(User user, String ln){
		//get user from all users, then change info, then rewrite
		User updateUser = users.get(users.indexOf(user));
		updateUser.setLastname(ln);
		dao.rewriteUsers(users);
	};
	public void updateUsername(User user, String username){
		//get user from all users, then change info, then rewrite
		User updateUser = users.get(users.indexOf(user));
		updateUser.setUsername(username);
		dao.rewriteUsers(users);
	};
	public void updatePassword(User user, String password){
		//get user from all users, then change info, then rewrite
		User updateUser = users.get(users.indexOf(user));
		updateUser.setPassword(password);
		dao.rewriteUsers(users);
	};
	
	//return new User with updated balance
	public User withdraw(User user, BigDecimal x){
		//get user from all users, then change info, then rewrite
		User updateUser = users.get(users.indexOf(user));
		updateUser.setBalance(updateUser.getBalance().subtract(x));
		dao.rewriteUsers(users);
		return updateUser;
	}
	//return new User with updated balance
	public User deposit(User user, BigDecimal x){
		//get user from all users, then change info, then rewrite
		User updateUser = users.get(users.indexOf(user));
		updateUser.setBalance(updateUser.getBalance().add(x));
		dao.rewriteUsers(users);
		return updateUser;
	}

	/*
	 * Remove user from data
	 */
	
	public void remove(User user){
		users.remove(user);
		dao.rewriteUsers(users);
	}
}

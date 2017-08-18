package com.bank.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.DAO;
import com.bank.dao.DaoTextImpl;
import com.bank.pojos.User;

public class Service {
	
	//DAO dao = new DaoTextImpl();
	static DaoTextImpl io;
	static User login;
	static Scanner scan = new Scanner(System.in);
	private DAO dao;
	private List<User> users;
	
	public Service(){
		dao = new DaoTextImpl();
		users = dao.readUsers();
	}
	public User addUser(User user){
		users.add(user);
		dao.addUser(user);
		return user;
	}
//	public User deleteUser(User user){
//		users.delete(user);
//		dao.deleteUser(user);
//	}
//	public User getUser(String email, String pass){
//		
//		for (User user : users) {
//			if(user.getEmail().equals(email) && user.getPassword().equals(pass)){
//				return user;
//			}
//		}
//		return null;
//		
//	}
	public void removeUser(User user){
		users.remove(user);
		dao.rewriteUsers((ArrayList<User>) users);
	}
	public User getUser(String email, String password){
		for (User user : users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(password)){
				return user;
			}
		}
		//return null if none found
		return null;
	}
	public User withdrawFunds(User user, double y){
		User updateUser = users.get(users.indexOf(user));
//		if(y > updateUser.getBalance() ){
//			System.out.println("Insufficient Funds");
//			//runBank.userWithdraw();
//			
//		}else{
		updateUser.setBalance(updateUser.getBalance()-y);
		dao.rewriteUsers((List<User>) users);
		return updateUser;
	}
	public User depositFunds(User user,double userFunds){
		User updateUser = users.get(users.indexOf(user));
		updateUser.setBalance(updateUser.getBalance() + userFunds);
		dao.rewriteUsers((List<User>) users);
		return updateUser;
	}
//	public void change(int input){
//		switch(input){
//		case 1: {
//			System.out.println("What is your new First name: ");
//			String fn = scan.nextLine();
//			login.setFirstname(fn);
//			}
//		
//		break;
//		case 2: {
//			System.out.println("What is your new Last name: ");
//			String ln = scan.nextLine();
//			login.setLastname(ln);
//			}
//		break;
//		case 3: {
//			System.out.println("What is your new Email: ");
//			String em = scan.nextLine();
//			login.setEmail(em);
//			}
//		break;
//		case 4: {
//			System.out.println("What is your new password: ");
//			String ps = scan.nextLine();
//			login.setPassword(ps);
//			}
//		break;
//		}
//	}
	public void updateFirstName(User user, String fn){
		User updateUser = users.get(users.indexOf(user));
		updateUser.setFirstname(fn);
		dao.rewriteUsers((List<User>) users);
	};
	public void updateLastName(User user, String ln){
		User updateUser = users.get(users.indexOf(user));
		updateUser.setLastname(ln);
		dao.rewriteUsers((List<User>) users);
	};
	public void updateEmail(User user, String email){
		User updateUser = users.get(users.indexOf(user));
		updateUser.setEmail(email);
		dao.rewriteUsers((List<User>) users);
	};
	public void updatePassword(User user, String password){
		User updateUser = users.get(users.indexOf(user));
		updateUser.setPassword(password);
		dao.rewriteUsers((List<User>) users);
	};
	public void display(String userInput){
		if(userInput == "yes")
			System.out.println("Balance is " + login.getBalance());
	}
	
	//login functionality
	//what do you want to do functionality
	// 

}
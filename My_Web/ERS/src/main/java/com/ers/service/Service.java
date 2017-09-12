package com.ers.service;

import java.util.List;

import com.ers.dao.DatabaseDao;
import com.ers.pojos.Request;
import com.ers.pojos.User;

public class Service {

	public static final int MAX_SESSION_INACTIVE_INTERVAL = 60 * 10;
	public static final String USER_ATTR = "user";

	public static User getCurrentUser() {
		return currentUser;
	}
	
	public static String addUser(User user) {
		if (hasUser(user.getEmail())) return "User already associated with that email";
		
		int userId = dao.addUser(user);
		
		if (userId == -1) {
			return "An unknown error occurred creating user";
		}
		
		user.setUserId(userId);
		
		return null;
	}

	public static boolean updateFirstName(String firstName) {
		
		if (dao.setFirstName(currentUser.getUserId(), firstName)) {
			currentUser.setFirstName(firstName);
			return true;
		}
		return false;
	}

	public static boolean updateLastName(String lastName) {
		
		if (dao.setLastName(currentUser.getUserId(), lastName)) {
			currentUser.setLastName(lastName);
			return true;
		}
		return false;
	}

	public static boolean updatePassword(String password) {
		
		return dao.setPassword(currentUser.getUserId(), password);
	}
	
	public static String loginUser(String email, String password) {
		if ("".equals(email) || "".equals(password) || email == null || password == null) return "You must enter an email and password";
		
		if (!hasUser(email)) return "There is no user associated with that email";
		
		User user = dao.getUser(email, password);
		
		if (user != null) {
			currentUser = user;
			return null;
		}
		else {
			return "Incorrect email or password";
		}
	}
	
	public static List<Request> getUserRequests(User user) {
		
		return dao.getUserRequests(user.getUserId());
	}
	
	public static List<Request> getPendingRequests(User user) {
		
		return dao.getPendingRequests(user.getUserId());
	}
	
	public static List<Request> getResolvedRequests(User user) {
		
		return dao.getResolvedRequests(user.getUserId());
	}
	
	public static List<Request> getAllUserRequests() {
		
		return dao.getAllUserRequests();
	}
	
	public static List<Request> getAllPendingRequests() {
		
		return dao.getAllPendingRequests();
	}
	
	public static List<Request> getAllResolvedRequests() {
		
		return dao.getAllResolvedRequests();
	}
	
	private static boolean hasUser(String email) {
		if (email == null) return false;
		return dao.hasUser(email);
	}
	
	private static User currentUser = null;	
	private static DatabaseDao dao = new DatabaseDao();
}

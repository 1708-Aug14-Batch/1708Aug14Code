package com.revature.andy.session;

import java.util.HashSet;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.User;
import com.revature.andy.service.Service;

// Pseudo Singleton
public class PseudoSession {
	
	private static User currentUser = null;

	static boolean isLoggedIn = false;
	static DAOImplementation dao = new DAOImplementation();
	
	static public int login(String email, String pwd) {
		currentUser = dao.getUser(email, pwd);
		if(currentUser != null && currentUser.getUserID()!=0){
			isLoggedIn = true;
			return 1;
		}else {
			return validateLogin(email);
		}
	}
	// Validate User
	
	static public int validateLogin(String email) {
		
		HashSet<User> users = dao.getUsers();
		
		for(User x:users) {
			if(x.getEmail().equalsIgnoreCase(email)) {
				return 2;
			}
		}
		return 0;
		}
	
	static public void logout() {
		isLoggedIn = false;
		currentUser = null;
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		PseudoSession.currentUser = currentUser;
	}
	
	public static boolean getIsLoggedIn(){
		return isLoggedIn;
	}
	
}

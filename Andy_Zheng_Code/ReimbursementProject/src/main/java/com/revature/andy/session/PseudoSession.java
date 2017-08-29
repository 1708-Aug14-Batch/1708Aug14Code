package com.revature.andy.session;

import java.util.HashMap;

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
			return validatePair(email);
		}
	}
	// Validate User
	
	static public int validatePair(String email) {
		
		HashMap<Integer, String> idEmail = dao.getIDEmail();
		
		for(Integer x:idEmail.keySet()) {
			if(idEmail.get(x).equalsIgnoreCase(email)) {
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

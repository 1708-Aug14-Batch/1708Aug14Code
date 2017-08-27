package com.revature.andy.session;

import com.revature.andy.dao.DAOImplementation;
import com.revature.andy.pojos.User;

// Pseudo Singleton
public class PseudoSession {
	
	private static User currentUser = null;

	static boolean isLoggedIn = false;
	
	static DAOImplementation dao = new DAOImplementation();
	
	static public boolean login(String email, String pwd) {
		currentUser = dao.getUser(email, pwd);
		if(currentUser != null && currentUser.getUserID()!=0){
			isLoggedIn = true;
			return true;
		}else {
			return false;
		}
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

/**
 * 
 */
package com.revature.service;

import com.revature.dao.RUserDAO;
import com.revature.model.*;

/**
 * @author Will Underwood
 *
 */
public class ReimbursementService {
	
	private RUserDAO userDAO;
	
	/**
	 * Makes a new Service for managing bank accounts
	 * @precondition None.
	 * @param None.
	 * @postcondition A new Service was created
	 */
	public ReimbursementService() {
		this.userDAO = new RUserDAO();
	}
	
	public boolean checkUserExists(String email) {
		this.errorCheckEmail(email);
		return (this.userDAO.read(email) != null);
	}

	private void errorCheckEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Email cannot be null");
		}
	}
	
	public boolean validateUserCredentials(String email, String password) {
		this.errorCheckEmail(email);
		this.errorCheckPassword(password);
		RUser user = this.userDAO.read(email);
		return password.equals(user.getPassword());
	}

	private void errorCheckPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
	}
	
	public RUser getUser(String email) {
		this.errorCheckEmail(email);
		return this.userDAO.read(email);
	}
}

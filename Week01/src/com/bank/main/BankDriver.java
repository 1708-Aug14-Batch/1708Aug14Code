package com.bank.main;

import com.bank.service.Service;

/**
 * file <-> DAO <-> Service (business object) <-> Main
 * @author will underwood
 *
 * Requirements:
 * 	- login
 * 	- create account
 *  - logout
 *  - withdraw or deposit funds
 *  - view my account balance
 *  - edit my information
 *  - delete account
 *  
 * Tech specs:
 * 	- core java
 *  - file io
 */
public class BankDriver {
	
	/**
	 * Starts the application.
	 * @param args - not used
	 */
	public static void main(String[] args) {
		Service service = new Service();
		service.displayInitialMenu();
	}
	
}

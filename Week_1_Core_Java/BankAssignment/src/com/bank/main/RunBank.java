package com.bank.main;

import com.bank.service.Service;

public class RunBank {

		
	public static void main(String[] args) {
		
		/*
		 * My bank application has a normal user and a system admin mode depending on which login information you use.
		 * The System Admin can Add Users. The email is: sysadmin@bank.com password: admin
		 * The Normal User can access their account information and make withdrawals/deposits. Both Users can also log out.
		 * 
		 */
		
		
		Service bankService = new Service(); //Starts the banking program.
		bankService.login();

	}


	
	/*
	 * Requirements: As a user I can,
	 * - login
	 * - create an account
	 * - logout
	 * - withdraw or deposit funds
	 * - view my* account balance
	 * - edit my* information
	 * 
	 * Tech Specs
	 * - core java, file i/o
	 */
}

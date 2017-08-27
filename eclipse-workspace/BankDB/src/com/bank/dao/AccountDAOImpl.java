package com.bank.dao;

import java.util.ArrayList;

import com.bank.model.Account;

/**
 * Concrete implementation of interface AccountDAO.
 * @author Will Underwood
 */
public class AccountDAOImpl implements AccountDAO<Account> {

	/**
	 * Adds a new user account to the database.
	 * @precondition Account cannot be null
	 * @param account - Account whose details will be placed in the database
	 * @return The number of rows successfully added. Should be 1.
	 */
	@Override
	public int createAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns all Accounts in database
	 * @precondition None
	 * @param None
	 * @return A collection of all Accounts
	 */
	@Override
	public ArrayList<Account> readAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns a single account from the database.
	 * @precondition ID cannot be less than 1
	 * @param ID - ID of the desired Account
	 * @return A single Account
	 */
	@Override
	public Account readAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Edits the data of the specified account.
	 * @precondition Account cannot be null
	 * @param Account - The account whose data will be edited
	 * @return The number of rows affected. Should be one.
	 */
	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Disables the account whose ID is specified
	 * @precondition ID cannot be less than 1
	 * @param ID - The ID of the account to be disabled
	 * @return - The number of rows affected. Should be 1.
	 */
	@Override
	public int disableAccount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

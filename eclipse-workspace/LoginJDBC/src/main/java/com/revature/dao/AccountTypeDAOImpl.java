package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.AccountType;
import com.revature.util.ConnectionSingleton;

/**
 * Concrete implementation of AccountTypeDAO.
 * @author Will Underwood
 */
public class AccountTypeDAOImpl implements AccountTypeDAO<AccountType> {

	/**
	 * Adds a new account type to the database.
	 * @precondition AccountType cannot be null
	 * @param accountType - the account type
	 * @return The number of rows inserted. Should be 1.
	 */
	@Override
	public int createAccountType(AccountType accountType) {
		try(Connection conn = ConnectionSingleton.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Returns all account types.
	 * @precondition None
	 * @param None
	 * @return A collection of all account types
	 */
	@Override
	public ArrayList<AccountType> readAllAccountTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the account type whose ID is specified
	 * @precondition ID cannot be less than 1
	 * @param id - the ID of the desired account type
	 * @return - The account type whose ID was specified
	 */
	@Override
	public AccountType readAccountType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Edits the data of the given account type
	 * @precondition AccountType cannot be null
	 * @param accountType - the account type
	 * @return The number of rows affected. Should be 1.
	 */
	@Override
	public int updateAccountType(AccountType accountType) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Deletes the account type whose ID is specified.
	 * @preconidition ID cannot be less than 1
	 * @param id - the ID of the account type to be deleted
	 * @return the number of rows deleted. Should be 1.
	 */
	@Override
	public int deleteAccountType(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}

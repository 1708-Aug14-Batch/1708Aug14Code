package com.revature.dao;

import java.util.ArrayList;

/**
 * Provides CRUD operations for AccountType objects.
 * @author Will Underwood
 * @param <AccountType> These operations can only be used with AccountType objects.
 */
public interface AccountTypeDAO<AccountType> {

	int createAccountType(AccountType accountType);

	ArrayList<AccountType> readAllAccountTypes();

	AccountType readAccountType(int id);

	int updateAccountType(AccountType accountType);

	int deleteAccountType(int id);

}

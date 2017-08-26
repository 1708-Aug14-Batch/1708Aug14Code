package com.bank.dao;

import java.util.ArrayList;

public interface AccountTypeDAO<AccountType> {

	int createAccountType(AccountType accountType);

	ArrayList<AccountType> readAllAccountTypes();

	AccountType readAccountType(int id);

	int updateAccountType(AccountType accountType);

	int disableAccountType(int id);

}

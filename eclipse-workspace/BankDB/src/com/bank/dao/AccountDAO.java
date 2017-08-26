package com.bank.dao;

import java.util.ArrayList;

public interface AccountDAO<Account> {

	int createAccount(Account account);

	ArrayList<Account> readAllAccounts();

	Account readAccount(int id);

	int updateAccount(Account account);

	int disableAccount(int id);

}

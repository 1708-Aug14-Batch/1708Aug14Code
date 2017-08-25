package com.ex.dao;

import java.util.ArrayList;

import com.bank.pojos.*;

public interface DaoSql {
	
	// Person
	public Integer createPerson(Person per);
	public Person readPerson(int SSN);
	public boolean readPerson(String email);
	// change any person's field except their primary keys
	public boolean updatePerson(Person per);
	// A deleted person is merely marked as deceased unless erase = true
	public boolean deletePerson(String SSN, boolean erase);
	public ArrayList<Person> readAllPersons();
	
	// BankUser
	public Integer createBankUser(BankUser guy);
	public BankUser readBankUser(String username);
	public BankUser readBankUser(int userId);
	public boolean updateBankUser(BankUser guy);
	// A deleted User merely has their account marked as deleted unless erase = true
	public boolean deleteBankUser(int userId, boolean erase);
	public ArrayList<BankUser> readAllUsers();	
	
	/* TODO
	// Clerk
	create
	read
	update
	delete
	*/
	
	// Account
	public Integer createAccount(Account acc);
	public Person readAccount(int accountId);
	// change any person's field except their primary keys
	public boolean updateAccount(Account acc);
	// A deleted person is merely marked as deceased unless erase = true
	public boolean deleteAccount(int accountId, boolean erase);
	public ArrayList<Person> readAllAccounts();
	
	
}

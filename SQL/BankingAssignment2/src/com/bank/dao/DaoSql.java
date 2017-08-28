package com.bank.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.pojos.Account;
import com.bank.pojos.BankUser;
import com.bank.pojos.Person;
import com.bank.pojos.Account.accountLevel;
import com.bank.pojos.Account.accountType;

public interface DaoSql {
	
	// Person
	public Person createPerson(int SSN, String firstName, String lastName, LocalDate birthDate);
	public Person readPerson(int SSN);
	// change any person's field except their uniquely identifying keys
	public boolean updatePerson(int SSN, Person per);
	// A deleted person is merely marked as deceased
	public boolean deletePerson(int SSN);
	public ArrayList<Person> readAllPersons();
	
	// BankUser
	public BankUser createBankUser(Person per, String username, String password);
	public BankUser readBankUser(int userId);
	// change any BankUser's fields except their uniquely identifying keys
	public boolean updateBankUser(int userId, BankUser guy);
	// A deleted User merely has their account marked as deleted
	public boolean deleteBankUser(int userId);
	public ArrayList<BankUser> readAllBankUsers();	
	
	/* TODO
	// Clerk
	create
	read
	update
	delete
	*/
	
	// Account
	public Account createAccount(BankUser guy, BigDecimal balance, accountType type, accountLevel level);
	public Account readAccount(int accountId);
	// change any account's field except their uniquely identifying keys
	public boolean updateAccount(int accountId, Account acc);
	// A deleted Account is merely marked as deleted
	public boolean deleteAccount(int accountId);
	public ArrayList<Account> readAllAccounts();
	public ArrayList<Account> readAllAccounts(int userId);
	
}
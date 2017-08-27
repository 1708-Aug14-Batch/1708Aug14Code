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
	public Person readPerson(String email);
	// change any person's field except their primary keys
	public boolean updatePerson(Person per);
	// A deleted person is merely marked as deceased unless erase = true
	public boolean deletePerson(String SSN, boolean erase);
	public ArrayList<Person> readAllPersons();
	
	// BankUser
	public BankUser createBankUser(Person per, String username, String password);
	public BankUser readBankUser(String username);
	public BankUser readBankUser(int userId);
	public boolean updateBankUser(BankUser guy);
	// A deleted User merely has their account marked as deleted unless erase = true
	public boolean deleteBankUser(int userId, boolean erase);
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
	// change any person's field except their primary keys
	public boolean updateAccount(Account acc);
	// A deleted person is merely marked as deceased unless erase = true
	public boolean deleteAccount(int accountId, boolean erase);
	public ArrayList<Account> readAllAccounts();
	
	
}

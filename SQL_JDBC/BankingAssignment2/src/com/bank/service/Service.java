package com.bank.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bank.dao.*;
import com.bank.pojos.Account;
import com.bank.pojos.Account.accountLevel;
import com.bank.pojos.Account.accountType;
import com.bank.pojos.Person;
import com.bank.pojos.BankUser;

// TODO this class is where I will checking updating variables to make
// sure they are correct. i.e. valid emails, untaken username, etc
//		ensure correctness on create as well as on update
// TODO add methods to read particular values from database rather than always getting a list of every _____

// FIXME rather than using so many daoImpl.readAllXXX() methods, make more methods in the DaoSqlImpl that are not in the DaoSql interface

public class Service {

	DaoSqlImpl daoImpl = new DaoSqlImpl();

	private static long maxBalance = 10000000000L;

	public BankUser validateBankUser(String username, String password) {
		if (username == null || password == null)
			return null;

		username = username.toLowerCase();

		BankUser guy = daoImpl.readBankUser(username);

		if (guy == null)
			return null;

		if (guy.getPassword().equals(password))
			return guy;
		else return null;
	}

	// FIXME an email does not need to end with .com, could be .org or others
	//		Change to a regular expression using the method .matches()
	public boolean isEmailValid(String email) {

		if (email.contains("@") && email.contains(".com"))
			if (email.lastIndexOf('@') < email.lastIndexOf(".com"))
				return true;

		System.out.println("Email addresses must contain a valid domain such as \"something@something.com\"");
		return false;
	}

	public boolean isEmailAvailable(String email) {

		ArrayList<Person> peopleList = daoImpl.readAllPersons();

		if (peopleList.size() == 0)
			return true;

		for (Person per : peopleList)
			if (per.getEmail() != null && per.getEmail().equals(email)) {
				System.out.println("Email unavailable");
				return false;
			}

		return true;
	}

	private boolean isUsernameAvailable(String username) {
		username = username.toLowerCase();

		ArrayList<BankUser> userList = daoImpl.readAllBankUsers();

		for (BankUser guy : userList) {
			if (guy.getUsername().equals(username))
				return false;
		}

		return true;

	}

	// Attempts to create a person unless a person already exists with
	// the given email. Returns the person object either way
	// An email must be supplied but it can be an empty string where it will not
	// be checked for uniqueness
	public Person tryCreatePerson(String firstName, String lastName, String email, LocalDate birthDate) {

		Person per = daoImpl.readPerson(email);

		// If person does not exist yet
		if (per == null) {
			per = daoImpl.createPerson(firstName, lastName, email, birthDate, false);
		}
		
		return per;
	}

	// Tries to create a new user
	// Fails if the uername is not unique or if the given person is already a user
	public BankUser tryCreateBankUser(Person per, String username, String password, accountLevel level) {
		username = username.toLowerCase();

		// Check that username is unique
		if (!isUsernameAvailable(username)) {
			System.out.println("That username is already taken.");
			return null;
		}

		if (personIsAUser(per)) {
			System.out.println("That person is already a bank user");
			return null;
		}

		return daoImpl.createBankUser(per, username, password);
	}

	// Tries to create a new account
	public Account tryCreateAccount(BankUser guy, BigDecimal balance, accountType type, accountLevel level) {

		return daoImpl.createAccount(guy, balance, type, level);
	}

	// Updates a person with the new person object.
	// Matches the old person with the new by personId
	// All non-final fields of the person object
	// will be updated
	public boolean updatePerson(int personId, Person per) {

		// If the person-to-be updated on file is deceased, their records cannot be updated
		if (daoImpl.readPerson(per.getPersonId()).isDeceased()) {
			System.out.println("That person is deceased and their records cannot be updated");
			return false;
		}

		return daoImpl.updatePerson(personId, per);

	}

	public boolean updateBankUser(int userId, BankUser guy) {

		return daoImpl.updateBankUser(userId, guy);

	}

	public boolean updateAccount(int accountId, Account acc) {

		if (acc.getBalance().longValue() >= maxBalance) {
			System.out.println("Deposit failed. An account cannot have more than $" + maxBalance);
			return false;
		}

		// If the account is deleted, the records cannot be updated
		if (daoImpl.readAccount(accountId).isDeleted()) {
			return false;
		}

		return daoImpl.updateAccount(accountId, acc);

	}	

	public BankUser getBankUser(int userId) {

		return daoImpl.readBankUser(userId);
	}

	public Person getPerson(int personId) {

		return daoImpl.readPerson(personId);
	}

	public ArrayList<Account> getAccounts(int userId) {

		return daoImpl.readAllAccounts(userId);
	}

	public BigDecimal getAccountBalance(int accountId) {
		Account acc = daoImpl.readAccount(accountId);

		if (acc.isDeleted()) {
			System.out.println("Nothing can be withdrawn as this account has been deleted");
			return null;
		}

		return acc.getBalance();

	}

	public boolean deleteAccount(int accountId) {

		return daoImpl.deleteAccount(accountId);

	}

	private boolean personIsAUser(Person per) {

		ArrayList<BankUser> userList = daoImpl.readAllBankUsers();

		for (BankUser guy : userList)
			if (guy.getPersonId() == (per.getPersonId()))
				return true;

		return false;
	}

}
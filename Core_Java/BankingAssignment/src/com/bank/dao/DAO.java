package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Clerk;
import com.bank.pojos.Person;
import com.bank.pojos.Transaction;
import com.bank.pojos.User;

public interface DAO {

	// The contract we make for the information that
	// we will need to send to and receive from the data source

	public boolean createPerson(Person per);
	public Person readPerson(String SSN);
	// change any person's field except their primary keys
	public boolean updatePerson(Person per);
	// A deleted person is merely marked as deceased unless erase = true
	public boolean deletePerson(String SSN, boolean erase);
	public ArrayList<Person> readAllPersons();

	public boolean createUser(User guy);
	public User readUser(String username);
	public boolean updateUser(User guy);
	// A deleted User merely has their account marked as deleted unless erase = true
	public boolean deleteUser(String username, boolean erase);
	public ArrayList<User> readAllUsers();	

	public boolean createClerk(Clerk cler);
	public Clerk readClerk(int employeeId);
	public boolean updateClerk(Clerk cler);
	// A deleted clerk is merely marked as no longer hired unless erase = true
	public boolean deleteClerk(int employeeId, boolean erase);
	public ArrayList<Clerk> readAllClerks();
	
	public boolean createTransaction(Transaction tran);
	public ArrayList<Transaction> readAllTransactions();

}

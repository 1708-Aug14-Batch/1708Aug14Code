package com.bank.dao;

import java.util.ArrayList;

import com.bank.pojos.Clerk;
import com.bank.pojos.Person;
import com.bank.pojos.User;

public interface DAO {

	// The contract we make for the information that
	// we will need to send to and receive from the data source

	public boolean createPerson(Person per);
	public Person readPerson(String SSN);
	// change any person's field except their primary keys
	public boolean updatePerson(Person per);
	public boolean deletePerson(String SSN, boolean erase);
	public ArrayList<Person> readAllPersons();

	public boolean createUser(User guy);
	public User readUser(String username);
	public boolean updateUser(User guy);
	// User is not truly deleted, merely marked as deleted
	public boolean deleteUser(String username, boolean erase);
	public ArrayList<User> readAllUsers();	

	public boolean createClerk(Clerk cler);
	public Clerk readClerk(int employeeId);
	public boolean updateClerk(Clerk cler);
	// User is not truly deleted, merely marked as no longer hired
	public boolean deleteClerk(int employeeId, boolean erase);
	public ArrayList<Clerk> readAllClerks();

}

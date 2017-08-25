package com.bank.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.dao.DaoTextImpl;
import com.bank.pojos.*;
import com.bank.pojos.Account.accountType;
import com.bank.service.Service;

public class BankTest {

	static DaoTextImpl daoImpl;
	static Service bankService;

	// Copy over all of the data sets for safekeeping
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	// Erase data created for the test
	// Restore the original data sets
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}
	
	Person per1, per2;
	Account acc;
	BankUser guy;
	Clerk cler;
	Transaction tran;

	@Before
	public void setUp() throws Exception {
		daoImpl = new DaoTextImpl();
		bankService = new Service();
		
		createObjects();
	}
	
	private void createObjects() {
		per1 = new Person("123456789", "first name", "last name");
		per1.setEmail("myEmail@mail.com");
		per2 = new Person("987654321", "second first name", "second last name");
		acc = new Account(per1, "user name", "pass word", accountLevel.GOLD, 1);
		guy = new BankUser(per1, acc);
		cler = new Clerk(per2, 1, "password");
		tran = new Transaction(null);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testService() {
		// FIXME test for: use delimiters in names and SSNs

		createObjects();
		
		// Creating multiple users or persons with the same credentials should yield only one user/person
		assertEquals(0, daoImpl.readAllPersons().size());
		assertEquals(0, daoImpl.readAllUsers().size());
		
		bankService.tryCreatePerson(per1.getSSN(), per1.getFirstName(), per1.getLastName(), per1.getEmail(), tran);
		bankService.tryCreatePerson(per1.getSSN(), per1.getFirstName(), per1.getLastName(), per1.getEmail(), tran);
		bankService.tryCreateUser(per1, acc.getUsername(), acc.getPassword(), acc.getType(), tran);
		bankService.tryCreateUser(per1, acc.getUsername(), acc.getPassword(), acc.getType(), tran);
		
		assertEquals(1, daoImpl.readAllPersons().size());
		assertEquals(1, daoImpl.readAllUsers().size());
		
		// try to create users with bad SSNs
		bankService.tryCreatePerson("asdf", "firstname", "lastname", "1email@mail.com", tran);
		assertEquals(1, daoImpl.readAllPersons().size());
		bankService.tryCreatePerson("12345678", "firstname", "lastname", "2email@mail.com", tran);
		assertEquals(1, daoImpl.readAllPersons().size());
		bankService.tryCreatePerson("1234567890", "firstname", "lastname", "3email@mail.com", tran);
		assertEquals(1, daoImpl.readAllPersons().size());
		bankService.tryCreatePerson("qwertyuio", "firstname", "lastname", "4email@mail.com", tran);
		assertEquals(1, daoImpl.readAllPersons().size());
		
		// try to create person with bad email address
		
		// try to create people with valid SSNs
		bankService.tryCreatePerson("76-567-3454", "firstname", "lastname", "5email@mail.com", tran);
		assertEquals(2, daoImpl.readAllPersons().size());
		bankService.tryCreatePerson("567567567", "firstname", "lastname", "6email@mail.com", tran);
		assertEquals(3, daoImpl.readAllPersons().size());
		
	}

	@Test
	public void testDaoTextImpl() {

		// Create
		daoImpl.createPerson(per1);
		daoImpl.createPerson(per2);
		daoImpl.createUser(guy);
		daoImpl.createClerk(cler);

		// Read
		assertEquals(2, daoImpl.readAllPersons().size());
		assertEquals(1, daoImpl.readAllUsers().size());
		assertEquals(1, daoImpl.readAllClerks().size());
		assertEquals(per1.toString(), daoImpl.readPerson(per1.getSSN()).toString());
		assertEquals(per2.toString(), daoImpl.readPerson(per2.getSSN()).toString());
		assertEquals(guy.toString(), daoImpl.readUser(guy.getAccount().getUsername()).toString());
		
		System.out.println(cler.toString());
		System.out.println(daoImpl.readClerk(cler.getEmployeeId()).toString());
		
//		assertEquals(cler.toString(), daoImpl.readClerk(cler.getEmployeeId()).toString());
		
		assertNull(daoImpl.readPerson("555555555"));
		assertNull(daoImpl.readUser("666666666"));
		assertNull(daoImpl.readClerk(777777777));

		// Update
		per1.setEmail("mynewemail@mail.com");
		per1.setLastName("new last name");
		per1.setDeceased(true);
		daoImpl.updatePerson(per1);
		per2.setEmail("anothernewemail@mail.com");
		daoImpl.updatePerson(per2);
		guy.getAccount().setCheckingBalance(new BigDecimal(1000));
		guy.getAccount().setPassword("new password");
		guy.getAccount().setDeleted(false);
		daoImpl.updateUser(guy);
		cler.setHourlyWage(18.85);
		daoImpl.updateClerk(cler);
		
		assertEquals(per1.toString(), daoImpl.readPerson(per1.getSSN()).toString());
		assertEquals(per2.toString(), daoImpl.readPerson(per2.getSSN()).toString());
		assertEquals(guy.toString(), daoImpl.readUser(guy.getAccount().getUsername()).toString());
//		assertEquals(cler.toString(), daoImpl.readClerk(cler.getEmployeeId()).toString());
		
		// Delete
		daoImpl.deletePerson(per1.getSSN(), false);
		daoImpl.deletePerson(per2.getSSN(), true);
		daoImpl.deleteUser(guy.getAccount().getUsername(), false);
		daoImpl.deleteClerk(cler.getEmployeeId(), false);
		assertEquals(1, daoImpl.readAllPersons().size());
		assertEquals(1, daoImpl.readAllUsers().size());
//		assertEquals(1, daoImpl.readAllClerks().size());
		assertTrue(daoImpl.readPerson(per1.getSSN()).isDeceased());
		assertNull(daoImpl.readPerson(per2.getSSN()));
		assertTrue(daoImpl.readUser(guy.getAccount().getUsername()).getAccount().isDeleted());
//		assertFalse(daoImpl.readClerk(cler.getEmployeeId()).isHired());
		
		daoImpl.deletePerson(per1.getSSN(), true);
		daoImpl.deleteUser(guy.getAccount().getUsername(), true);
//		daoImpl.deleteClerk(cler.getEmployeeId(), true);
		
		assertEquals(0, daoImpl.readAllPersons().size());
		assertEquals(0, daoImpl.readAllUsers().size());
//		assertEquals(0, daoImpl.readAllClerks().size());
		
	}

}

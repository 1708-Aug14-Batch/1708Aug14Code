package com.bank.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.dao.DaoSqlImpl;
import com.bank.pojos.Account;
import com.bank.pojos.BankUser;
import com.bank.pojos.Clerk;
import com.bank.pojos.Person;
import com.bank.service.Service;

public class BankTest {

	static DaoSqlImpl daoImpl;
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

	@Before
	public void setUp() throws Exception {
		daoImpl = new DaoSqlImpl();
		bankService = new Service();
		
		createObjects();
	}
	
	private void createObjects() {
		
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testService() {
		fail("Not implemented yet");
	}

	@Test
	public void testDaoTextImpl() {
		fail("Not implemented yet");
	}

}
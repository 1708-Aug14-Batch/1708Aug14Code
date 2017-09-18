package com.reimbursments.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reimbursments.DAO.DAOImpl;

public class JUnitTest {
	DAOImpl tester;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before method");
		tester = new DAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after method");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

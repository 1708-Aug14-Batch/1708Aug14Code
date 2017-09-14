package com.reimburse.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.reimburse.pojos.User;

public class DAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//User u = new User(23, rick, sanchez, rick@email.com, pass, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DAOImpl dao = new DAOImpl();
		User u = dao.getUserById(23);
		assertEquals(null, u);
	}}
package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.RUser;
import com.revature.model.Reimbursement;

public class ReimbursementTest {
	
	private RUser user = new RUser();
	private Reimbursement reimb = new Reimbursement();

	@Before
	public void setUp() throws Exception {
		user.setRUserID(1);
		user.setFirstName("Roger");
		user.setLastName("Wilco");
		user.setEmail("rwilco@mailinator.com");
		user.setPassword("123");
		user.setManager(false);
		
		reimb.setAmount(123.45);
		reimb.setDescription("Roger Wilco!");
		reimb.setReimbursementID(1);
		reimb.setStatusID(1);
		reimb.setSubmitterID(1);
	}

	@Test
	public void testGetUserID() {
		assertEquals(1, this.user.getRUserID());
	}
	
	@Test
	public void testGetUserFirstNameLastName() {
		assertEquals("Roger Wilco", this.user.getFirstName() + " " + this.user.getLastName());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("rwilco@mailinator.com", this.user.getEmail());
	}
	
	@Test
	public void testGetPassword() {
		assertEquals("123", this.user.getPassword());
	}
	
	@Test
	public void testIsManager() {
		assertFalse(this.user.isManager());
	}
	
	@Test
	public void testAmount() {
		assertEquals(123.45, this.reimb.getAmount(), 0.01);
	}
	
	@Test
	public void testDescription() {
		assertEquals("Roger Wilco!", this.reimb.getDescription());
	}
	
	@Test
	public void testReimbID() {
		assertEquals(1, this.reimb.getReimbursementID());
	}
	
	@Test
	public void testStatusID() {
		assertEquals(1, this.reimb.getStatusID());
	}
	
	@Test
	public void testSubmitterID() {
		assertEquals(1, this.reimb.getSubmitterID());
	}

}

package com.revature.q18;

import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {
	
	@Test
	public void hasUpperCaseTest() {
		ConcreteStrOps c = new ConcreteStrOps();
		assertTrue(c.hasUpperCase("Vladimir"));
		assertFalse(c.hasUpperCase("catcat cat"));
		assertTrue(c.hasUpperCase("81298hdhasudsdo8q89ydD"));
	}
	
	@Test
	public void toUpperCaseTest() {
		ConcreteStrOps c = new ConcreteStrOps();
		assertEquals("VLADIMIR", c.toUpperCase("vlAdImiR"));
		assertEquals("CAT", c.toUpperCase("cat"));
		assertNotEquals("cAT", c.toUpperCase("cAt"));
	}
	
	@Test
	public void toIntPlusTenTest() {
		ConcreteStrOps c = new ConcreteStrOps();
		assertEquals(20, c.toIntPlusTen("10"));
		assertEquals(-400, c.toIntPlusTen("-410"));
	}
	
	@Test(expected = NumberFormatException.class)
	public void toIntPlusTenExTest() {
		ConcreteStrOps c = new ConcreteStrOps();
		c.toIntPlusTen("vlad20");
	}

}

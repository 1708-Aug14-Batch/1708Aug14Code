package com.revature.q04;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {
	
	@Test(expected = IllegalArgumentException.class)
	public void smartFactorialTestEx() {
		Factorial.smartFactorial(-20);
	}
	
	@Test
	public void smartFactorialTest() {
		assertEquals(1, Factorial.smartFactorial(0));
		assertEquals(1, Factorial.smartFactorial(1));
		assertEquals(3628800, Factorial.smartFactorial(10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void recFactorialTestEx() {
		Factorial.naiveFactorial(-20);
	}
	
	@Test
	public void recFactorialTest() {
		assertEquals(1, Factorial.naiveFactorial(0));
		assertEquals(1, Factorial.naiveFactorial(1));
		assertEquals(3628800, Factorial.naiveFactorial(10));
	}

}

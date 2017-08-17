package com.revature.q19;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void isEvenTest() {
		assertTrue(Numbers.isEven(8));
		assertTrue(Numbers.isEven(-400));
		assertFalse(Numbers.isEven(239));
		assertFalse(Numbers.isEven(-673));
	}
	
	@Test
	public void isPrimeTest() {
		assertFalse(Numbers.isPrime(0));
		assertFalse(Numbers.isPrime(1));
		assertTrue(Numbers.isPrime(7));
		assertTrue(Numbers.isPrime(1009));
		assertFalse(Numbers.isPrime(100920));
	}

}

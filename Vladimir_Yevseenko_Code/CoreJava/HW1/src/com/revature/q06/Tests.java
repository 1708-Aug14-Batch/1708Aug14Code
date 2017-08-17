package com.revature.q06;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void isEvenTest() {
		assertTrue(IsEven.isEven(10000));
		assertTrue(IsEven.isEven(778));
		assertFalse(IsEven.isEven(69));
		assertFalse(IsEven.isEven(367));
	}

}

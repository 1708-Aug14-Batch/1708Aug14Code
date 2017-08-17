package com.revature.q10;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void minTest() {
		assertEquals(5, TernaryMin.min(5,  10));
		assertEquals(9004, TernaryMin.min(23123, 9004));
		assertNotEquals(10000, TernaryMin.min(1000, 10000));
	}

}

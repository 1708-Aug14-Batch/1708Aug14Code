package com.ex.Q6;

import static org.junit.Assert.*;
import static com.ex.Q6.FindEven.isEven;

import org.junit.Test;

public class EvenTest {

	@Test
	public void test() {
		assertEquals(true, isEven(10));
		assertEquals(false, isEven(5));
		assertEquals(false, isEven(0));
	}

}

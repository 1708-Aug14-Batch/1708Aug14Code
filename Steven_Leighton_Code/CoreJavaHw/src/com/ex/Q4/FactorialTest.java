package com.ex.Q4;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ex.Q4.Factorial;

public class FactorialTest {

	@Test
	public void testFactorial() {
		Factorial fact = new Factorial();
		assertEquals(5040, Factorial.factorial(7));
		assertEquals(40320, Factorial.factorial(8));
		assertEquals(362880, Factorial.factorial(9));
		assertEquals(3628800, Factorial.factorial(10));
	}

}

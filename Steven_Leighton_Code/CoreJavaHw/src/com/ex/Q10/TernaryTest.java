package com.ex.Q10;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ex.Q10.Ternary;

public class TernaryTest {

	@Test
	public void test() {
		assertEquals(8, Ternary.min(8,9));
		assertEquals(4, Ternary.min(4,4));
		assertEquals(12, Ternary.min(15,12));
		assertEquals(-5, Ternary.min(-5,-3));
	}

}

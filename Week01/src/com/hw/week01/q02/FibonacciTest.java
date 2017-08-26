package com.hw.week01.q02;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testTwentyFifthFibonacciNumber() {
		assertEquals(46368, Fibonacci.sequence(25)[24]);
	}

}

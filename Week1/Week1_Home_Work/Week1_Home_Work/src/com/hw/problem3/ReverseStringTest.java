package com.hw.problem3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class ReverseStringTest {

	ReverseString tester = new ReverseString();

	@Test
	public void test() {
		assertEquals("cat", tester.reverse("tac"));
	}

}

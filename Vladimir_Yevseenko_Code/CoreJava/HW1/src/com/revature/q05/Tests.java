package com.revature.q05;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void substringTest() {
		assertEquals("Vladimi", Substring.subString("Vladimir", "Vladimir".length() - 1));
		assertEquals("cat", Substring.subString("catterpillar", 3));
	}

}

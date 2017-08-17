package com.revature.q03;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void loopReverseTest() {
		assertEquals("rimidalv", ReverseString.reverseString("vladimir"));
		assertEquals("dlrow olleh", ReverseString.reverseString("hello world"));
	}
	
	@Test
	public void recReverseTest() {
		assertEquals("rimidalv", ReverseString.reverseStringRec("vladimir"));
		assertEquals("dlrow olleh", ReverseString.reverseStringRec("hello world"));
	}
	
	
	@Test
	public void equalityTest() {
		assertEquals(ReverseString.reverseString("eoh23793diuasd732dgqd"),
				ReverseString.reverseStringRec("eoh23793diuasd732dgqd"));
	}

}

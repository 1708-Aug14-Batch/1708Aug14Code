package com.hw.week01.q05;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringTest {

	@Test
	public void testReturnSameString() {
		assertEquals("trance", Substring.substring("trance", 5));
	}
	
	@Test
	public void testReturnFirstCharacter() {
		assertEquals("t", Substring.substring("trance", 0));
	}
	
	@Test
	public void testReturnEveryCharacterButFinal() {
		assertEquals("tranc", Substring.substring("trance", 4));
	}

}

/**
 * 
 */
package com.hw.week01.q03;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author will
 *
 */
public class ReverseStringTest {

	@Test
	public void testSingleCharacterString() {
		assertEquals("A", ReverseString.reverse("A"));
	}
	
	@Test
	public void testTwoCharacterString() {
		assertEquals("BA", ReverseString.reverse("AB"));
	}
	
	@Test
	public void testThreeCharacterString() {
		assertEquals("TAC", ReverseString.reverse("CAT"));
	}
	
	@Test
	public void testManyCharacterString() {
		assertEquals("ECNART", ReverseString.reverse("TRANCE"));
	}
	
	@Test
	public void testZeroCharacterString() {
		assertEquals("", ReverseString.reverse(""));
	}

}

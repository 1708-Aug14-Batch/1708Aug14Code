package com.ex.Q8;

import static org.junit.Assert.*;
import static com.ex.Q8.Palindrome.isPalindrome;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void test() {
		assertEquals(true, isPalindrome("bob"));
		assertEquals(false, isPalindrome("oooob"));
		assertEquals(true, isPalindrome("1234321"));
		assertEquals(true, isPalindrome("123321"));
	}

}

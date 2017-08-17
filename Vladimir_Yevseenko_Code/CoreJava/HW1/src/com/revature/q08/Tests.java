package com.revature.q08;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void isPalindromeTest() {
		assertTrue(Palindromes.isPalindrome("racecar"));
		assertTrue(Palindromes.isPalindrome("potatootatop"));
		assertFalse(Palindromes.isPalindrome("vladimir"));
		assertFalse(Palindromes.isPalindrome("revature dot com"));
	}
	
	@Test
	public void isPalindromeRecTest() {
		assertTrue(Palindromes.isPalindromeRec("racecar"));
		assertTrue(Palindromes.isPalindromeRec("potatootatop"));
		assertFalse(Palindromes.isPalindromeRec("vladimir"));
		assertFalse(Palindromes.isPalindromeRec("revature dot com"));
	}
	
	@Test
	public void onlyPalindromesTest() {
		ArrayList<String> p = new ArrayList<>();
		p.add("vladalv");
		p.add("catac");
		p.add("evilive");
		
		ArrayList<String> np = new ArrayList<>();
		np.add("vlad");
		np.add("vladalv");
		np.add("catac");
		np.add("cat");
		np.add("revature");
		np.add("evilive");
		
		np = Palindromes.onlyPalindromes(np);
		
		assertArrayEquals(p.toArray(new String[np.size()]), np.toArray(new String[np.size()]));
	}
	
	@Test
	public void onlyPalindromesRecTest() {
		ArrayList<String> p = new ArrayList<>();
		p.add("vladalv");
		p.add("catac");
		p.add("evilive");
		
		ArrayList<String> np = new ArrayList<>();
		np.add("vlad");
		np.add("vladalv");
		np.add("catac");
		np.add("cat");
		np.add("revature");
		np.add("evilive");
		
		np = Palindromes.onlyPalindromesRec(np);
		
		assertArrayEquals(p.toArray(new String[np.size()]), np.toArray(new String[np.size()]));
	}

}

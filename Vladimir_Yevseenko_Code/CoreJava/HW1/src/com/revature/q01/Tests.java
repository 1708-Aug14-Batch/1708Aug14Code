package com.revature.q01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Tests {

	@Test
	public void naiveTest() {
		int[] tosort = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] sorted = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		BubbleSort.naiveBubbleSort(tosort);
		assertArrayEquals(tosort, sorted);
	}
	
	@Test
	public void smartTest() {
		int[] tosort = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		int[] sorted = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		BubbleSort.smartBubbleSort(tosort);
		assertArrayEquals(tosort, sorted);
	}

}

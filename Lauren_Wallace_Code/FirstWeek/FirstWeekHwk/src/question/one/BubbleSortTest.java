package question.one;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {
	
	BubbleSortTest tester = new BubbleSortTest();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public int[] sortTest() {
		int[] actual = {0,1,2,3,3,4,5,6,7,8,9};
		int[] sorted = tester.bubbleSortArray(actual);
		
		assertEquals(sorted, actual);
	}

}

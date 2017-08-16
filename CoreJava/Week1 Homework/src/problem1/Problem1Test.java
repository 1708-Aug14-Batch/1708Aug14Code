package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Problem1Test {

	@Test
	public void test() {
		
		Problem1 bubbleSort = new Problem1();

		int intArr[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		int actual[] = bubbleSort.bubbleSort(intArr);
		
		int expected[] = {0,1,2,3,3,4,5,6,7,8,9};
		
		assertArrayEquals(expected, actual);
		
		
	}

}

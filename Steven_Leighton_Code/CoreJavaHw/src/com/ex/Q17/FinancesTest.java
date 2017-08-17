package com.ex.Q17;

import static org.junit.Assert.*;

import org.junit.Test;
import static com.ex.Q17.Finances.getInterestAmount;

public class FinancesTest {

	@Test
	public void test() {
		int expected = 250;
		int actual = (int) getInterestAmount(1000,.05,5);
		
		assertEquals(expected,actual);
		
		expected = 1050;
		actual = (int) getInterestAmount(525,1,2);
		
		assertEquals(expected,actual);
		
		assertEquals((long)8333.25, (long)getInterestAmount(55555,.15,1));
	}

}

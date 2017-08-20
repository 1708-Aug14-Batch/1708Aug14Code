/**
 * 
 */
package JunitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question17.CalculateInterest;

/**
 * @author Joshua Wurdemann
 *
 */
public class CalculateInterestTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
	System.out.println(" what comes before testing");
	}

	/**
	 * Test method for {@link question17.CalculateInterest#CalculateInterest(float, float, float)}.
	 */
	@Test
	public void testCalculateInterest() {
		
	}

	
	/**
	 * Test method for {@link question17.CalculateInterest#simpleInterestCalculator(float, float, float)}.
	 */
	@Test
	public void testSimpleInterestCalculator() {
		float principle = (float) 1000.000;
		float rate = (float) 10.75;
		float time = (float) 7.25;
		
		
		CalculateInterest test = new CalculateInterest(principle, rate, time);
		
		int actual = (int) test.simpleInterestCalculator(principle, rate, time);
		int expected = (int) 77937.5;
		
		assertEquals( expected, actual );
		
	
	}

	}

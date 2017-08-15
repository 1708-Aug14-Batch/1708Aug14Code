package question15;

/*
 * Create a class that implements the interface and provides appropriate
 * functionality to carry out the required operations. 
 */

public class Calculator implements Calculatable<Integer> {

	@Override
	public Integer addition(Integer a, Integer b) {
		return a + b;
	}

	@Override
	public Integer subtraction(Integer a, Integer b) {
		return a - b;
	}

	@Override
	public Integer multiplication(Integer a, Integer b) {
		return a * b;
	}

	@Override
	public Integer division(Integer a, Integer b) {
		return a / b;
	}

}

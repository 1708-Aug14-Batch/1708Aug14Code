package question.fifteen;

public class PerformingMath implements MathOperations {
	
	int    addResult  = 0;
	int    subResult  = 0;
	int    multResult = 0;
	double divResult = 0;
	
	public PerformingMath() {
		this.addResult = 0;
		this.subResult = 0;
		this.multResult = 0;
		this.divResult = 0;
	}

	@Override
	public int add(int num, int num2) {
		
		addResult = num + num2;
		
		return addResult;
	}

	@Override
	public int subtract(int x, int y) {
		
		subResult = x - y;
		
		return 0;
	}

	@Override
	public int multiply(int x2, int y2) {
		
		multResult = x2 * y2;
		
		return multResult;
	}

	@Override
	public double division(double num, double num2) {
		
		divResult = num / num2;
		
		return divResult;
	}

}

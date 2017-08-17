package Q15;

public class OperatorClass implements Operators {

	@Override
	public int addition(int x, int y) {
		return x +y;
	}

	@Override
	public int subtract(int x, int y) {
		return x-y;
	}

	@Override
	public int multiply(int x, int y) {
		return x*y;
	}

	@Override
	public int divide(int x, int y) {
		return x/y;
	}
}

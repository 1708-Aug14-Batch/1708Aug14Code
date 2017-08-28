package Q15;

public class Math implements SimpleMath {

	@Override
	public int addition(int x, int y) {
		return x + y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x - y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x * y;
	}

	@Override
	public float division(int x, int y) {
		if (y == 0) throw new IllegalArgumentException();
		return x / (float)y;
	}
}

interface SimpleMath {
	int   addition(int x, int y);
	int   subtraction(int x, int y);
	int   multiplication(int x, int y);
	float division(int x, int y) throws IllegalArgumentException;
}

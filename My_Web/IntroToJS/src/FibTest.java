import java.math.BigInteger;

public class FibTest {

	static BigInteger count = BigInteger.ONE;
	
	static int fib(int n) {
		count = count.add(BigInteger.ONE);
		return (n < 2) ? n : fib(n-1) + fib(n-2);
	}
	public static void main(String[] args) {
		System.out.println("fib(45) = " + fib(45));
		System.out.println("calls = " + count.intValue());
	}
}

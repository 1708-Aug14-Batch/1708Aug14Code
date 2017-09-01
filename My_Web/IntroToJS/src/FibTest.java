import java.math.BigInteger;

public class FibTest {

	static BigInteger count = BigInteger.ONE;
	static int n = 50;
	
	static int fib(int n) {
		count = count.add(BigInteger.ONE);
		return (n < 2) ? n : fib(n-1) + fib(n-2);
	}
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("fib(" + n + ") = " + fib(n));
		System.out.println("time = " + (System.currentTimeMillis() - start) / 1000.0);
		System.out.println("calls = " + count);
	}
}

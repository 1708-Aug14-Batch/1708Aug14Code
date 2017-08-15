package Q2;

public class First25FibNums {
	final static int N = 25;  // only do first 25 numbers
	
	public static void main(String[] args) {
		// recursively call the fibonacci method N times
        for (int i = 0; i < N; i++) {
        	// print the count and the fibonacci number for that count
            System.out.println((i + 1) + " : " + fibonacci(i));
        }
	}

	static long fibonacci(int n) {
		// the Fibonacci sequence are 0 and 1, and each subsequent number 
		// is the sum of the previous two
        if (n <= 1) {
        	return n;
        } else {
        	return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}

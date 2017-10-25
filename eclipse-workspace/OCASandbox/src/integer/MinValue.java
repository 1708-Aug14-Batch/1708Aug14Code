package integer;

public class MinValue {

	public static void main(String[] args) {
		int a = Integer.MIN_VALUE;
		int b = -a; // Overflow
		System.out.println(a + " " + b);
		
		int c = Integer.MAX_VALUE;
		int d = -c; // No overflow or underflow
		System.out.println(c + " " + d);
	}

}

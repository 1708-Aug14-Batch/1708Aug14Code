package integer.addition;

public class IntegerAddition {

	public static void main(String[] args) {
		int a = 5, b = 7, k = 0;
		Integer m = null;
		System.out.println("a = " + a + ", b = " + b + ", k = " + k + ", m = " + m);
		k = new Integer(a) + new Integer(b); // The values of Integer objects can be added with +
		System.out.println("k = " + k);
		k = new Integer(a) + b; // The value of an Integer can be added to an int with +
		System.out.println("k = " + k);
		k = b + new Integer(a);
		System.out.println("k = " + k);
		m = new Integer(a) + new Integer(b);
		System.out.println("m = " + m);
	}

}

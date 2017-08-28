package Q10;

public class Minimum {
	
	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	public static void main(String[] args) {
		
		System.out.println("1 / 10 = 1 = " + min(1, 10));
		System.out.println("10 / 1 = 1 = " + min(10, 1));
		System.out.println("1  / 1 = 1 = " + min(1, 1));
	}
}

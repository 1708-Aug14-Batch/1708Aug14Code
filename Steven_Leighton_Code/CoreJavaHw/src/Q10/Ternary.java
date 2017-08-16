package Q10;

public class Ternary {
	public static void main(String[] args) {
		//tests
		System.out.println("min(4,7) = " + min(4,7));
		System.out.println("min(5,5) = " + min(5,5));
		System.out.println("min(10,6) = " + min(10,6));
	}
	
	static int min(int a, int b){
		//return a if it's less than or equal to b, b otherwise
		return a <= b ? a : b;
	}
}

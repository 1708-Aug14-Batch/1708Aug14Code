package problem10;

public class Problem10 {
	//Q10. Find the minimum of two numbers using ternary operators.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = 13123123;
		int y = 32131232;
		
		// x is < y
		// prints false in the 1st case and true if fliped
		
		if(x > y ? true : false) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		

		if(y > x ? true : false) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
	}

}

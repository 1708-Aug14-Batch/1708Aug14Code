package operators;

public class OperatorsMain {

	public static void main(String[] args) {
//		double x = 4.0 % 2.0;
//		
//		int y = 15 & 7;
		
//		if (1 && 0) { // && is undefined for ints
//			return;
//		}
		
//		int z = ~10;
//		System.out.println("~10 = " + z);
		
		Short k = 9; Integer i = 9; Boolean b = false;
		char c = 'a'; String str = "123";
		i = (int) k.shortValue();
		str += b;
		System.out.println(str);
		b = !b;
		c += i;
	}

}

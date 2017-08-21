package question.fifteen;

public class HardCodingMath {

	public static void main(String[] args) {
		
		PerformingMath pm = new PerformingMath();
		int num = 5, num2 = 10, num3 = 3, num4 = 12;
		
		System.out.println(num + " + " + num2 + " = " + pm.add(num, num2));
		System.out.println(num2 + " - " + num + " = " + pm.subtract(num2, num));
		System.out.println(num2 + " * " + num3 + " = " + pm.multiply(num2, num3));
		System.out.println(num4 + " / " + num3 + " = " + pm.division(num4, num3));
		
	}

}

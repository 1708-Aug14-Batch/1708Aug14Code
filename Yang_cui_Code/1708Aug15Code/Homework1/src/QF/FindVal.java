package QF;

import java.util.Scanner;

public class FindVal implements MathInterface{
	public static void main(String[] args){
		new FindVal();
	}
	
	public FindVal(){
		Scanner input = new Scanner(System.in);
		System.out.println("please enter a number");
		int a= input.nextInt();
		System.out.println("please enter another number");
		int b= input.nextInt();
		
		System.out.println("The sum is "+ add(a,b));
		System.out.println("The difference is "+ subtract(a,b,true));
		System.out.println("The alternative difference is "+ subtract(a,b,false));
		System.out.println("The product is "+ multiply(a,b));
		System.out.println("The factor is "+ divide(a,b,true));
		System.out.println("The alternative factor is "+ divide(a,b,false));
	}

	@Override
	public double add(double a, double b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public double subtract(double a, double b, boolean direction) {
		// TODO Auto-generated method stub
		if(direction)
			return a-b;
		else
			return b-a;
	}

	@Override
	public double multiply(double a, double b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public double divide(double a, double b, boolean direction) {
		// TODO Auto-generated method stub
		if(direction)
			return a/b;
		else
			return b/a;
	}
}

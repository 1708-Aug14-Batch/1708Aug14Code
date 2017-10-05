package QB;

import java.util.Scanner;

import somefloat.DataHasFloat;

public class TwoFloat {
	public static void main(String[] args){
		new TwoFloat();
	}
	
	public TwoFloat(){
		Scanner input = new Scanner(System.in);
		System.out.println("enter a number");
		int a = input.nextInt();
		System.out.println("enter another number");
		int b = input.nextInt();
		
		DataHasFloat someFloat= new DataHasFloat(a,b);
		System.out.println(someFloat.getNum1()+"+"+someFloat.getNum2()+"="+someFloat.getSum());
	}
}

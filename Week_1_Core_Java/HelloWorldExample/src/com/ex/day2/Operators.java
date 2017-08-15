package com.ex.day2;

public class Operators {

	public static void main(String[] args) {
		int x = 10;
		String answer =  x > 10 ? x==10 ? "false" : "equals" : "something"; //Groups up the (x==10? "false":"equals") for comparison with x>10
		System.out.println(answer);
		Arrays ar1 = new Arrays();
		Arrays ar2 = new Arrays();
		ar1.num++;
		System.out.println(ar1.num);
	}

}

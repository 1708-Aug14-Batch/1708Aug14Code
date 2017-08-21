package com.ex.Q10;

public class Q10 {
	public static void main(String[] args) {
		int n1= 67, n2 =34, n3 = 134;
		int maxOfThree = n1 > n2 ? (n1 > n3 ? n1 : n3) : (n2  <n3 ? n2 : n3);
		System.out.println("Max of three is: " + maxOfThree);

		int minOfThree = n1 < n2 ? (n1 < n3 ? n1 : n3) : (n2  <n3 ? n2 : n3);
		System.out.println("Min of three is: " + minOfThree);
	}
}

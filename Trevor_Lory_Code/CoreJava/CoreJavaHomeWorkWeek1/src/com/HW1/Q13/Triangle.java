package com.HW1.Q13;

public class Triangle {

	public static void main(String[] args) {
		boolean numtype = false;
		for(int i = 0; i < 4; i++) {
			for(int e = 0; e < i + 1; e++) {
				if(numtype) {
					System.out.print("1 ");
					numtype = !numtype;
				}
				else {
					System.out.print("0 ");
					numtype = !numtype;
				}
				if(e == i) {
					System.out.print("\n");
				}
			}
		}
	}
	
}

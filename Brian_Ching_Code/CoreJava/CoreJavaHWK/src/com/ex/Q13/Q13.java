package com.ex.Q13;

public class Q13 {
	
	
	public static void main(String[] args) {
		
		int num = 0;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < i + 1; j++) {
				if (num == 0) {
					System.out.print(num);
					num++;
				} else {
					System.out.print(num);
					num--;
				}
			}		
			System.out.println();
		}
		
		
	}
	
	
}

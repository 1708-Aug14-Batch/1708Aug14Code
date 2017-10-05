package com.ex.day4;

public class TestMath {
	public static void main(String[] args) {
		DoMath test = DoMath.getInstance();
		System.out.println(test.add(1, 1));
		System.out.println(test.sub(2, 1));
		System.out.println(test.mlx(2, 3));
		System.out.println(test.div(4, 2));
	}
}

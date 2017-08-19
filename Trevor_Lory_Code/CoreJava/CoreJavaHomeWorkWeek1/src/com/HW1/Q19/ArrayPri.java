package com.HW1.Q19;

import java.util.ArrayList;

public class ArrayPri {

	public static void main(String[] args) {
		ArrayList<Integer> Ins = new ArrayList<Integer>();
		for(int i = 1; i < 11; i++) {
			Ins.add(i);
		}
		int sum = 0;
		for(int i = 1; i < Ins.size(); i += 2) {
			sum += Ins.get(i);
		}
		System.out.println(sum);
		sum = 0;
		for(int i = 0; i < Ins.size(); i += 2) {
			sum += Ins.get(i);
		}
		System.out.println(sum);
		
		ArrayList<Integer> Ins2 = new ArrayList<Integer>();
		
		for(Integer num : Ins) {
			boolean NotPrime = false;
			if(num.intValue() == 2) {
				continue;
			}
			if(num.intValue()%2 == 0) {
				Ins2.add(num);
				continue;
			}
			for(int i = 3; i < num.intValue(); i++) {
				if(num.intValue()%i == 0) {
					NotPrime = true;
					break;
				}
			}
			if(NotPrime) {
				Ins2.add(num);
			}
		}
		
		for(Integer n : Ins2) {
			System.out.println(n);
		}
		
	}
	
}

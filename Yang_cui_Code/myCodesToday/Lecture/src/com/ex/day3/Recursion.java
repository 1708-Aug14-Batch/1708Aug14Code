package com.ex.day3;

public class Recursion {
	public static void main(String[] args){
		//System.out.println(factorial(4));
		//System.out.println(reverse("cat"));
	}
	public int factorial (int n){
		if(n==1) return 1;
		//if n==2, 2*1
		//if n==3, 3*2
		return n*factorial(n-1);
	}
	public int add(int a,int b){
		return a+b;
	}
	public int addArgs(int... nums){ // user defined number of args
		int sum=0;
		for(int i : nums){
			sum+=i;
		}
		return sum;
	}
	public String reverse(String str){
		if(str.length()==0 || str.length()==1) return str;
		String temp=str.charAt(str.length()-1)+reverse(str.substring(1, str.length()-1))+str.charAt(0);
		return temp;
	}
}

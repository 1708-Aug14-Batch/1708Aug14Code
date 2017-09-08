package com.ex.helloworld;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class TestClass {

	public static void main(String[] args) {

for(int i = 0; i < 20 ; i++){
System.out.println(i + " " + isPowerOf2(i));
}
	}

	
	static boolean isPowerOf2(int x){
		return (x & ( x- 1)) == 0;
	}
}

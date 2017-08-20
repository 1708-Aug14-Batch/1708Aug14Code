package com.question18;

public class Concrete1 extends AbstractQuestion18 {
	private static String words;
	private static int Numbers;
	
	@Override
	
	
	public boolean hasUpperCase() {
		// TODO Auto-generated method stub
		for(int i =0; i < words.length(); i++ ){
			if(Character.isUpperCase(words.charAt(i)));
			return true;
		}
		return false;
	}
	@Override
	public void toUpperCase() {
		// TODO Auto-generated method stub
		words = words.toUpperCase();
	}
	@Override
	public int addTen() {
		// TODO Auto-generated method stub
		return Numbers +10;
	}

}

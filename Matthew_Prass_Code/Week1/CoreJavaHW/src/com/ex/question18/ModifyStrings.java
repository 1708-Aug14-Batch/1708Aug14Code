package com.ex.question18;

public class ModifyStrings extends AbstractClass {

	@Override
	public boolean isUpper(String str) {
		
		boolean bool = false;
		for(int i =0; i < str.length(); i++)
		{
			bool = Character.isUpperCase(str.charAt(i));
			if(bool)
				break;
		}
		return bool;
	}

	@Override
	public String toUpper(String str) {
		String temp = "";
		for(int i =0; i <str.length(); i++)
		{
			if(Character.isLowerCase((str.charAt(i))));
				temp+=str.charAt(i);
		}
		temp = temp.toUpperCase();
		return temp;
	}

	@Override
	public void idk(String str) {
		
		int x = Integer.parseInt(str);
		x +=10;
		System.out.println(x);
	}

}

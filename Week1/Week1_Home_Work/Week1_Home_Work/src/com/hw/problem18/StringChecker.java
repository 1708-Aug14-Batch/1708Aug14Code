package com.hw.problem18;

public class StringChecker extends StringCheck {

	@Override
	boolean hasUpperCase(String str) {
		for (Character cha : str.toCharArray())
			if (Character.isUpperCase(cha))
				return true;
		return false;
	}

	
	@Override
	String ToUpperCase(String str) {
		char[] chaArray = str.toCharArray();
		
		
		for (int i = 0; i < chaArray.length; i++)
			if (Character.isLowerCase(chaArray[i]))
				chaArray[i] = Character.toUpperCase(chaArray[i]);
		
	
		String result = "";
		for (char cha : chaArray)
			result += cha;
		
		return result;
	}

	
	@Override
	void printIntToString(String str) {
		int result = 0;
		
				for (char cha : str.toCharArray())
			result += cha;
		
		System.out.println(result + 10);
	}

}

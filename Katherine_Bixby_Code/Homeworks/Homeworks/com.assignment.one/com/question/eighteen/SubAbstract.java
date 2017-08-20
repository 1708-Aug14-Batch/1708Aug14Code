package com.question.eighteen;


/**
 * Implementations of AbstractSuper's methods
 * @author Katie
 *
 */
public class SubAbstract extends AbstractSuper{

	@Override
	public boolean capsCheck(String str) {
		char[] strArr = str.toCharArray();
		Character toCheck;
		for(char id=0;id<strArr.length;id++) {
			toCheck = strArr[id];
			if(Character.isUpperCase(toCheck)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String makeCaps(String str) {
		String caps = str.toUpperCase();
		return caps;
	}

	@Override
	public int addTen(String str) {
		int theInt = Integer.parseInt(str);
		theInt+=10;
		return theInt;
	}

	
	
}

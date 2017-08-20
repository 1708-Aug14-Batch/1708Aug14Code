package questionFive;

public class Substring {
	
	public String substring(String str, int idx) {
		//sends string to character array
		char[] string = str.toCharArray();
		//creates a new string that will be returned
		String newStr = new String();
		for(int i = 0; i<idx;i++) {
			//loops through the array from 0 to idx-1 inclusive
			//adds each character as a string to newStr
			newStr += string[i];
		}
		return newStr;
	}
}

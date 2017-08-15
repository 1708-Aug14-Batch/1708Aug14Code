package questionFive;

public class QuestionFive {
	
	public String substring(String str, int idx) {
		char[] string = str.toCharArray();
		String newStr = new String();
		for(int i = idx; i<string.length;i++) {
		newStr += string[i];
		}
		return newStr;
		
	}

}

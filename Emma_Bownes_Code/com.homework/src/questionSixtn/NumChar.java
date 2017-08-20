package questionSixtn;

public class NumChar {
	
	public static int countChar(String string) {
		//finds length of string
		int n = string.length();
		//returns
		return n;
	}
	public static void main(String[] args) {
		//prints return value from countChar
		//uses first parameter entered in command line as argument for countChar
		for(String s: args) {
			System.out.println(countChar(s));
		}
	}
}

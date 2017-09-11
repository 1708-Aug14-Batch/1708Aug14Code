package Q3;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Hello World";
	    System.out.println(reverseStr(str));

	}

	public static String reverseStr(String s) {
	    int len = s.length();
	    for (int i = (len - 1); i >= 0; i--) {
	        s += s.charAt(i);
	    }
	    s = s.substring(len);
	    return s;
	}
}

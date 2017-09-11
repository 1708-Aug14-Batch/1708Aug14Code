
public class UnderStandingStrings {

	public static void main(String[] args) {

		String a = new String();
		a = "hello";
		String b = "hello";
		String c = "hello";
		c = "Hello World";
		String d = b;
		String e = new String("hello");
		
		System.out.println(a==b);
		System.out.println(a==d);
		System.out.println(a==e);
		
		System.out.println(a.equals(e));
		
		System.out.println("----------");
		
		a.concat(" World");   // didn't save to new string variable, thus ignored
		a += (" world");
		System.out.println(a);
		
		String nums = "0000000000";
		System.out.println(nums.replace("000", "1"));
		System.out.println(nums.replaceAll("000", "1"));
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String alph = alphabet.substring(10, 11);
		System.out.println(alph);
		System.out.println();
	}

}

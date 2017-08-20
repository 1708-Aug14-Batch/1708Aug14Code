package questionThree;

public class ReverseString {
	
	public static String reverse(String string) {
		for(int i=0;i<string.length();i++) {
			string = string.replaceAll(string.substring(i), //replaces the last portion of the string
					string.substring(string.length()-1, string.length())//with the last letter
					.concat(string.substring(i, string.length()-1)));//concantonated with the portion of the string except for that letter
			
		}
		return string;
	}

	public static void main(String[] args) {
		System.out.println(reverse("Power"));
		System.out.println(reverse("Cats"));
		System.out.println(reverse("Oh, how far we have come."));
	}

}

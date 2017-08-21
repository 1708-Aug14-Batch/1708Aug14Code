package question.eighteen;

public class WorkingWithStrings {

	public static void main(String[] args) {
		
		WorkingWithAlterS alters = new WorkingWithAlterS();
		String str1 = "Hello my friend";
		String str2 = "1234";
		
		System.out.println("The result of checking " + str1 + " for upper case letters has returned " + alters.checkForUppers(str1));
		System.out.println(alters.toUppercase(str2));
		alters.stringConversion(str2);
		
	}

}

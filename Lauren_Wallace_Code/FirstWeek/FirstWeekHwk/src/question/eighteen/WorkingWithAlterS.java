package question.eighteen;

public class WorkingWithAlterS implements AlteringStrings{

	public WorkingWithAlterS() {
		
	}
	
	@Override
	public boolean checkForUppers(String str) {
		
		String allCaps = str.toUpperCase();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == allCaps.charAt(i)) {
				return true;
			}
			continue;
		}
		
		return false;
	}

	@Override
	public String toUppercase(String str) {
		
		str.toUpperCase();
		
		return str;
	}

	@Override
	public void stringConversion(String str) {
		
		System.out.println("This is the string to be converted: " + str);
		int result = Integer.parseInt(str) + 10;
		System.out.println("The result of the string conversion is: " + result);
		
	}

}

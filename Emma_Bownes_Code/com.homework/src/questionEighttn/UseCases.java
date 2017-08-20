package questionEighttn;

public class UseCases extends Cases{

	@Override
	public boolean uppercase(String string) {
		boolean ret = false;
		//creates a boolean variable that will be returned (only if false)
		for (int i =0; i<string.length();i++) {
			//loops through string
			String sub = string.substring(i, i+1);
			//breaks string down into small substrings
			if(sub == sub.toUpperCase()) {
				//if the substring is == to its own capitalization,
				//then it is capitalized, return true to exit
				return true;
			}
			else {
				//if not, it may or may not have capitals in it, let ret=false
				//however, it continues through loop to check the rest of the string
			ret = false;
			}
		}
		return ret;
	}
	@Override
	public String changeCase(String string) {
		//This simply uses the methods that belong to the String object
		string = string.toUpperCase();
		return string ;
	}

	@Override
	public void stringToInt(String string) {
		try {
			int x = Integer.parseInt(string);
			System.out.println(x);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
	}

}

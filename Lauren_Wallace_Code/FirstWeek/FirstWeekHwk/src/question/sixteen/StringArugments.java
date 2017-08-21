package question.sixteen;

public class StringArugments {

	public static void main(String[] args) {
		
		int size;
		
		if(args[0] == null) {
			System.out.println("There are no command line arguments.");
		}
		else {
			size = args[0].length();
			System.out.println("The size of the String argument is: " + size);
		}

	}

}

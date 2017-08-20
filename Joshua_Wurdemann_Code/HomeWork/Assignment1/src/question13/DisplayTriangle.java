package question13;

public class DisplayTriangle {
	/**
	 * Display the triangle on the console as follows using any type of loop.  
	 * Do NOT use a simple group of print statements to accomplish this.
	 * @param args
	 */
	public static void main(String[] args) {
		int rows = 5;

		String s = "";
		for(int i = 1 ; i < rows ; ++i) {

			s = (i % 2 == 0 ? "1 " : "0 ") + s;
			System.out.println(s); 
		}

	}

}

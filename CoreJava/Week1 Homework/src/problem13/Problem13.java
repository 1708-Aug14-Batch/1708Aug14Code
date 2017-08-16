package problem13;

public class Problem13 {
	//Q13. Display the triangle on the console as follows using any type of loop.  
	//Do NOT use a simple group of print statements to accomplish this.
	//    0
	//    1 0
	//    1 0 1
	//    0 1 0 1

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Uses boolean and if statement to track 0 and 1
		
		int max = 4;
		boolean tf = true;
		
		// Loop for rows
		for(int x = 0; x<max; x++) {
			// Loop for numbers on rows
			for(int y = 0; y<=x; y++) {
				if(tf == true) {
					System.out.print(0);
					tf = false;
				}
				else {
					System.out.print(1);
					tf = true;
				}
			}
			System.out.print("\n");
		}
	}

}

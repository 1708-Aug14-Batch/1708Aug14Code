package question13;

/*
 * Q13. Display the triangle on the console as follows using any type of
 * loop.  Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1
 */

public class TriangleDisplayer {

	/*
	 * Since there is no discernible pattern to the "triangle" I had
	 * to improvise and make some weird loops.
	 */
	public static void main(String[] args) {
		int count1 = 0;
		
		while (count1 < 4) {
			int count2 = count1;
			
			// These lines will print the first character in each line
			if (count1 % 3 == 0)
				System.out.print("0 ");
			else System.out.print("1 ");
			
			// This loops prints every other character in the line
			while (count2 > 0) {
				if (count2 % 3 == 0)
					System.out.print("1 ");
				else if (count2 == 1 && count1 != 1)
					System.out.print("1 ");
				else System.out.print("0 ");
				
				count2--;
			}
			
			System.out.println();
			count1++;
		}
	}
}

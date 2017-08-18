package Q13;

public class Triangle {
	// Display the triangle on the console as follows using any type of loop.
	// Do NOT use a simple group of print statements to accomplish this.
	// 0
	// 1 0
	// 1 0 1
	// 0 1 0 1

	public static void main(String[] args) {
		int a = 0;
		for (int row = 1; row <= 4; row++) {
			for (int x = 1; x <= row; x++) {
				System.out.print(a + " ");
				if (a == 0) {
					a = 1;
				} else {
					a = 0;
				}
			}
			System.out.println();
		}
	}
}

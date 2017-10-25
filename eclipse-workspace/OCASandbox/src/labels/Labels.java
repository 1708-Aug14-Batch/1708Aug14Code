package labels;

public class Labels {

	public static void main(String[] args) {
		int a[][] = { {1, 0, 1}, {0, 1, 0}, {1, 0, 1} };
		myLoop:
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					System.out.println(a[i][j]);
					if (a[i][j] == 2) {
						System.out.println("Breaking myLoop");
						break myLoop;
					}
				}
			}
	}
	
	static void breakWithoutLabel() {
		//break; Break cannot be used outside of a switch or loop
		//continue; Continue cannot be used outside of a loop
	}

}

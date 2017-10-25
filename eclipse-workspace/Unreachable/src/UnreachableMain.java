
public class UnreachableMain {

	public static void main(String[] args) {
		
		// The following 2 statements cause implicit widening conversions
		float a = -123;
		double b = -123;
		
		int x = 0;
		
//		Unreachable code
//		while (false) {
//			x = 3;
//		}
		
//		Dead code
		if (false) {
			x = 3;
		}
		
		do {
			x = 3;
		} while (false);
		
		for (int i = 0; i < 0; i++) {
			x = 3;
		}
	}
	
}

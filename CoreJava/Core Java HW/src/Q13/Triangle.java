package Q13;

public class Triangle {
	
	public static void main(String[] args) {
		String s = "0";
		char c = '0';
		for (int i = 0; i < 4; i++) {
			System.out.println(s);
			if (i % 2 == 0) {
				c = (c == '0') ? '1' : '0';
				s = c + s;
			}
			else  {
			s += c;
			}
		}		
	}
}

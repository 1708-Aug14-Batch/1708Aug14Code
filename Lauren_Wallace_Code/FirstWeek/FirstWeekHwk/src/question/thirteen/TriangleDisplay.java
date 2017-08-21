package question.thirteen;

public class TriangleDisplay {

	public static void main(String[] args) {
		
		int num = 0;
		
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				if(num % 2 == 0) {
					System.out.print(0);
				}
				else {
					System.out.print(1);
				}
				num++;
			}
			System.out.println();
		}

	}

}

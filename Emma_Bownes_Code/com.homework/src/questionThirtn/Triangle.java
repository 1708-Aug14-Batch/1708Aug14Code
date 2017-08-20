package questionThirtn;

public class Triangle {
	
	public static void main(String[] args) {
		int count = 0;
		//initializes count
		for(int i=0;i<4;i++) {
			//loops through number of rows
			for(int j=0;j<i+1;j++) {
				//loops through row length,
				//each row's length is equal to
				//it's row number
				System.out.print((count)%2);
				count++;
				//printing out count mod 2 for a count
				//that increases with each output
				//will produce a 0101... pattern
			}
			System.out.println("");	
			//at the end of the row, a new line is created
		}
	}
}

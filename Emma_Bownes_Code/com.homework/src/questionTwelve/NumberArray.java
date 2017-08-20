package questionTwelve;

import java.util.stream.IntStream;

public class NumberArray {
	public static void main(String[] args) {
		int[] numbers = IntStream.range(1,101).toArray();
		//creates an array an populates it with numbers 0 - 100
		for(int i: numbers) {
			//loops through array
			if(i%2==0) {
				//determines if the entry is even
				System.out.println(i+" is even");
				//prints that it is even
			}
		}
	}

}

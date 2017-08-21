package question.twelve;

public class SortingArrays {
	
	public static void main(String[] args) {
		
		int size = 101;
		int[] arr = new int[size];
		
		for (int i = 1; i < size; i++) {
			arr[i] = i;
		}
		
		for(int i: arr) {
			if(i % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}

}

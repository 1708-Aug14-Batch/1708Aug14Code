package Q12;

public class StoreAndPrint {
	public static void main(String[] args) {
		
		//new array with 100 indices
		int[] nums = new int[100];
		
		//normal for loop for storing
		for(int i = 0; i < 100; i++){
			nums[i] = i+1;
		}
		
		//enhanced for loop for printing
		for(int i : nums){
			if(i%2 == 0) System.out.println("Even number: " + i);
		}
	}
}

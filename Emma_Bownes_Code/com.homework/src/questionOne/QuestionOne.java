package questionOne;

public class QuestionOne {
	
	
	public static void sort(int[] unsorted, int n){
		boolean resort = false; 
		//this will determine weather or not a change was made, thus if the list should be sorted again
		int first;
		int second;
		//when comparing two numbers in the array, these will represent the two numbers
		for(int i=1; i < n; i++){
			//the loop only goes to n because once a number has been pushed to the end, it MUST be larger than all other numbers in the list and need not be resorted
			first = unsorted[i-1];
			second = unsorted[i];
			if (first>second){
				//sorting is only needed if the first number is not smaller than the second
				resort = true;
				//If a switch is made, resort is set to true to tell the program to sort through again
				unsorted[i-1] = second;
				unsorted[i] = first;
				//The actual switch is made
			}
			
		}
		if(resort==true){
			//If a switch was made, the method will call itself again (recursion)
			//This time the index is one less because the element at the last index is already in the correct place
			sort(unsorted, n-1);
		}
	}
	public static void main(String[] args){
		int[] unsorted = new int[]{1,0,5,6,3,2,3,7,9,8,4};
		int n = unsorted.length;
		sort(unsorted, n);
		//at the first call, the method must look through the entire array
		for(int i :unsorted){
			System.out.println(i);
		}
	}

}


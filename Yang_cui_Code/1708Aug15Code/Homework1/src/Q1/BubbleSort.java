package Q1;

public class BubbleSort {

	public static void main(String[] args){
		new BubbleSort();
	}
	
	public BubbleSort(){
		int[] numbers ={1,0,5,6,3,2,3,7,9,8,4};
		int[] sorted;
		sorted=bubble(numbers);
		
		for(int i=0; i<sorted.length; i++)
			System.out.println(sorted[i]);
	}
	
	public int[] bubble(int[] numbers){
		
		int temp;
		for(int i=0; i<numbers.length; i++){
			for(int j=i; j<numbers.length; j++){
				if(numbers[i]>numbers[j]){
					temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}
			}
		}
		return numbers;
	}
}

package QC;

public class PrintEven {
	public static void main(String[] args){
		new PrintEven();
	}
	
	public PrintEven(){
		int[] numbers = new int[100];
		for(int i=1; i<=100; i++)
			numbers[i-1]=i;
		for(int checkEven : numbers)
			if(isEven(checkEven))
				System.out.println(checkEven);
	}
	
	public boolean isEven(int number){
		for(int i=0; i<number; i++)
			if(2*i==number)
				return true;
		return false;
	}
}

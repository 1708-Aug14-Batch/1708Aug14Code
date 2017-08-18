package questionTwelve;

public class question12 {

	public static void main(String[] args){
		int [] myArray = new int[100];
		
		for(int i = 0;i < myArray.length; i++){
			myArray[i]=i+1;
		}
		for(int num: myArray){
			if(num % 2 == 0)
				System.out.println(num);
		}
		
	}
}

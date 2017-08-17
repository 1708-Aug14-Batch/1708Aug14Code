package arrays;

public class LearningExceptions {
	public static void main(String[] args){
		int [] arr = new int [4];
		try{
			arr[0] = 1;
			arr[4] = 5;
			System.out.println(arr[4]);
			System.out.println("I pass this exception");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("inside catch block"); 
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("inside finally block");
		}
	}
	}

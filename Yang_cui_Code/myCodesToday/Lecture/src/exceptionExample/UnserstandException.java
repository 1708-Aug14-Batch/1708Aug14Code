package exceptionExample;

public class UnserstandException {
	public static void main(String[] args) throws Exception{
		int[] arr= new int[4];
		try{
		arr[0]=1;
		arr[6]=5;
		
		String str=null;
		System.out.println(str.indexOf('a'));
		System.out.println("reached end try");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("catched 1");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(NullPointerException e){
			System.out.println("catched 2");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//catch(Exception e){
		//	e.printStackTrace(); // exception is run time or not run time
		//}
		finally{
			System.out.println("inside final block");
		}
		//System.out.println(arr[4]);
		System.out.println("passed");
		
		try {
			duckException();
		} catch (MyExc e) {
			// TODO Auto-generated catch block
			System.out.println("we caught duck");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static void duckException() throws Exception{ //propgating exception
		System.out.println("we duck");
		//throw new Exception();
		throw new MyExc();
	}
}

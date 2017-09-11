
public class ExceptionExamples {

	public static void main(String[] args) throws Exception {
		int[] arr = new int[4];
		try {
			arr[0] = 1;
			arr[4] = 5;
			System.out.println(arr[4]);
			
//			String str;
//			System.out.println(str.indexOf('a'));
//		} catch (NullPointerException e) {
//			System.out.println();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("inside catch block");
			System.out.println(e.getMessage());
//			e.printStackTrace();
		} finally {
			System.out.println("inside finally block");
		}

		System.out.println("hey, i passed the exception");
		
		try {
			duckException();
		} catch (MyException e) {
			System.out.println("we caught our ducked exception");
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
	}
	
	static void duckException() throws Exception {
		System.out.println("we are ducking/propagating exceptions");
		throw new MyException();
	}

}

package questionFiftn;

public class DoMath implements Calculable{
	int ret;

	@Override
	public int addition(int a, int b) {
		ret = a + b;
		return ret;
	}

	@Override
	public int subtraction(int a, int b) {
		ret = a-b;
		return ret;
	}

	@Override
	public int multiplication(int a, int b) {
		ret = a*b;
		return ret;
	}

	@Override
	public int division(int a, int b) {
		if(a>b) {
		ret = b/a;}
		else {
		ret = a/b;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		
	}
	

}

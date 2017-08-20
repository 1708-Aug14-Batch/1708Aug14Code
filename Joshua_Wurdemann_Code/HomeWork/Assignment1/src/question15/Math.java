package question15;

/**
 *  Write a program that defines an interface having the following methods: 
 *  addition, subtraction, multiplication, and division.  
 *  Create a class that implements this interface and provides appropriate 
 *  functionality to carry out the required operations.
 *   Hard code two operands in a test class having a main method that calls the implementing class.
 * @author josh wurdemann
 *@version 8/20/2017
 */
public class Math implements MathFormulas{
	private int myNum;
	private int mySomeNumber;

	public Math(final int theNum, final int theSomeNumber){
		myNum = theNum;
		mySomeNumber = theSomeNumber;
	}

	public int getMyNum() {
		return myNum;
	}


	public void setMyNum(int myNum) {
		this.myNum = myNum;
	}


	public int getMySomeNumber() {
		return mySomeNumber;
	}


	public void setMySomeNumber(int mySomeNumber) {
		this.mySomeNumber = mySomeNumber;
	}


	@Override
	public void addtion(int s, int x) {
		int sum;
		sum =	s + x;

		print(sum);
	}

	@Override
	public void multiplcation(int s, int x) {
		int product;
		product = s * x;
		print(product);
	}

	@Override
	public void division(int s, int x) {
		int quoient;
		quoient = s / x;
		print(quoient);

	}
	public void print(int number){
		System.out.println(number);
	}
}

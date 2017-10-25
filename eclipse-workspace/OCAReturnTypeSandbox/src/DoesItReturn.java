
public class DoesItReturn {
	
	private long myLong = 19L;
	private int myInt = 19;
	private double myDouble = 19D;
	private float myFloat = 19F;
	private short myShort = 19;
	private byte myByte = 19;
	private char myChar = 19;
	
	public void walk2() {
		return;
	}
	
	// Must have return statement that is guaranteed to execute
	String walk6(int a) {
		if (a == 4) {
			return "";
		}
		return null; // Can return null, since a String can be null
	}

}

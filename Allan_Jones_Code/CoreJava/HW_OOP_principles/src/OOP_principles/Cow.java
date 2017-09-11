package OOP_principles;

public class Cow extends Animal implements Domestic {
	
	Cow() {
		noOfLegs = 4;
	}
	
	@Override
	public boolean isPet() {
		return false;
	}

	@Override
	public boolean isTame() {
		return true;
	}

	@Override
	public boolean isFood() {
		return true;
	}

	@Override
	public boolean doesWork() {
		return true;
	}

}

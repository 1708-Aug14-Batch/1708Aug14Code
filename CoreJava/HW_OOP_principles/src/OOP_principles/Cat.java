package OOP_principles;

public class Cat extends Animal implements Domestic {
	
	Cat() {
		noOfLegs = 4;
	}
	
	@Override
	public boolean isPet() {
		return true;
	}

	@Override
	public boolean isTame() {
		return true;
	}

	@Override
	public boolean isFood() {
		return false;
	}

	@Override
	public boolean doesWork() {
		return false;
	}

}

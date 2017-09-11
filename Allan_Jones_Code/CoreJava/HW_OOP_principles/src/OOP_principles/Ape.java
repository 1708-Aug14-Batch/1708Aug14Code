package OOP_principles;

public class Ape extends Animal implements Domestic {
	
	Ape() {
		noOfLegs = 2;
	}

	@Override
	public boolean isPet() {
		return false;
	}

	@Override
	public boolean isTame() {
		return false;
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

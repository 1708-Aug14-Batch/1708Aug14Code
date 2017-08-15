package OOP_principles;

public class Cat extends Animal implements Domestic {
	
	Cat() {
		noOfLegs = 4;
	}
	
	@Override
	//polymorphism
	public boolean isPet() {
		return true;
	}

	@Override
	//polymorphism
	public boolean isTame() {
		return true;
	}

	@Override
	//polymorphism
	public boolean isFood() {
		return false;
	}

	@Override
	//polymorphism
	public boolean doesWork() {
		return false;
	}

}

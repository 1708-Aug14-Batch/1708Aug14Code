package OOP_principles;

public class Tiger extends Cat {
	
	Tiger() {
		noOfLegs = 4;
	}
	
	//polymorphism
	@Override
	public boolean isPet() {
		return false;
	}

	//polymorphism
	@Override
	public boolean isTame() {
		return false;
	}


}

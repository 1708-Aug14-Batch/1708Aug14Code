package OOP_principles;

public class Tiger extends Cat {
	
	Tiger() {
		noOfLegs = 4;
	}
	
	@Override
	public boolean isPet() {
		return false;
	}

	@Override
	public boolean isTame() {
		return false;
	}


}

package OOP_principles;

public class Dog extends Animal implements Domestic {
	private String breed;
	
	Dog() {
		noOfLegs = 4;
	}

	public Dog(String breed) {
		super();
		this.breed = breed;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
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

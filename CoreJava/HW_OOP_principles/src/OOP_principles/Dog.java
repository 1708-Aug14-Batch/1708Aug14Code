package OOP_principles;

public class Dog extends Animal implements Domestic
// extends and implements are key words for inheritance
// Animal is parent of Dog
// Domestic is parent of Dog
{ 
	//encapsulation
	private String breed;
	
	Dog() {
		noOfLegs = 4;
	}

	public Dog(String breed) {
		super();
		this.breed = breed;
	}

	//encapsulation
	public String getBreed() {
		return breed;
	}

	//encapsulation
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

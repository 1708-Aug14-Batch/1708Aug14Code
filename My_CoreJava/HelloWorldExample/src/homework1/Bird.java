package homework1;

public abstract class Bird extends Animal {
	
	public void fly(double dist) {
		System.out.println("The " + getSpecies() + " flew " + dist + " feet.");
	}
	
}

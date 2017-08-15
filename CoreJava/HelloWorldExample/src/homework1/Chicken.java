package homework1;

public class Chicken extends Bird implements Edible {
	
	public static final String CHICKEN_SPECIES = "Chicken";
	
	public Chicken() {
		setSpecies(CHICKEN_SPECIES);
	}

	public void cook(double temp) {
		System.out.println("You cook the " + getSpecies() + " to " + temp + "\u00b0F");
	}

	public double eat() {
		System.out.println("You ate " + getSize() + " of the " + getSpecies());
		return getSize();
	}

	@Override
	public void makeNoise() {
		System.out.println("*coo*");
	}

}

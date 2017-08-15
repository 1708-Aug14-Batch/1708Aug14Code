package fourOOPPrinciples;

public class Dragon extends Lizard implements Flying, FireBreathing {

	protected boolean flying = false;
	
	Dragon() {
		super(50);
		species = "Draco";
		averageLifespan = 1000;		// years
		name = "dragon";
	}
	
	@Override
	public void breatheFire() {
		if (energy > 10) {
			energy -= 10;
			System.out.println("The " + name + " mightily breathes fire!!!");
		} else System.out.println("The " + name + " is too tired to breathe fire");
	}

	@Override
	public void beAwesome() {
		System.out.println("The " + name + " is just plain awesome!");
	}

	@Override
	public void fly() {
		if (energy < 10)
			System.out.println("The " + name + " is too tired to fly");
		else if (flying)
			System.out.println("The " + name + " is already flying!");
		else {
			energy -= 10;
			flying = true;
			System.out.println("The " + name + " flies through the skies!");
		} 
	}

	@Override
	public void land() {
		if (!flying)
			System.out.println("The " + name + " cannot land if it's not already flying!");
		else System.out.println("The " + name + " lands on the ground.");
	}
	
	// Overloading
	protected void breathe() {
		System.out.println("The " + name + " breathes deeply");
	};

}

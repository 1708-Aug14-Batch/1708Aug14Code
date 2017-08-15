package fourOOPPrinciples;

public class Lizard extends Animal {

	protected String name = "lizard";
	// Energy ranges from 0 to 100
	protected int energy = 100;
	// Size ranges from 0 to 100
	protected int size;
	protected int numChildren = 0;
	
	Lizard(int size) {
		if (size < 0)
			size = 0;
		else if (size > 100)
			size = 100;
		
		this.size = size;
	}
	
	@Override
	public void move() {
		if (energy > 0) {
			energy--;
			System.out.println("The " + name + " moves");
		} else System.out.println("The " + name + " is too tired to move");
	}

	@Override
	public void grow() {
		if (size > 100)
			System.out.println("The " + name + " cannot grow as it is already at full size");
		else if (energy < 10)
			System.out.println("The " + name + " cannot grow as it is malnourished");
		else {
			energy -= 10;
			size += 10;
			System.out.println("The " + name + " expended energy to grow in size." +
					" Its size is now " + size + ", and it has " + energy + " energy left");
		}
	}

	@Override
	public void reproduce() {
		numChildren++;
		System.out.println("The " + name + " reproduces and now has " + numChildren + " offspring");
	}

	@Override
	protected void eat() {
		if (energy > 90) 
			System.out.println("The " + name + " is too full to eat more");
		else {
			energy += 10;
			System.out.println("The " + name + " eats some food and now has " + energy + " energy");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy;
	}

	public int getSize() {
		return size;
	}

	public int getNumChildren() {
		return numChildren;
	}

	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}

	
}

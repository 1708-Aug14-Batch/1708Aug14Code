package factorydesign;

public class Person implements Walkable{

	@Override
	public void walk() {
		System.out.println("Look, I'm a person and my friend is taking me out to walk the park together!");
		System.out.println("I walk on two legs. I can be  graceful or clumsy.");
	}

}

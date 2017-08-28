package homework1;

/**
 * 
 * @author Nathan
 *
 * Interface which describes items that can be eaten
 */

public interface Edible {
	
	/**
	 * @param temp The temperature to cook the given object
	 */
	public void cook(double temp);
	
	/**
	 * @return The amount of object eaten
	 */
	public double eat();

}

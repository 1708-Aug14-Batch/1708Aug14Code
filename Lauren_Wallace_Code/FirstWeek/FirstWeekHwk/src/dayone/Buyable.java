package dayone;

//Allows the programmer to abstractly describe methods without providing details
//then provide the details in classes that implement this interface
public interface Buyable {
	
	public void priceCheck(String store1, double price1, String store2, double price2);
	
	public int decreaseValue(int years);
	
	public void description();

}

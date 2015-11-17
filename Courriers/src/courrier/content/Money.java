/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.content;

import courrier.Content;

/**
 * Class defining the Money
 */
public class Money implements Content {

	// Attributes
	protected int amount;
	
	// Methods
	
	/**
	 * Constructor for the Money class
	 * @param amount
	 * @throws {@link IllegalArgumentException} amount must be >= 0
	 */
	public Money(int amount) throws IllegalArgumentException {
		if(amount < 0)
			throw new IllegalArgumentException("amount must be >= 0");
		this.amount = amount;
	}
	
	
	/**
	 * Returns the amount of money
	 * 
	 * @return the amount of money
	 */
	public int getAmount() {
		return amount;
	}
	
	
	/**
	 * Returns a String defining the Content
	 * 
	 * @return a String defining the Content
	 */
	@Override
	public String toString() {
		return "a money content (" + this.amount + ")";
	}
	
}

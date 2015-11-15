/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier;

/**
 * Abstract Class defining the Letters
 */
public abstract class Letter<C extends Content> implements Content {
	
	// Attributes
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected C content;
	
	// Methods
	
	/**
	 * Constructor for the Letter class
	 * 
	 * @param sender : Inhabitant
	 * @param receiver : Inhabitant
	 * @param content : Content
	 */
	public Letter(Inhabitant sender, Inhabitant receiver, C content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}
	
	
	/**
	 * Returns the sender of the letter
	 * 
	 * @return the sender of the letter : <b>Inhabitant</b>
	 */
	public Inhabitant getSender() {
		return sender;
	}
	
	
	/**
	 * Returns the receiver of the letter
	 * 
	 * @return the receiver of the letter : <b>Inhabitant</b>
	 */
	public Inhabitant getReceiver() {
		return receiver;
	}
	
	
	/**
	 * Returns the content of the letter
	 * 
	 * @return the content of the letter : <b>Content</b>
	 */
	public C getContent() {
		return content;
	}
	
	
	/**
	 * Action executed when the letter is opened
	 */
	public abstract void doAction();
	
	/**
	 * Returns the cost to send the letter
	 * 
	 * @return the cost to send the letter : <b>int</b>
	 */
	public abstract int getCost();
	
	/**
	 * Returns a String defining the letter
	 * 
	 * @return a String defining the letter : <b>String</b>
	 */
	public abstract String toString();
	
}

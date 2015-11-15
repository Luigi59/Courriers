/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.letter;

import courrier.Inhabitant;
import courrier.Letter;
import courrier.content.Text;

/**
 * Class defining the SimpleLetter
 */
public class SimpleLetter extends Letter<Text> {
	
	// Attributes
	
	public static final int SIMPLE_LETTER_COST = 1;
	
	// Methods
	
	/**
	 * Constructor for the SimpleLetter class
	 * 
	 * @param sender : Inhabitant
	 * @param receiver : Inhabitant
	 * @param content : Text
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}

	
	/**
	 * @see courrier.Letter#doAction()
	 */
	public void doAction() {
		/* No action for simple letter */
	}

	
	/**
	 * @see courrier.Letter#getCost()
	 */
	public int getCost() {
		return SimpleLetter.SIMPLE_LETTER_COST;
	}


	/**
	 * @see courrier.Letter#toString()
	 */
	public String toString() {
		return "a simple letter whose content is " + this.content;
	}
	
}

/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.letter;

import courrier.Inhabitant;
import courrier.content.Text;

/**
 * Class defining the ThanksLetter
 */
public class ThanksLetter extends SimpleLetter {

	/**
	 * Constructor for the ThanksLetter class
	 * @param sender
	 * @param receiver
	 * @param letter
	 */
	public ThanksLetter(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}
	
	
	/**
	 * @see courrier.Letter#doAction()
	 */
	public void doAction() {
		/* No action for thanks letter */
	}
	
	
	/**
	 * @see courrier.Letter#toString()
	 */
	public String toString() {
		return "a thanks letter which is " + super.toString();
	}
	
}

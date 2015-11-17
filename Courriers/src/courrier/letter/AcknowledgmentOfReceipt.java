/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.letter;

import courrier.Inhabitant;
import courrier.content.Text;

/**
 * Class defining the AcknowledgmentOfReceipt
 */
public class AcknowledgmentOfReceipt extends SimpleLetter {

	/**
	 * Constructor for the AcknowledgementOfReceipt class<br>
	 * Is sent automatically when an inhabitant receives a RegisteredLetter
	 * @param sender
	 * @param receiver
	 * @param content
	 */
	public AcknowledgmentOfReceipt(Inhabitant sender, Inhabitant receiver, Text content) {
		super(sender, receiver, content);
	}
	
	
	/**
	 * @see courrier.Letter#doAction()
	 */
	@Override
	public void doAction() {
		/* No action for acknowledgment of receipt */
	}
	
	
	/**
	 * @see courrier.Letter#toString()
	 */
	@Override
	public String toString() {
		return "an acknowledgement of receipt which is " + super.toString();
	}

}

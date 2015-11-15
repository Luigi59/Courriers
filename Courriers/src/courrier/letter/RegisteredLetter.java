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
 * Class defining the RegisteredLetter
 */
public class RegisteredLetter extends LetterDecorator {
	
	// Attributes
	
	public static final int OVERCOST = 15;

	// Methods
	
	/**
	 * Constructor for the RegisteredLetter class
	 * @param sender
	 * @param receiver
	 * @param letter
	 * @throws IllegalArgumentReception
	 */
	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) throws IllegalArgumentException {
		super(sender, receiver, letter);
		if(letter instanceof RegisteredLetter)
			throw new IllegalArgumentException("letter is an RegisteredLetter");
		else if(letter instanceof UrgentLetter)
			throw new IllegalArgumentException("letter is an UrgentLetter");
	}


	/**
	 * @see courrier.Letter#doAction()
	 */
	public void doAction() {
		this.content.doAction();
		Text text = new Text("Acknowledgment of receipt for " + this);
		AcknowledgmentOfReceipt aor = new AcknowledgmentOfReceipt(this.receiver, this.sender, text);
		this.receiver.getCity().sendLetter(aor);
	}


	/**
	 * @see courrier.Letter#getCost()
	 */
	public int getCost() {
		return this.content.getCost() + RegisteredLetter.OVERCOST;
	}

	
	/**
	 * @see courrier.Letter#toString()
	 */
	public String toString() {
		return "a registered letter whose content is " + this.content;
	}

}

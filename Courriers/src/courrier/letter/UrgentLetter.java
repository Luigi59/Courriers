/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.letter;

import courrier.Inhabitant;
import courrier.Letter;

/**
 * Class defining the UrgentLetter
 */
public class UrgentLetter extends LetterDecorator {
	
	// Attributes
	
	public static final int COSTFACTOR = 2;
	
	// Methods
	
	/**
	 * Constructor for the UrgentLetter class
	 * @param sender
	 * @param receiver
	 * @param letter
	 * @throws IllegalArgumentReception
	 */
	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> letter) throws IllegalArgumentException {
		super(sender, receiver, letter);
		if(letter instanceof UrgentLetter)
			throw new IllegalArgumentException("letter is an UrgentLetter");
	}

	
	/**
	 * @see courrier.Letter#doAction()
	 */
	public void doAction() {
		this.content.doAction();
	}

	
	/**
	 * @see courrier.Letter#getCost()
	 */
	public int getCost() {
		return this.content.getCost() * UrgentLetter.COSTFACTOR;
	}

	
	/**
	 * @see courrier.Letter#toString()
	 */
	public String toString() {
		return "an urgent letter whose content is " + this.content;
	}

}

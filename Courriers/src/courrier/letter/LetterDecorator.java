/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.letter;

import courrier.Inhabitant;
import courrier.Letter;

/**
 * Class defining the LetterDecorator
 */
public abstract class LetterDecorator extends Letter<Letter<?>> {

	/**
	 * Constructor for the LetterDecorator class
	 * @param sender
	 * @param receiver
	 * @param letter
	 */
	public LetterDecorator(Inhabitant sender, Inhabitant receiver, Letter<?> letter) {
		super(sender, receiver, letter);
	}
	
}

/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.letter;

import courrier.Inhabitant;
import courrier.Letter;
import courrier.content.Money;
import courrier.content.Text;

public class PromissoryNote extends Letter<Money> {

	/**
	 * Constructor for the PromissoryNote class
	 * @param sender
	 * @param receiver
	 * @param content
	 */
	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Money content) {
		super(sender, receiver, content);
	}
	
	
	/**
	 * @see courrier.Letter#doAction()
	 */
	public void doAction() {
		this.sender.debit(this.content.getAmount());
		this.receiver.credit(this.content.getAmount());
		Text text = new Text("Thanks for " + this);
		ThanksLetter thanks = new ThanksLetter(this.receiver, this.sender, text);
		this.receiver.getCity().sendLetter(thanks);
	}

	
	/**
	 * @see courrier.Letter#getCost()
	 */
	public int getCost() {
		return this.content.getAmount()/100 + SimpleLetter.SIMPLE_LETTER_COST;
	}

	
	/**
	 * @see courrier.Letter#toString()
	 */
	public String toString() {
		return "a promissory note letter whose content is " + this.content;
	}
	
}

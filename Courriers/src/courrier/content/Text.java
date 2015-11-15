/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package courrier.content;

import courrier.Content;

/**
 * Class defining the Text
 */
public class Text implements Content {

	// Attributes
	protected String text;
	
	// Methods
	
	/**
	 * Constructor for the Text class
	 * @param text
	 */
	public Text(String text) {
		this.text = text;
	}
	
	
	/**
	 * Returns the text
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	
	/**
	 * Returns a String defining the Text
	 * 
	 * @return a String defining the Text
	 */
	public String toString() {
		return "a text content (" + this.getText() + ")";
	}
	
}

package test;

import static org.junit.Assert.*;

import courrier.content.Text;
import courrier.letter.SimpleLetter;

public class SimpleLetterTest extends LetterTest {

	Text text;
	
	@Override
	public void createLetter() {
		super.createLetter();
		text = new Text("bla bla");
		letter = new SimpleLetter(sender, receiver, text);
	}

	
	@Override
	public void testDoAction() {
		/* Nothing to test for SimpleLetter.doAction() */
	}

	
	@Override
	public void testGetCost() {
		assertEquals(SimpleLetter.SIMPLE_LETTER_COST, letter.getCost());
	}

	
	@Override
	public void testGetContent() {
		assertEquals(text, letter.getContent());
	}
	
	
	@Override
	public void testToString() {
		assertEquals("a simple letter whose content is a text content (bla bla)", letter.toString());
	}


}

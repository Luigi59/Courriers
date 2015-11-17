package test;

import static org.junit.Assert.*;

import org.junit.Test;

import courrier.content.Text;
import courrier.letter.AcknowledgmentOfReceipt;
import courrier.letter.RegisteredLetter;
import courrier.letter.SimpleLetter;

public class AcknowledgmentOfReceiptTest extends SimpleLetterTest {

	RegisteredLetter rl;
	SimpleLetter sl;
	
	@Override
	public void createLetter() {
		super.createLetter();
		sl = new SimpleLetter(receiver, sender, new Text("bla bla"));
		rl = new RegisteredLetter(receiver, sender, sl);
		text = new Text("acknowledgment of receipt for " + rl);
		letter = new AcknowledgmentOfReceipt(sender, receiver, text);
	}
	
	
	@Override
	@Test
	public void testToString() {
		assertEquals("an acknowledgement of receipt which is a simple letter whose content is a text content (acknowledgment of receipt for a registered letter whose content is a simple letter whose content is a text content (bla bla))", letter.toString());
	}

}

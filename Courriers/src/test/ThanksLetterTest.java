package test;

import static org.junit.Assert.*;

import org.junit.Test;

import courrier.content.Money;
import courrier.content.Text;
import courrier.letter.PromissoryNote;
import courrier.letter.ThanksLetter;

public class ThanksLetterTest extends SimpleLetterTest{

	PromissoryNote pn;
	
	@Override
	public void createLetter() {
		super.createLetter();
		pn = new PromissoryNote(receiver, sender, new Money(100));
		text = new Text("thanks for " + pn);
		letter = new ThanksLetter(sender, receiver, text);
	}
	
	
	@Override
	@Test
	public void testToString() {
		assertEquals("a thanks letter which is a simple letter whose content is a text content (thanks for a promissory note letter whose content is a money content (100))", letter.toString())
;	}

}

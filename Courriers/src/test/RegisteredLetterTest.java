package test;

import static org.junit.Assert.*;

import org.junit.Test;

import courrier.content.Money;
import courrier.content.Text;
import courrier.letter.PromissoryNote;
import courrier.letter.RegisteredLetter;
import courrier.letter.SimpleLetter;
import courrier.letter.UrgentLetter;

public class RegisteredLetterTest extends LetterTest {

	SimpleLetter sl;
	PromissoryNote pn;
	RegisteredLetter letter2;
	
	@Override
	public void createLetter() {
		super.createLetter();
		sl = new SimpleLetter(sender, receiver, new Text("bla bla"));
		letter = new RegisteredLetter(sender, receiver, sl);
		pn = new PromissoryNote(sender, receiver, new Money(100));
		letter2 = new RegisteredLetter(sender, receiver, pn);
	}
	
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCannotContainsRegisteredLetter() {
		RegisteredLetter rl = new RegisteredLetter(sender, receiver, letter);
	}
	
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCannotContainsUrgentLetter() {
		UrgentLetter ul = new UrgentLetter(sender, receiver, letter);
		RegisteredLetter rl = new RegisteredLetter(sender, receiver, ul);
	}

	
	@Override
	public void testDoAction() {
		
		/* Before doAction */
		assertTrue(city.isEmpty());
	
		letter.doAction();
		/* After doAction */
		assertFalse(city.isEmpty());
	
	}

	
	@Override
	public void testGetCost() {
		assertEquals(RegisteredLetter.OVERCOST + SimpleLetter.SIMPLE_LETTER_COST, letter.getCost());
		assertEquals(RegisteredLetter.OVERCOST + SimpleLetter.SIMPLE_LETTER_COST + pn.getContent().getAmount()/100,  letter2.getCost());
	}

	
	@Override
	public void testGetContent() {
		assertEquals(sl, letter.getContent());	
		assertEquals(pn, letter2.getContent());
	}

	
	@Override
	public void testToString() {
		assertEquals("a registered letter whose content is a simple letter whose content is a text content (bla bla)", letter.toString());
		assertEquals("a registered letter whose content is a promissory note letter whose content is a money content (100)", letter2.toString());
	}

}

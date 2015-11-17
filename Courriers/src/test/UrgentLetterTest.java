package test;

import static org.junit.Assert.*;

import org.junit.Test;

import courrier.content.Money;
import courrier.content.Text;
import courrier.letter.PromissoryNote;
import courrier.letter.RegisteredLetter;
import courrier.letter.SimpleLetter;
import courrier.letter.UrgentLetter;

public class UrgentLetterTest extends LetterTest {

	UrgentLetter ul1; /* Simple Letter */
	UrgentLetter ul3; /* Promissory Note */
	UrgentLetter ul2; /* Registered Letter -> Simple Letter */
	UrgentLetter ul4; /* Registered Letter -> Promissory Note */
	
	RegisteredLetter rl1; /* Simple Letter */
	RegisteredLetter rl2; /* Promissory Note */
	
	SimpleLetter sl;
	PromissoryNote pn;
	
	@Override
	public void createLetter() {
		sl = new SimpleLetter(sender, receiver, new Text("bla bla"));
		pn = new PromissoryNote(sender, receiver, new Money(100));
		
		rl1 = new RegisteredLetter(sender, receiver, sl);
		rl2 = new RegisteredLetter(sender, receiver, pn);
	
		ul1 = new UrgentLetter(sender, receiver, sl);
		ul2 = new UrgentLetter(sender, receiver, pn);
		ul3 = new UrgentLetter(sender, receiver, rl1);
		ul4 = new UrgentLetter(sender, receiver, rl2);
		
		letter = ul1;
	}
	
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testCannotContainsUrgentLetter() {
		UrgentLetter ul = new UrgentLetter(sender, receiver, ul1);
	}

	@Override
	public void testDoAction() {

		/* Before doAction */
		assertTrue(city.isEmpty());
		
		ul1.doAction();
		/* After doAction 1 */
		assertTrue(city.isEmpty());
		
		//ul2.doAction();
		/* After doAction 2 */
		//assertFalse(city.isEmpty());
		
		//ul3.doAction();
		/* After doAction 3 */
		//assertFalse(city.isEmpty());
		
		//ul4.doAction();
		/* After doAction 4 */
		//assertFalse(city.isEmpty());
		
	}

	@Override
	public void testGetCost() {
		assertEquals(SimpleLetter.SIMPLE_LETTER_COST * UrgentLetter.COSTFACTOR, ul1.getCost());	
		assertEquals( (SimpleLetter.SIMPLE_LETTER_COST + pn.getContent().getAmount()/100) * UrgentLetter.COSTFACTOR, ul2.getCost());
		assertEquals( (SimpleLetter.SIMPLE_LETTER_COST + RegisteredLetter.OVERCOST) * UrgentLetter.COSTFACTOR, ul3.getCost());
		assertEquals( (SimpleLetter.SIMPLE_LETTER_COST + pn.getContent().getAmount()/100 + RegisteredLetter.OVERCOST) * UrgentLetter.COSTFACTOR, ul4.getCost()); 
	}

	@Override
	public void testGetContent() {
		assertEquals(sl, ul1.getContent());
		assertEquals(pn, ul2.getContent());
		assertEquals(rl1, ul3.getContent());
		assertEquals(rl2, ul4.getContent());
	}

	@Override
	public void testToString() {
		assertEquals("an urgent letter whose content is a simple letter whose content is a text content (bla bla)", ul1.toString());
		assertEquals("an urgent letter whose content is a promissory note letter whose content is a money content (100)", ul2.toString());
		assertEquals("an urgent letter whose content is a registered letter whose content is a simple letter whose content is a text content (bla bla)", ul3.toString());
		assertEquals("an urgent letter whose content is a registered letter whose content is a promissory note letter whose content is a money content (100)", ul4.toString());
	}

}

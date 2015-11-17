package test;

import static org.junit.Assert.*;

import org.junit.Test;

import courrier.content.Money;
import courrier.letter.PromissoryNote;
import courrier.letter.SimpleLetter;

public class PromissoryNoteTest extends LetterTest {

	Money money;
	
	@Override
	public void createLetter() {
		super.createLetter();
		money = new Money(100);
		letter = new PromissoryNote(sender, receiver, money);
	}


	@Override
	@Test
	public void testDoAction() {
		
		/* Before doAction */
		assertEquals(5000, sender.getBankAccount().getBalance());
		assertEquals(5000, receiver.getBankAccount().getBalance());
		assertTrue(city.isEmpty());
		
		letter.doAction();
		/* After doAction */
		assertEquals(4900, sender.getBankAccount().getBalance());
		assertEquals(5100 - SimpleLetter.SIMPLE_LETTER_COST, receiver.getBankAccount().getBalance());
		assertFalse(city.isEmpty());
		
	}


	@Override
	public void testGetCost() {
		assertEquals(SimpleLetter.SIMPLE_LETTER_COST + money.getAmount()/100, letter.getCost());
	}


	@Override
	public void testGetContent() {
		assertEquals(money, letter.getContent());
	}


	@Override
	public void testToString() {
		assertEquals("a promissory note letter whose content is a money content (" + money.getAmount() + ")", letter.toString());
	}

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import courrier.BankAccount;
import courrier.City;
import courrier.Inhabitant;
import courrier.Letter;

public abstract class LetterTest {
	
	protected Letter<?> letter;
	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected City city = new City("Racoon");
	
	@Before
	public void createLetter() {
		sender = new Inhabitant("sender", city, new BankAccount(5000));
		receiver = new Inhabitant("receiver", city, new BankAccount(5000));
	}

	@Test
	public abstract void testDoAction();
	
	@Test
	public abstract void testGetCost();
	
	@Test
	public abstract void testGetContent();

	@Test
	public abstract void testToString();

	
	@Test
	public void testGetSender() {
		assertEquals(sender, letter.getSender());
	}
	
	
	@Test
	public void testGetReceiver() {
		assertEquals(receiver, letter.getReceiver());
	}

}

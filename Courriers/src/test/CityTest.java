package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import courrier.BankAccount;
import courrier.City;
import courrier.Inhabitant;
import courrier.content.Text;
import courrier.letter.SimpleLetter;

public class CityTest {
	
	protected City city;
	protected Inhabitant titi, toto;
	
	@Before
	public void createCity() {
		city = new City("Racoon");
		titi = new Inhabitant("titi", city, new BankAccount(5000));
		toto = new Inhabitant("titi", city, new BankAccount(5000));
	}
	

	@Test
	public void testGetName() {
		assertEquals("Racoon", city.getName());
	}

	
	@Test
	public void testSendLetter() {
		assertTrue(city.isEmpty());
		assertEquals(5000, titi.getBankAccount().getBalance());
		SimpleLetter sl = new SimpleLetter(titi, toto, new Text("bla bla"));
		city.sendLetter(sl);
		assertFalse(city.isEmpty());
		assertEquals(5000 - SimpleLetter.SIMPLE_LETTER_COST, titi.getBankAccount().getBalance());
	}
	
	
	@Test
	public void testIsEmpty() {
		assertTrue(city.isEmpty());
		SimpleLetter sl = new SimpleLetter(titi, toto, new Text("bla bla"));
		city.sendLetter(sl);
		assertFalse(city.isEmpty());
	}
	
	
	@Test
	public void testDistributeLetters() {
		assertTrue(city.isEmpty());
		SimpleLetter sl = new SimpleLetter(titi, toto, new Text("bla bla"));
		city.sendLetter(sl);
		assertFalse(city.isEmpty());
		city.distributeLetters();
		assertTrue(city.isEmpty());
	}
	
}

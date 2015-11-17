package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import courrier.BankAccount;
import courrier.City;
import courrier.Inhabitant;
import courrier.Letter;
import courrier.content.Money;
import courrier.content.Text;
import courrier.letter.PromissoryNote;
import courrier.letter.SimpleLetter;

public class InhabitantTest {
	
	Inhabitant in, in2;
	City city;
	BankAccount bankAccount;
	
	@Before
	public void createInhabitant() {
		city = new City("Racoon");
		bankAccount = new BankAccount(5000);
		in = new Inhabitant("toto", city, bankAccount);
		in2 = new Inhabitant("titi", city, new BankAccount(5000));
	}
	
	
	@Test
	public void testGetCity() {
		assertEquals(city, in.getCity());
	}
	
	
	@Test
	public void testGetBankAccount() {
		assertEquals(bankAccount, in.getBankAccount());
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testSendLetter() {
		assertTrue(city.isEmpty());
		Letter l = new SimpleLetter(in, in2, new Text("bla bla"));
		in.sendLetter(l);
		assertFalse(city.isEmpty());
	}
	
	
	@Test
	public void testReceiveLetter() {
		assertEquals(5000, in.getBankAccount().getBalance());
		assertEquals(5000, in2.getBankAccount().getBalance());
		PromissoryNote pn = new PromissoryNote(in2, in, new Money(1000));
		in.receiveLetter(pn);
		assertEquals(6000 - SimpleLetter.SIMPLE_LETTER_COST, in.getBankAccount().getBalance());
		assertEquals(4000, in2.getBankAccount().getBalance());	
	}

}

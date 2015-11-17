package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import courrier.BankAccount;

public class BankAccountTest {
	
	protected BankAccount bankAccount;
	
	@Before
	public void createBankAccount() {
		bankAccount = new BankAccount(5000);
	}

	
	@Test
	public void testGetBalance() {
		assertEquals(5000, bankAccount.getBalance());
	}
	
	
	@Test
	public void testCredit() {
		assertEquals(5000, bankAccount.getBalance());
		bankAccount.credit(1000);
		assertEquals(6000, bankAccount.getBalance());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditNegativeValue() {
		bankAccount.credit(-1);
	}

	
	@Test
	public void testDebit() {
		assertEquals(5000, bankAccount.getBalance());
		bankAccount.debit(1000);
		assertEquals(4000, bankAccount.getBalance());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testDebitNegativeValue() {
		bankAccount.debit(-1);
	}
	
	
	@Test
	public void testToString() {
		assertEquals("5000 euros", bankAccount.toString());
	}
}

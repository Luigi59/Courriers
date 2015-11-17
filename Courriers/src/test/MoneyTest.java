/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import courrier.content.Money;

public class MoneyTest extends ContentTest {

	protected Money money;
	
	@Override
	public void createContent() {
		money = new Money(5);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testNegativeMoney() {
		money = new Money(-1);
	}
	
	
	@Test
	public void testGetAmount() {
		assertEquals(5, this.money.getAmount());
	}

	
	@Override
	@Test
	public void testToString() {
		assertEquals("a money content (5)", money.toString());
	}

}

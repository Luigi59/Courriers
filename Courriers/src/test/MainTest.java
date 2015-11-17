package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import courrier.Letter;
import courrier.Main;
import courrier.letter.PromissoryNote;
import courrier.letter.RegisteredLetter;
import courrier.letter.SimpleLetter;
import courrier.letter.UrgentLetter;

public class MainTest {
	
	Main main;
	
	@Before
	public void initialize() {
		main = new Main();
	}
	
	@Test
	public void testGetRandomInt() {
		for(int i=0; i<1000; ++i) {
			int x = main.getRandomInt(100);
			assertTrue(x >= 0 && x < 100);
		}
	}
	
	
	@Test
	public void testRandomBoolean() {
		for(int i=0; i<1000; ++i) {
			boolean x = main.randomBoolean();
			assertTrue(x == true ^ x == false);
		}
	}
	
	
	@Test
	public void testCreateRandomLetter() {
		for(int i=0; i<1000; ++i) {			
			Letter<?> l = main.createRandomLetter();
			assertTrue(l instanceof UrgentLetter ^ l instanceof RegisteredLetter
					^ l instanceof PromissoryNote ^ l instanceof SimpleLetter);
		}
	}

}

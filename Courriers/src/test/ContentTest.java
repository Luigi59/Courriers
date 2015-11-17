package test;

import org.junit.Before;
import org.junit.Test;

public abstract class ContentTest {

	@Before
	public abstract void createContent();
	
	@Test
	public abstract void testToString();

}

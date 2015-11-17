/**
 * TP Courriers
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import courrier.content.Text;

public class TextTest extends ContentTest {

	protected Text text;
	
	@Override
	public void createContent() {
		text = new Text("test");
	}


	@Test
	public void testGetText() {
		assertEquals("test", text.getText());
	}
	
	
	@Override
	public void testToString() {
		assertEquals("a text content (test)", text.toString());
	}

}

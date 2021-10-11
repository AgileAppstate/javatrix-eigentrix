/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestTrace {

	@Test
	public void testTraceCorrect(){
		Matrix base = new Matrix(5,5,5);
		
		assertEquals(base.trace(), 25);
	}

	@Test
	public void testTimeIllegalInput(){
		boolean result1 = true;

		Matrix badMatrix = new Matrix(3, 4, 2);
		try {
	      		badMatrix.trace();
	  	} 
		catch (IllegalArgumentException e) {
	      		// Should be thrown!
	      		result1 = true;
	  	} 
		catch (Exception e) {
	      		// Uh oh. Something unexpectedly bad happened...
	      		assertTrue(false);
	  	}

		assertTrue(result1);
	}
}

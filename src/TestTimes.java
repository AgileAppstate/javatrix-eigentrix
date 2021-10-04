/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestTimes {
	Matrix baseMatrix; 

	@BeforeEach
	public void init(){
		baseMatrix = new Matrix(5,5,2);
	}

	@Test
	public void testTimeCorrect(){
		Matrix multiply = new Matrix(5,1,5);
		multiply = baseMatrix.times(multiply);
		Matrix answer = new Matrix(5,1,50);
		
		assertTrue(multiply.equals(answer));
	}

	@Test
	public void testTimeIllegalInput(){
		boolean result1 = true;

		Matrix badMatrix = new Matrix(3, 3, 2);
		try {
	      		badMatrix.times(baseMatrix);
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

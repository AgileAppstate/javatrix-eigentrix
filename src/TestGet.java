/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestGet {

	@Test
	public void testGet1Correct(){
		Matrix base = Matrix.identity(5,5);
		int[] rows = {0,2,4};
		int[] cols = {1,3};
		Matrix getmat = base.getMatrix(rows, cols);
		
		double[][] answer = {{0,0},{0,0},{0,0}};
		Matrix realans = new Matrix(answer);		

		assertTrue(realans.equals(getmat));
	}

	@Test
	public void testGet1ArrayOutOfBoundsException(){
		boolean result1 = true;
		boolean result2 = true;
		boolean result3 = true;
		boolean result4 = true;

		Matrix base = Matrix.identity(5,5);
		try {				
			int[] rows = {-1};
			int[] cols = {1,3};
			Matrix getmat = base.getMatrix(rows, cols);
	  	} 
		catch (ArrayIndexOutOfBoundsException e) {
	      		// Should be thrown!
	      		result1 = true;
	  	} 
		catch (Exception e) {
	      		// Uh oh. Something unexpectedly bad happened...
	      		assertTrue(false);
	  	}

		assertTrue(result1);

		try {				
			int[] rows = {6};
			int[] cols = {1,3};
			Matrix getmat = base.getMatrix(rows, cols);
	  	} 
		catch (ArrayIndexOutOfBoundsException e) {
	      		// Should be thrown!
	      		result2 = true;
	  	} 
		catch (Exception e) {
	      		// Uh oh. Something unexpectedly bad happened...
	      		assertTrue(false);
	  	}

		assertTrue(result2);

		try {				
			int[] rows = {3};
			int[] cols = {-3,3};
			Matrix getmat = base.getMatrix(rows, cols);
	  	} 
		catch (ArrayIndexOutOfBoundsException e) {
	      		// Should be thrown!
	      		result3 = true;
	  	} 
		catch (Exception e) {
	      		// Uh oh. Something unexpectedly bad happened...
	      		assertTrue(false);
	  	}

		assertTrue(result3);

		try {				
			int[] rows = {3};
			int[] cols = {3,39};
			Matrix getmat = base.getMatrix(rows, cols);
	  	} 
		catch (ArrayIndexOutOfBoundsException e) {
	      		// Should be thrown!
	      		result4 = true;
	  	} 
		catch (Exception e) {
	      		// Uh oh. Something unexpectedly bad happened...
	      		assertTrue(false);
	  	}

		assertTrue(result4);


	}
}

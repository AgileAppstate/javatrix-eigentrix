/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestSet {

	@Test
	public void testSet1Correct(){
		Matrix base = Matrix.identity(5,5);
		int[] rows = {0,2,4};
		int[] cols = {1,3};

		double[][] replacemnt = {{1,1},{1,1},{1,1}};
		Matrix replacement = new Matrix(replacemnt);

		base.setMatrix(rows, cols, replacement);

		
		double[][] answer = {{1,1,0,1,0},{0,1,0,0,0},{0,1,1,1,0},{0,0,0,1,0},{0,1,0,1,1}};

		Matrix realans = new Matrix(answer);		

		assertTrue(realans.equals(base));
	}

	@Test
	public void testSet1ArrayOutOfBoundsException(){
		boolean result1 = true;
		boolean result2 = true;
		boolean result3 = true;
		boolean result4 = true;

		Matrix base = Matrix.identity(5,5);
		Matrix start = base;
		double[][] javaerror = {{1,1}};
		Matrix temp = new Matrix(javaerror);
		try {				
			int[] rows = {-1};
			int[] cols = {1,3};
			base.setMatrix(rows, cols, temp);
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
			base.setMatrix(rows, cols, temp);
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
			base.setMatrix(rows, cols, temp);
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
			base.setMatrix(rows, cols, temp);
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

		assertTrue(start.equals(base));


	}
}

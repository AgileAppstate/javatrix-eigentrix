/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestDivide {
	Matrix baseMatrix; 

	@BeforeEach
	public void init(){
		baseMatrix = new Matrix(3,3,2);
	}

	@Test
	public void testRightDivideCorrect(){
		double[][] basearr = {{1,2,3},{4,5,6},{7,8,9}};
		Matrix divide = new Matrix(basearr);
		Matrix methodrpl = baseMatrix.arrayRightDivide(divide);
		
		double[][] answerarr = {{2./1,2./2,2./3},{2./4,2./5,2./6},{2./7,2./8,2./9}};
		Matrix answer = new Matrix(answerarr);

		answer.print(3,1);
		methodrpl.print(3,1);

		assertTrue(methodrpl.equals(answer));
	}

	@Test
	public void testRightDivideIllegalInput(){
		boolean result1 = true;

		Matrix badMatrix = new Matrix(3, 2, 2);
		try {
	      		badMatrix.arrayRightDivide(baseMatrix);
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

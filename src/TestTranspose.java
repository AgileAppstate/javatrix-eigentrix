/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestTranspose {

	@Test
	public void testTransposeCorrect(){
		double[][] basearr = {{1,2,3},{4,5,6}};
		Matrix base = new Matrix(basearr);
		Matrix baset = base.transpose();
		double[][] thing = {{1,4},{2,5},{3,6}};
		Matrix answer = new Matrix(thing);
		
		assertTrue(answer.equals(baset));
	}
}

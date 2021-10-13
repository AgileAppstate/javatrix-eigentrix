/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import javatrix.*;

public class TestNorm {

	@Test
	public void testInfNorm(){
		double[][] basearr = {{1,2,3},{4,5,6},{7,8,9}};
		Matrix base = new Matrix(basearr);
		
		assertEquals(base.normInf(), 24);
	}
}

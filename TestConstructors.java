/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestConstructors {
      @Test
      public void testConstructor1_positive() {
	  // Tests "normal" usages...

	  // Test #1: m > n
	  Matrix m1 = new Matrix(4, 3, 2.1);
	  
	  // Test #2: n > m
	  Matrix m2 = new Matrix(3, 4, -5.6);
	  
	  // Test #3: n == m
	  Matrix m3 = new Matrix(2, 2, 0.0);

	  // for now, can only test that it seems to complete properly
	  // will need to add more facets to this test when other 
	  // features are implemented: checking dimensions, number of elements,
	  // values of elements, etc.
	  assertTrue(true);
      }

      @Test
      public void testConstructor1_negative() {
	  // Tests "abnormal" usages...
	  boolean result1=false, result2=false, result3=false;

	  // Test #1: m is negative
	  try {
	      Matrix m1 = new Matrix(-4, 3, 2.1);
	  } catch (NegativeArraySizeException e) {
	      // Yay! Matrix should throw this exception!
	      result1 = true;
	  }
	  catch (Exception e) {
	      // Uh oh. Something unexpectedly bad happened...
	      assertTrue(false);
	  }
	  
	  // Test #2: n is negative
	  try {
	      Matrix m2 = new Matrix(3, -4, 5.6);
	  } catch (NegativeArraySizeException e) {
	      // Yay! Matrix should throw this exception!
	      result2 = true;
	  }
	  catch (Exception e) {
	      // Uh oh. Something unexpectedly bad happened...
	      assertTrue(false);
	  }
	  
	  // Test #3: both are negative
	  try {
	      Matrix m3 = new Matrix(-2, -2, 3.3);
	  } catch (NegativeArraySizeException e) {
	      // Yay! Matrix should throw this exception!
	      result3 = true;
	  }
	  catch (Exception e) {
	      // Uh oh. Something unexpectedly bad happened...
	      assertTrue(false);
	  }

	  // make sure expected exceptions were thrown
	  assertTrue(result1 && result2 && result3);
      }
}

/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import javatrix.*;

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

	  // Test #4: either n,m are 0 leads to [0][0] matrix, but is legal!
	  Matrix m4 = new Matrix(0, 2, 1.1);
	  Matrix m5 = new Matrix(2, 0, 1.1);
	  Matrix m6 = new Matrix(0, 0, 1.1);

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

      @Test
      public void testConstructor2_positive() {
	  // Tests "normal" usages...
	  // Matrix(double[][]values)
	  
	  // m==n
	  double[][] vals1 = {{1.,2.,3},{4.,5.,6.},{7.,8.,9.}};
	  Matrix m1 = new Matrix(vals1);

	  // m<n
	  double[][] vals2 = {{1.,2.,3},{4.,5.,6.}};
	  Matrix m2 = new Matrix(vals2);

	  // m>n
	  double[][] vals3 = {{1.,2.},{4.,5.},{7.,8.}};
	  Matrix m3 = new Matrix(vals3);

	  // Test #4: n is empty
	  double[][] vals4 = {{},{},{}};
	  Matrix m4 = new Matrix(vals4);


	  // for now, can only test that it seems to complete properly
	  // will need to add more facets to this test when other 
	  // features are implemented: checking dimensions, number of elements,
	  // values of elements, etc.
	  assertTrue(true);
      }

      @Test
      public void testConstructor2_negative() {
	  // Tests "abnormal" usages...
	  boolean result1=false, result2=false, result3=false;

	  // Test #1: unequal sizes
	  double[][] A = {{1.},{2.1, 2.2}};
	  try {
	      Matrix m1 = new Matrix(A);
	  } catch (IllegalArgumentException e) {
	      // Yay! Matrix should throw this exception!
	      result1 = true;
	  }
	  catch (Exception e) {
	      // Uh oh. Something unexpectedly bad happened...
	      assertTrue(false);
	  }
	  
	  assertTrue(result1);
      }

      @Test
      public void testIdentity_square() {
	Matrix id = Matrix.identity(5,5);
	assertEquals(id.trace(), 5);	

      }

      @Test
      public void testIdentity_Nonsquare() {
	Matrix id = Matrix.identity(3,2);
	double[][] temp = {{1,0},{0,1},{0,0}};
	Matrix base = new Matrix(temp);
	assertTrue(id.equals(base));	
      }


}

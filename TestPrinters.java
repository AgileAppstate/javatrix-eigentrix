/* 
 * JUnit5 test class
 */

// Stuff for JUnit
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

// Stuff to redirect System.out for testing purposes.
import java.lang.IllegalArgumentException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

// Stuff we are testing
import javatrix.*;

public class TestPrinters {

    private static PrintStream origOut;
    private static ByteArrayOutputStream baos;
    private static PrintStream newOut;

    private void redirectOut() {
	// Save current System.out and set to new stream we can read.
	origOut = System.out;
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
    }
    private void restoreOut() {
	System.setOut(origOut);
    }
    private String getOutput() {
	System.out.flush();
	return baos.toString();
    }

      @Test
      public void testPrint1_positive() {
	  // Tests print(int w, int d)
	  // Tests "normal" usages...

	  redirectOut();

	  // Test #1: print(5,2)
	  Matrix m1 = new Matrix(2, 2, 2.1);
	  m1.print(5,2);
	  String actualOutput = getOutput();
	  String expectedOutput = "  2.10  2.10\n  2.10  2.10\n";
	  assertEquals(expectedOutput, actualOutput);

	  restoreOut();
      }



}

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

public class TestTestTrix {

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
      public void TestTestTrix() {

	  redirectOut();

	  // Run the file
	  try {
	    String[] args = new String[0];
	    Testtrix.main(args);
	  }
	  catch (Exception e) {
	    assertTrue(false);	    
	  }

	  String actualOutput = getOutput();
	  String expectedOutput = "    1.0000    2.0000    3.0000\n    4.0000    5.0000    6.0000\n    7.0000    8.0000    9.0000\nx\n    1.0000\n    1.0000\n    1.0000\n=\n    6.0000\n   15.0000\n   24.0000\n";
	  assertEquals(expectedOutput, actualOutput);

	  restoreOut();
      }
}

/**
 * Matrix.java
 *
 * CS 5666 Javatrix assignment.
 *
 * @author EigenTrix (Jay Fenwick)
 * @version Fall 2021
 *
 * COPYRIGHT (C) EigenTrix CS5666 team. All Rights Reserved.
 */

/**
 * A Matrix ADT for Java.
 *
 * Java does not provide a Matrix abstract data type, so building
 * it ourselves.
 * Spec defined at:
 * https://cs.appstate.edu/~jbf/classes/cs5666/Javatrix/
 *
 * @author EigenTrix (Jay Fenwick)
 * @version Fall 2021
 */

public class Matrix {
    private int numRows;
    private int numCols;
    private double[][] data;


    /**
     * Constructs an m-by-n constant matrix of given scalar value.
     *
     * @param m - Number of rows.
     * @param n - Number of columns.
     * @param s - Fill the matrix with this scalar value.
     * @throws NegativeArraySizeException if m or n are negative.
     */
    public Matrix(int m, int n, double s) {
	if (m < 0 || n < 0) {
	    throw new NegativeArraySizeException("matrix dimension < 0");
	}
	numRows = m;
	numCols = n;
	data = new double[numRows][];
	for (int i = 0; i < numRows; i++) {
	    data[i] = new double[numCols];
	    for (int j = 0; j < numCols; j++) {
		data[i][j] = s;
	    }
	}
    }


    /**
     * Constructs an m-by-n matrix from a 2-D array of values.
     *
     * @param A - Two-dimensional array of doubles.
     * @throws IllegalArgumentException - All rows must have the same length.
     */
    public Matrix(double[][] A) {

	numRows = A.length;
	numCols = A[0].length;

	data = new double[numRows][];
	for (int i = 0; i < numRows; i++) {
	    if (A[i].length != numCols) {
		throw new IllegalArgumentException("Rows must have same size");
	    }

	    data[i] = new double[numCols];
	    for (int j = 0; j < numCols; j++) {
		data[i][j] = A[i][j];
	    }
	}
    }
}

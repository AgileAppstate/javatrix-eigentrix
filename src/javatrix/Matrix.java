/**
 * Matrix.java
 *
 * CS 5666 Javatrix assignment.
 *
 * @author EigenTrix (Jay Fenwick, Abdel Issa)
 * @version Fall 2021
 *
 * COPYRIGHT (C) EigenTrix CS5666 team. All Rights Reserved.
 */


package javatrix;

/**
 * A Matrix ADT for Java.
 *
 * Java does not provide a Matrix abstract data type, so building
 * it ourselves.
 * Spec defined at:
 * https://cs.appstate.edu/~jbf/classes/cs5666/Javatrix/
 *
 * @author EigenTrix (Jay Fenwick, Abdel Issa)
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

    /**
     * Print the matrix to stdout. 
     *
     * Line the elements up in columns with a Fortran-like 'Fw.d' style format.
     *
     * @param w - Column width.
     * @param d - Number of digits after the decimal.
     */
    public void print(int w, int d) {
	String format = "%" + (w + 1) + "." + d + "f";
	for (int i = 0; i < numRows; i++) {
	    for (int j = 0; j < numCols; j++) {
		System.out.printf(format, data[i][j]);
	    }
	    System.out.println();
	}
    }

    /**
     * Multiplies a matrix with a second Matrix.
     *
     * @param B - Two-dimensional array of doubles.
     * @throws IllegalArgumentException - Matrix inner dimensions must agree.
     * @return Matrix which represents the answer of the multiplication.
     */
    public Matrix times(Matrix B) {

	if (this.numCols != B.numRows) {
	    throw new IllegalArgumentException("Matrix inner"
	      + "dimensions must agree");
	}

	double[][] answer = new double[this.numRows][B.numCols];

	for (int i = 0; i < this.numRows; i++) {
	    double[] row = this.getRow(i);
	    for (int j = 0; j < B.numCols; j++) {
		answer[i][j] = dotProduct(row, B.getColumn(j));
	    }
	}

	return new Matrix(answer);
    }

    /**
     * Dot product for two vectors.
     *
     * @param row - Row Vector.
     * @param column - Column Vector.
     * @throws IllegalArgumentException - Can't Calculate dot
     * product of different size vectors. 
     * @return Dot product of the two vectors.
     */
    private double dotProduct(double[] row, double[] column) {
	if (row.length != column.length) {
	    throw new IllegalArgumentException("Can't Calculate dot" 
		+ "product of different size vectors");
	}
	double answer = 0;
	for (int i = 0; i < row.length; i++) {
	    answer += row[i] * column[i];
	}
	return answer;
    }

    /**
     * Return Row from the Matrix.
     *
     * @param index  - Row Index.
     * @return Row at the index.
     */
    public double[] getRow(int index) {
	double[] answer = new double[this.numCols];
	for (int i = 0; i < this.numCols; i++) {
	    answer[i] = this.data[index][i];
	}
	return answer;
    }

    /**
     * Return Column from the Matrix.
     *
     * @param index  - Column Index.
     * @return Column at the index.
     */
    public double[] getColumn(int index) {
	double[] answer = new double[this.numRows];
	for (int i = 0; i < this.numRows; i++) {
	    answer[i] = this.data[i][index];
	}
	return answer;
    }


    /**
     * Compares two Matrices.
     *
     * @param A - Matrix.
     * @return Result of comparing A and this.
     */
    public boolean equals(Matrix A) {
	if (A.numRows != this.numRows || A.numCols != this.numCols) {
	    return false;
	}

	for (int i = 0; i < this.numRows; i++) {
	    for (int j = 0; j < this.numCols; j++) {
	        if (A.data[i][j] != this.data[i][j]) {
	            return false;
	        }
            }
        }
        return true;
    }

    /**
     * Sum of the diagonal elements.
     * @throws IllegalArgumentException - Can't Calculate dot
     * product of different size vectors. 
     * @return double representing the sum.
     */
    public double trace() {
	if (this.numRows != this.numCols) {
	    throw new IllegalArgumentException("Can't take the trace of a non-square matrix");
	}
	double answer = 0;
	for (int i = 0; i < this.numRows; i++) {
	    answer += this.data[i][i];
	}
	return answer;
    }

    

    /**
     * Generate Identity Matrix.
     *
     * @param m - Number of rows.
     * @param n - Number of columns.
     * @return m-by-n matrix with 1s on the diagonal.
     */
    public static Matrix identity(int m, int n) {
	int smaller = (m > n) ? n : m;
	Matrix A = new Matrix(m, n, 0);
	for (int i = 0; i < smaller; i++) {
	    A.data[i][i] = 1;
	} 
	return A;
    }

	public Matrix getMatrix(int[] r, int[] c){
		if(r.length == 0 || c.length == 0){
			return new Matrix(0,0,0);
		}
		double[][] answer = new double[r.length][c.length];
		int rows = 0;
		int col = 0;
		for(int i : r){
			if(i > this.numRows || i < 0){
				throw new ArrayIndexOutOfBoundsException("Row Indices are incorrect");
			}
			double[] row = getRow(i);
			for(int j : c){
				if(j > this.numCols || j < 0){
					throw new ArrayIndexOutOfBoundsException("Column Indices are incorrect");
				}
				answer[rows][col] = row[j];
				col++;
			}
			col = 0;
			rows++;
		}
		return new Matrix(answer);
	}

	public void setMatrix(int[] r, int[] c, Matrix in){
		if(r.length == 0 || c.length == 0){
			return;
		}
		int rows = 0;
		int col = 0;
		double[][] placeholder = this.data;
		for(int i : r){
			if(i > this.numRows || i < 0){
				this.data = placeholder;
				throw new ArrayIndexOutOfBoundsException("Row Indices are incorrect");
			}
			for(int j : c){
				if(j > this.numCols || j < 0){
					this.data = placeholder;
					throw new ArrayIndexOutOfBoundsException("Column Indices are incorrect");
				}
				this.data[i][j] = in.data[rows][col];
				col++;
			}
			col = 0;
			rows++;
		}	
	}

	public Matrix transpose() {
		double[][] base = new double[this.numCols][this.numRows];
		for(int i = 0; i < this.numCols; i++){
			base[i] = this.getColumn(i);
		}
		return new Matrix(base);
	}

	public double normInf() {
		double answer = -Double.MAX_VALUE;
		for(int i = 0; i < this.numRows; i++){
			double[] row = getRow(i);
			double temp = 0;
			for(double j : row){
				temp += j;
			}
			if(temp > answer){
				answer = temp;
			}
		}
		return answer;
	}


}

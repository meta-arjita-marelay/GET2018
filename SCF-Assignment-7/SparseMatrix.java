package SparseMatrix;

/**
 * 
 * @author Arjita
 *
 */
public class SparseMatrix {
	private int[][] sparseMatrix;// 2D array to store non-zero elements of
									// sparse matrix
	private int numberOfRows;// number of rows of input array
	private int numberOfCol;// number of columns of input array

	/**
	 * SparseMatrix is constructor of class which will initialise the sparse
	 * matrix array in which there will be two columns, first column will store
	 * value and second column will store the index This will decrease the space
	 * complexity.
	 * 
	 * @param inputArray
	 *            input sparse matrix
	 */
	public SparseMatrix(int[][] inputArray) {
		numberOfRows = inputArray.length;// number of rows of array
		numberOfCol = inputArray[0].length;// number of column of array
		int countElements = 0;// count the non zero elements of input matrix
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[i].length; j++) {
				if (inputArray[i][j] != 0) {
					countElements++;
				}
			}
		}
		sparseMatrix = new int[countElements][2];// first column will store
													// value, second will store
													// the index of that value
		int count = 0;
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfCol; j++) {
				if (inputArray[i][j] != 0) {
					sparseMatrix[count][0] = inputArray[i][j];
					sparseMatrix[count][1] = (i * numberOfCol) + j;// index will
																	// be stored
																	// with
																	// respective
																	// values
					count++;
				}
			}
		}
		// display(sparseMatrix);
	}

	public int[][] getSparseMatrix() {
		return sparseMatrix;
	}

	/**
	 * transposeMatrix will transpose the sparse matrix the complexity of
	 * transpose function will be O(n) where n is no. of non zero elements
	 * 
	 * @return transpose of sparse matrix
	 */
	public int[][] transposeMatrix() {
		int index, newIndex;// variables for calculation of index in sparse and
							// transpose matrix
		int row, column;// variables for calculation of location of respective
						// value in sparse matrix through index
		int[][] sparseArray = this.getSparseMatrix();
		int[][] transposeArray = new int[sparseArray.length][2];
		for (int i = 0; i < sparseArray.length; i++) {
			transposeArray[i][0] = sparseArray[i][0];// store the value as it is
			index = sparseArray[i][1];// fetch the index of i th value
			row = index / numberOfCol;
			column = index % numberOfCol;
			newIndex = column * numberOfRows + row;// new index for transpose
													// array
			transposeArray[i][1] = newIndex;
		}
		display(transposeArray);
		int[][] arr = sparseToNormal(transposeArray, numberOfCol, numberOfRows);
		return arr;
	}

	/**
	 * sparseToNormal method will convert the sparse matrix which stores the
	 * value and index to normal matrix with all the zeroes
	 * 
	 * @param sparseArray
	 *            2D array which is to be converted to normal matrix
	 * @param row
	 *            number of rows of converted matrix
	 * @param column
	 *            number of columns of converted matrix
	 * @return 2D sparse array
	 */
	public int[][] sparseToNormal(int[][] sparseArray, int row, int column) {
		int elementRow, elementCol;
		int[][] normalArray = new int[row][column];
		for (int i = 0; i < sparseArray.length; i++) {
			elementRow = sparseArray[i][1] / column;
			elementCol = sparseArray[i][1] % column;
			normalArray[elementRow][elementCol] = sparseArray[i][0];
		}
		return normalArray;
	}

	/**
	 * display method
	 * 
	 * @param array
	 *            2d array which is to be printed
	 */
	private static void display(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * this method will check if required index is present in array
	 * 
	 * @param array
	 *            in which index is to be checked
	 * @param index
	 *            which is to be checked in array
	 * @return index of array if present otherwise -1
	 */
	public int searchIndex(int[][] array, int index) {
		for (int i = 0; i < array.length; i++) {
			if (array[i][1] == index) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * this method check the symmetricity of sparse matrix complexity of
	 * checkSymmetric will be O(n^2)
	 * 
	 * @return true if matrix is symmetric otherwise false
	 */
	public boolean checkSymmetric() {
		if (this.numberOfRows != this.numberOfCol) {
			return false;
		}
		for (int i = 0; i < sparseMatrix.length; i++) {
			int index = sparseMatrix[i][1];
			int row = index / numberOfCol;
			int col = index % numberOfCol;
			int newIndex = col * numberOfRows + row;
			int nextIndex = searchIndex(sparseMatrix, newIndex);
			if (nextIndex == -1) {
				return false;
			}
			if (sparseMatrix[i][0] != sparseMatrix[nextIndex][0]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * add two sparse matrix complexity of addSparse will be O(n^2)
	 * 
	 * @param sparse1
	 *            object of first sparse matrix
	 * @return object of resultant sparse matrix
	 */
	public SparseMatrix addSparse(SparseMatrix sparse1) {
		if (this.numberOfRows != sparse1.numberOfRows
				|| this.numberOfCol != sparse1.numberOfCol) {
			throw new AssertionError("invalid arrays");
		}
		int[][] arr1 = this.getSparseMatrix();
		int[][] arr2 = sparse1.getSparseMatrix();
		int[][] normal1 = sparseToNormal(arr1, numberOfRows, numberOfCol);
		int[][] normal2 = sparseToNormal(arr2, numberOfRows, numberOfCol);
		int[][] arr3 = new int[numberOfRows][numberOfCol];
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[0].length; j++) {
				arr3[i][j] = normal1[i][j] + normal2[i][j];
			}
		}
		SparseMatrix s2 = new SparseMatrix(arr3);

		return s2;
	}

	/**
	 * multiply two sparse matrix complexity of mulSparse will be O(n^3)
	 * 
	 * @param sparse1
	 *            object of sparse matrix
	 * @return sparseMatrix object of resultant array
	 */
	public SparseMatrix mulSparse(SparseMatrix sparse1) {
		if (this.numberOfCol != sparse1.numberOfRows) {
			throw new AssertionError("invalid arrays");
		}
		int[][] array1 = this.getSparseMatrix();
		int[][] array2 = sparse1.getSparseMatrix();
		int[][] normal1 = sparseToNormal(array1, numberOfRows, numberOfCol);
		int[][] normal2 = sparseToNormal(array2, numberOfRows, numberOfCol);
		int[][] array3 = new int[this.numberOfRows][sparse1.numberOfCol];
		for (int i = 0; i < this.numberOfRows; i++) {
			for (int j = 0; j < sparse1.numberOfCol; j++) {
				for (int k = 0; k < this.numberOfCol; k++) {
					array3[i][j] += normal1[i][k] * normal2[k][j];
				}
			}
		}
		SparseMatrix s2 = new SparseMatrix(array3);

		return s2;
	}
}

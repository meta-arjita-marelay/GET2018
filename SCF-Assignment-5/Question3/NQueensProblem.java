package Question3;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chess board so
 * that no two queens attack each other. (Thus, a solution requires that no two
 * queens share the same row, column, or diagonal)
 * 
 * 
 * @author Arjita
 *
 */
public class NQueensProblem {
	/**
	 * 
	 * check if queens can be placed in square matrix of given dimension when no
	 * queen will attack each other.
	 * 
	 * @param board
	 *            square matrix in which queens need to be placed
	 * @param startRow
	 *            row in which queen is to be placed
	 * @param dimensionOfMatrix
	 *            matrix dimension
	 * @return true if queens can be placed when no queen attack each other
	 *         otherwise false
	 */
	public static boolean nQueen(int[][] board, int startRow,
			int dimensionOfMatrix) {
		// check if all queens are placed
		if (startRow == dimensionOfMatrix) {
			// print the placed queen
			for (int i = 0; i < dimensionOfMatrix; i++) {
				for (int j = 0; j < dimensionOfMatrix; j++) {
					System.out.print(board[i][j]);
				}
				System.out.println("");
			}
			return true;

		} else {
			for (int column = 0; column < dimensionOfMatrix; column++) {
				// check if queen is safe
				if (isQueenSafe(board, startRow, column)) {
					board[startRow][column] = 1;// place the queen
					// call method recusively for next row
					if (nQueen(board, ++startRow, dimensionOfMatrix)) {
						return true;
					} else {
						board[--startRow][column] = 0;
					}
				}
			}

		}
		return false;
	}

	/**
	 * 
	 * check if queen is safe if placed in given row and column
	 * 
	 * @param board
	 *            square matrix in which queens need to be placed
	 * @param row
	 *            in which queen need to be placed
	 * @param column
	 *            in which queen need to be placed
	 * @return true if queen is safe in thatlocation otherwise false
	 */
	public static boolean isQueenSafe(int[][] board, int row, int column) {
		// check for row
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		// check for column
		for (int i = 0; i <= row; i++) {
			if (board[i][column] == 1) {
				return false;
			}
		}
		// check for upper left
		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		// check for upper right
		for (int i = row, j = column; j < board.length && i >= 0; j++, i--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
}

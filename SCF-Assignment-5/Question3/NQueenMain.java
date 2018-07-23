package Question3;

public class NQueenMain {

	public static void main(String[] args) {
		int[][] board = new int[4][4];
		boolean result = NQueensProblem.nQueen(board, 0, 4);
		System.out.println(result);
	}
}

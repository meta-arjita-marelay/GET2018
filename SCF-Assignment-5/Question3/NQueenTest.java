package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQueenTest {

	@Test
	public void testPositive() {
		int[][] board = new int[4][4];
		boolean result = NQueensProblem.nQueen(board, 0, 4);
		assertEquals(result, true);
	}

	@Test
	public void testNegative() {
		int[][] board = new int[3][3];
		boolean result = NQueensProblem.nQueen(board, 0, 3);
		assertEquals(result, false);
	}
}

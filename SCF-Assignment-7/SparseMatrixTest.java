package SparseMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	@Test
	public void testTransposePositive() {
		int[][] arr = new int[][] { { 0, 0, 0, 1, 0, 0 }, { 0, 2, 0, 3, 0, 0 },
				{ 0, 4, 0, 0, 0, 5 }, { 0, 0, 0, 0, 0, 6 } };
		SparseMatrix s1 = new SparseMatrix(arr);
		int[][] t = s1.transposeMatrix();
		int[][] resultArray = new int[][] { { 0, 0, 0, 0 }, { 0, 2, 4, 0 },
				{ 0, 0, 0, 0 }, { 1, 3, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 5, 6 } };
		assertArrayEquals(resultArray, t);
	}

	@Test
	public void testTransposeNegative() {
		int[][] arr = new int[][] { { 0, 0, 0, 1, 0, 2 }, { 0, 2, 0, 3, 0, 0 },
				{ 0, 4, 0, 0, 0, 5 }, { 0, 0, 5, 0, 0, 6 } };
		SparseMatrix s1 = new SparseMatrix(arr);
		int[][] t = s1.transposeMatrix();
		int[][] resultArray = new int[][] { { 0, 0, 0, 0 }, { 0, 2, 4, 0 },
				{ 0, 0, 0, 0 }, { 1, 3, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 5, 6 } };
		assertFalse(resultArray.equals(t));
	}

	@Test
	public void testSymmetricPositive() {
		int[][] arr1 = new int[][] { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 4 } };
		SparseMatrix s2 = new SparseMatrix(arr1);
		assertEquals(true, s2.checkSymmetric());
	}

	@Test
	public void testSymmetricNegative() {
		int[][] arr1 = new int[][] { { 0, 1, 0 }, { 1, 2, 0 }, { 0, 0, 4 } };
		SparseMatrix s2 = new SparseMatrix(arr1);
		assertNotEquals(false, s2.checkSymmetric());
	}

	@Test
	public void testAddSparseNegative() {
		int[][] arr1 = new int[][] { { 1, 0, 0 }, { 0, 1, 0 } };
		int[][] arr2 = new int[][] { { 1, 0, 0 }, { 0, 1, 0 } };
		SparseMatrix s2 = new SparseMatrix(arr1);
		SparseMatrix s3 = new SparseMatrix(arr2);
		SparseMatrix s4 = s3.addSparse(s2);
		int[][] result = s4.getSparseMatrix();
		int[][] finalResult = s4.sparseToNormal(result, 2, 3);
		int[][] expectedFinal = new int[][] { { 2, 1, 0 }, { 0, 2, 0 } };
		assertFalse(finalResult.equals(expectedFinal));
	}

	@Test
	public void testAddSparsePositive() {
		int[][] arr1 = new int[][] { { 1, 0, 0 }, { 0, 1, 0 } };
		int[][] arr2 = new int[][] { { 1, 0, 0 }, { 0, 1, 0 } };
		SparseMatrix s2 = new SparseMatrix(arr1);
		SparseMatrix s3 = new SparseMatrix(arr2);
		SparseMatrix s4 = s3.addSparse(s2);
		int[][] result = s4.getSparseMatrix();
		int[][] finalResult = s4.sparseToNormal(result, 2, 3);
		int[][] expectedFinal = new int[][] { { 2, 0, 0 }, { 0, 2, 0 } };
		assertArrayEquals(finalResult, expectedFinal);
	}

	@Test
	public void testMulSparsePositive() {
		int[][] arr1 = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] arr2 = new int[][] { { 1, 0 }, { 0, 1 } };
		SparseMatrix s2 = new SparseMatrix(arr1);
		SparseMatrix s3 = new SparseMatrix(arr2);
		SparseMatrix s4 = s3.mulSparse(s2);
		int[][] result = s4.getSparseMatrix();
		int[][] finalResult = s4.sparseToNormal(result, 2, 2);
		int[][] expectedFinal = new int[][] { { 1, 0 }, { 0, 1 } };
		assertArrayEquals(finalResult, expectedFinal);
	}

	@Test
	public void testMulSparseNegative() {
		int[][] arr1 = new int[][] { { 1, 0 }, { 0, 1 } };
		int[][] arr2 = new int[][] { { 1, 0 }, { 0, 1 } };
		SparseMatrix s2 = new SparseMatrix(arr1);
		SparseMatrix s3 = new SparseMatrix(arr2);
		SparseMatrix s4 = s3.mulSparse(s2);
		int[][] result = s4.getSparseMatrix();
		int[][] finalResult = s4.sparseToNormal(result, 2, 2);
		int[][] expectedFinal = new int[][] { { 1, 0 }, { 1, 1 } };
		assertFalse(finalResult.equals(expectedFinal));
	}
}
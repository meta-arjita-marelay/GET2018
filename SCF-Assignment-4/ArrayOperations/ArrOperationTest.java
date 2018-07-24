package ArrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void testMirrorPositive() {
		int[] array = new int[] { 1, 2, 3, 4, 3, 2, 1 };
		int result = ArrOperation.calculateLargestMirror(array);
		assertEquals(7, result);
	}

	@Test
	public void testMirrorNegative() {
		int[] array = new int[] { 1, 2, 3, 4, 3, 2, 1 };
		int result = ArrOperation.calculateLargestMirror(array);
		assertNotEquals(4, result);
	}

	@Test(expected = AssertionError.class)
	public void testMirrorError() {
		int[] array = new int[] {};
		int result = ArrOperation.calculateLargestMirror(array);
		assertEquals(7, result);
	}

	@Test
	public void testClumpsPositive() {
		int[] array = new int[] { 1, 2, 2, 2, 2, 3, 4, 4, 4, 3, 2, 1, 5, 6 };
		int result = ArrOperation.calculatearrayClumps(array);
		assertEquals(2, result);
	}

	@Test
	public void testClumpsNegative() {
		int[] array = new int[] { 1, 2, 2, 2, 2, 3, 4, 4, 4, 3, 2, 1, 5, 6 };
		int result = ArrOperation.calculatearrayClumps(array);
		assertNotEquals(3, result);
	}

	@Test(expected = AssertionError.class)
	public void testClumpsError() {
		int[] array = new int[] {};
		int result = ArrOperation.calculatearrayClumps(array);
		assertEquals(7, result);
	}

	@Test
	public void testFixXYPositive() {
		int[] array = new int[] { 1, 5, 4, 6, 5, 4, 3 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertArrayEquals(expectedArray, result);
	}

	@Test
	public void testFixXYNegative() {
		int[] array = new int[] { 1, 5, 4, 6, 5, 4, 3 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 2, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertFalse(expectedArray.equals(result));
	}

	@Test(expected = AssertionError.class)
	public void testFixXYunequalXy() {
		int[] array = new int[] { 1, 2, 4, 5, 6, 4, 7 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertEquals(expectedArray, result);
	}

	@Test(expected = AssertionError.class)
	public void testFixXYLastX() {
		int[] array = new int[] { 1, 2, 4, 5, 6, 4 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertEquals(expectedArray, result);
	}

	@Test(expected = AssertionError.class)
	public void testFixXYConsecutiveX() {
		int[] array = new int[] { 1, 2, 4, 5, 6, 4, 4, 7 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertEquals(expectedArray, result);
	}

	@Test
	public void testSplitFunctionPositive() {
		int[] array = new int[] { 2, 1, 1, 2 };
		int result = ArrOperation.calculateArraySplitFunction(array);
		assertEquals(2, result);
	}

	@Test
	public void testSplitFunctionNegative() {
		int[] array = new int[] { 2, 1, 1, 2 };
		int result = ArrOperation.calculateArraySplitFunction(array);
		assertNotEquals(3, result);
	}

	@Test(expected = AssertionError.class)
	public void testSplitFunctionError() {
		int[] array = new int[] {};
		int result = ArrOperation.calculateArraySplitFunction(array);
		assertEquals(2, result);
	}

}

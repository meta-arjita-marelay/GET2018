package ArrayOperations;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	@Test
	public void testForMirror() {
		int[] array = new int[] { 1, 2, 3, 4, 3, 2, 1 };
		int result = ArrOperation.calculateLargestMirror(array);
		assertEquals(7, result);
	}

	@Test(expected = AssertionError.class)
	public void testForMirrorError() {
		int[] array = new int[] {};
		int result = ArrOperation.calculateLargestMirror(array);
		assertEquals(7, result);
	}

	@Test
	public void testForClumps() {
		int[] array = new int[] { 1, 2, 2, 2, 2, 3, 4, 4, 4, 3, 2, 1, 5, 6 };
		int result = ArrOperation.calculatearrayClumps(array);
		assertEquals(2, result);
	}

	@Test(expected = AssertionError.class)
	public void testForClumpsError() {
		int[] array = new int[] {};
		int result = ArrOperation.calculatearrayClumps(array);
		assertEquals(7, result);
	}

	@Test
	public void testForFixXY() {
		int[] array = new int[] { 1, 5, 4, 6, 5, 4, 3 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertArrayEquals(expectedArray, result);
	}

	@Test(expected = AssertionError.class)
	public void testForFixXYunequalXy() {
		int[] array = new int[] { 1, 2, 4, 5, 6, 4, 7 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertEquals(expectedArray, result);
	}

	@Test(expected = AssertionError.class)
	public void testForFixXYLastX() {
		int[] array = new int[] { 1, 2, 4, 5, 6, 4 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertEquals(expectedArray, result);
	}

	@Test(expected = AssertionError.class)
	public void testForFixXYConsecutiveX() {
		int[] array = new int[] { 1, 2, 4, 5, 6, 4, 4, 7 };
		int[] expectedArray = new int[] { 1, 6, 4, 5, 3, 4, 5 };
		int[] result = ArrOperation.fixXY(4, 5, array);
		assertEquals(expectedArray, result);
	}

	@Test
	public void testForSplitFunction() {
		int[] array = new int[] { 2, 1, 1, 2 };
		int result = ArrOperation.calculateArraySplitFunction(array);
		assertEquals(2, result);
	}

	@Test(expected = AssertionError.class)
	public void testForSplitFunctionError() {
		int[] array = new int[] {};
		int result = ArrOperation.calculateArraySplitFunction(array);
		assertEquals(2, result);
	}

}

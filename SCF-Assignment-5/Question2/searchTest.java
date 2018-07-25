package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class searchTest {

	@Test
	public void testForLinearSearchPositive() {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int result = Searching.linearSearch(array, 3, 0);
		assertEquals(2, result);
	}

	@Test
	public void testForLinearSearchNegative() {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int result = Searching.linearSearch(array, 3, 0);
		assertNotEquals(4, result);
	}

	@Test
	public void testforBinarySearchPositive() {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		int result = Searching.binarySearch(array, 2, 1, 6);
		assertEquals(1, result);
	}

	@Test
	public void testforBinarySearchNegative() {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		int result = Searching.binarySearch(array, 2, 1, 6);
		assertNotEquals(6, result);
	}
}

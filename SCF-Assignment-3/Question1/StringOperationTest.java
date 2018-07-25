package Question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringOperationTest {
	StringOperations stringOperation = new StringOperations();

	@Test
	public void testCompareString() {
		boolean result1 = stringOperation.compareStrings("Arjita", "Arjita");
		assertEquals(result1, true);
		boolean result2 = stringOperation.compareStrings("Arjita", "Arjitaa");
		assertNotEquals(result2, true);
	}

	@Test
	public void testreverseString() {
		String result1 = stringOperation.reverseString("arjita");
		assertEquals(result1, "atijra");
		String result2 = stringOperation.reverseString("arjita");
		assertNotEquals(result2, "atijms");
	}

	@Test
	public void testChangeCase() {
		String result1 = stringOperation.changeCase("aRjiTa");
		assertEquals(result1, "ArJItA");
		String result2 = stringOperation.changeCase("aRjITa");
		assertNotEquals(result2, "ArJItA");
		String result3 = stringOperation.changeCase("aRjIT1a");
		assertNotEquals(result3, "ArJIt1A");
	}

	@Test
	public void testLargestWord() {
		String result1 = stringOperation
				.largestWord("madhav institute of technology and science");
		assertEquals(result1, "technology");
		String result2 = stringOperation
				.largestWord("madhav institute of technology and science");
		assertNotEquals(result2, "institute");
	}
}

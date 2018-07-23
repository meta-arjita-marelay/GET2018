package Hexadecimal;

import static org.junit.Assert.*;

import org.junit.Test;

public class HexCalcTest {
	Operations hexOperations = new Operations();

	@Test
	public void testForAdd() {
		String result = hexOperations.addHexadecimal("A", "5");
		assertEquals(result, "F");
	}

	@Test
	public void testForSubtract() {
		String result = hexOperations.subtractHexadecimal("A", "5");
		assertEquals(result, "5");
	}

	@Test
	public void testForMultiply() {
		String result = hexOperations.multiplyHexadecimal("A", "5");
		assertEquals(result, "32");
	}

	@Test
	public void testForDivide() {
		String result = hexOperations.divideHexadecimal("A", "2");
		assertEquals(result, "5");
	}

	@Test
	public void testForEqual() {
		boolean result = hexOperations.equalHexadecimal("A", "AB");
		assertNotEquals(result, true);
	}

	@Test
	public void testForEqualRemovingZero() {
		boolean result = hexOperations.equalHexadecimal("A", "0A");
		assertEquals(result, true);
	}

	@Test
	public void testForGreater() {
		boolean result = hexOperations.greaterHexadecimal("A", "0B");
		assertEquals(result, false);
	}

	@Test
	public void testForSmaller() {
		boolean result = hexOperations.smallerHexadecimal("A", "10");
		assertEquals(result, false);
	}

}

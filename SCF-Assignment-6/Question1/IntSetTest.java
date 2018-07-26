package Question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {

	int[] array = new int[] { 2, 3, 4, 5, 6, 7, 8, 9 };
	IntSet intSet = new IntSet(array);

	@Test
	public void testIsMemberPositive() {
		assertEquals(true, intSet.isMember(3));
	}

	@Test
	public void testIsMemberNegative() {
		assertNotEquals(true, intSet.isMember(10));
	}

	@Test
	public void testSizePositive() {
		assertEquals(8, intSet.size());
	}

	@Test
	public void testSizeNegative() {
		assertNotEquals(9, intSet.size());
	}

	@Test
	public void testIsSubSetPositive() {
		int[] arraySubSet = new int[] { 2, 3, 4 };
		IntSet subSet = new IntSet(arraySubSet);
		assertEquals(true, intSet.isSubSet(subSet));
	}

	@Test
	public void testIsSubSetNegative() {
		int[] arraySubSet = new int[] { 2, 3, 4, 10 };
		IntSet subSet = new IntSet(arraySubSet);
		assertNotEquals(true, intSet.isSubSet(subSet));
	}

	@Test
	public void testComplementPositive() {
		int[] arraySubSet = new int[] { 1, 10 };
		assertArrayEquals(arraySubSet, intSet.complement());
	}

	@Test
	public void testComplementNegative() {
		int[] arraySubSet = new int[] { 1, 10, 11 };
		assertFalse(arraySubSet.equals(intSet.complement()));
	}

	@Test
	public void testUnionPositive() {
		int[] set1 = new int[] { 2, 3, 4 };
		int[] set2 = new int[] { 2, 5, 6 };
		int[] set3 = new int[] { 2, 3, 4, 5, 6 };
		IntSet setObj1 = new IntSet(set1);
		IntSet setObj2 = new IntSet(set2);
		IntSet setObj3 = IntSet.union(setObj1, setObj2);
		assertArrayEquals(set3, setObj3.getSet());
	}

	@Test
	public void testUnionNegative() {
		int[] set1 = new int[] { 2, 3, 4 };
		int[] set2 = new int[] { 2, 5, 6 };
		int[] set3 = new int[] { 2, 3, 4, 5 };
		IntSet setObj1 = new IntSet(set1);
		IntSet setObj2 = new IntSet(set2);
		IntSet setObj3 = IntSet.union(setObj1, setObj2);
		assertFalse(set3.equals(setObj3.getSet()));
	}

	@Test(expected = ArithmeticException.class)
	public void testIsMemberValidationCheck() {
		int[] array = new int[] { 2, 3, 4, 5, 6, 0, 8, 9 };
		IntSet intSet = new IntSet(array);
		assertEquals(true, intSet.isMember(3));
	}
}

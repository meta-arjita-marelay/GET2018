package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {

	int[][] a1 = { { 3, 3 }, { 2, 2 }, { 3, 0 } };
	int[][] a2 = { { 3, 3 }, { 1, 2 }, { 2, 0 } };

	Poly obj1 = new Poly(a1);
	Poly obj2 = new Poly(a2);

	@Test
	public void testEvaluatePositive() {
		assertEquals(8, obj1.evaluate(1), 0.0f);
	}

	@Test
	public void testEvaluateNegative() {
		assertNotEquals(9, obj1.evaluate(1), 0.0f);
	}

	@Test
	public void testDegreePositive() {
		assertEquals(3, obj1.degree());
	}

	@Test
	public void testDegreeNegative() {
		assertNotEquals(2, obj1.degree());
	}

	@Test
	public void testAddPolynomialPositive()
	{
		int[][] expectedResult = new int[][] {{6,3},{3,2},{5,0}};
		Poly p3 = Poly.addPoly(obj1, obj2);
		int[][] result = p3.getPolynomial();
		assertArrayEquals(expectedResult,result);
	}
	@Test
	public void testAddPolynomialNegative()
	{
		int[][] expectedResult = new int[][] {{6,3},{3,2}};
		Poly p3 = Poly.addPoly(obj1, obj2);
		int[][] result = p3.getPolynomial();
		assertFalse(expectedResult.equals(result));
	}
	@Test
	public void testMultiplyPolynomialPositive()
	{
		int[][] expectedResult = new int[][] {{9,6},{9,5},{15,3},{2,4},{7,2},{6,0}};
		Poly p3 = Poly.multiplyPoly(obj1, obj2);
		int[][] result = p3.getPolynomial();
		assertArrayEquals(expectedResult,result);
	}
	@Test
	public void testMultiplyPolynomialNegative()
	{
		int[][] expectedResult = new int[][] {{9,6},{9,5},{15,3},{2,4},{7,2}};
		Poly p3 = Poly.multiplyPoly(obj1, obj2);
		int[][] result = p3.getPolynomial();
		assertFalse(expectedResult.equals(result));
	}
}

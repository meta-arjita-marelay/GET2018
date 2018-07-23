package Question3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AreaCalculateTest {
	Area areaCalculate = new Area();

	@Test
	public void testTriangleArea() {
		double result1 = areaCalculate.triangleArea(20, 10);
		assertEquals(result1, 100, 0);
		double result2 = areaCalculate.triangleArea(20, 10);
		assertNotEquals(result2, 10, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void testTriangleAreaError() {
		double result2 = areaCalculate.triangleArea(-2, 10);
		assertNotEquals(result2, 10, 0);
	}

	@Test
	public void testRectangleArea() {
		double result1 = areaCalculate.rectangleArea(20, 10);
		assertEquals(result1, 200, 0);
		double result2 = areaCalculate.rectangleArea(20, 10);
		assertNotEquals(result2, 10, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void testRectangleAreaError() {
		double result2 = areaCalculate.rectangleArea(-2, 10);
		assertNotEquals(result2, 10, 0);
	}

	@Test
	public void testSquareArea() {
		double result1 = areaCalculate.squareArea(20);
		assertEquals(result1, 400, 0);
		double result2 = areaCalculate.squareArea(20);
		assertNotEquals(result2, 10, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void testSquareAreaError() {
		double result2 = areaCalculate.squareArea(-2);
		assertNotEquals(result2, 10, 0);
	}

	@Test
	public void testCircleArea() {
		double result1 = areaCalculate.circleArea(7);
		assertEquals(result1, 153.86, 0);
		double result2 = areaCalculate.circleArea(7);
		assertNotEquals(result2, 10, 0);
	}

	@Test(expected = ArithmeticException.class)
	public void testCircleAreaError() {
		double result2 = areaCalculate.circleArea(-2);
		assertNotEquals(result2, 10, 0);
	}
}

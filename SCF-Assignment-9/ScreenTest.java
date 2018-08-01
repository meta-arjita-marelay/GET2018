package shapeOfObject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ScreenTest {

	@Test
	public void testCircle() {
		Screen screen = new Screen();
		ShapeType type = ShapeType.CIRCLE;
		Point point = new Point(1, 1);
		List<Double> parameters = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape = screen.addShape(type, point, parameters);
		double result = shape.getArea();
		assertEquals(result, 3.14, 0.0);
	}

	@Test
	public void testRectangle() {
		Screen screen = new Screen();
		ShapeType type = ShapeType.RECTANGLE;
		Point point = new Point(1, 1);
		List<Double> parameters = new ArrayList<Double>(Arrays.asList(1.0, 2.0));
		Shape shape = screen.addShape(type, point, parameters);
		double result = shape.getArea();
		assertEquals(result, 2.0, 0.0);
	}

	@Test
	public void testSquare() {
		Screen screen = new Screen();
		ShapeType type = ShapeType.SQUARE;
		Point point = new Point(1, 1);
		List<Double> parameters = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape = screen.addShape(type, point, parameters);
		double result = shape.getArea();
		assertEquals(result, 1.0, 0.0);
	}

	@Test
	public void testTriangle() {
		Screen screen = new Screen();
		ShapeType type = ShapeType.TRIANGLE;
		Point point = new Point(1, 1);
		List<Double> parameters = new ArrayList<Double>(Arrays.asList(3.0, 4.0,
				5.0, 5.0));
		Shape shape = screen.addShape(type, point, parameters);
		double result = shape.getArea();
		assertEquals(result, 6.0, 0.0);
	}

	@Test
	public void testDeleteShape() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);
		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);

		boolean result = screen.deleteShape(ShapeType.CIRCLE);
		assertEquals(true, result);
	}

	@Test
	public void testDeleteAllSpecific() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);

		ShapeType type3 = ShapeType.SQUARE;
		Point point3 = new Point(1, 1);
		List<Double> parameters3 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape3 = screen.addShape(type3, point3, parameters3);

		boolean result = screen.deleteAllSpecificShape(ShapeType.CIRCLE);
		assertEquals(true, result);
	}

	@Test
	public void testSortByArea() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1,
				shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortByArea();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testSortByPerimeter() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1,
				shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortByPerimeter();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testSortByDistance() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1,
				shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortByDistance();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testSortByTime() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.CIRCLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(Arrays.asList(1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);

		ShapeType type2 = ShapeType.CIRCLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(Arrays.asList(2.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);

		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape1,
				shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.sortByTime();
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void testShapesEnclosingPoint() {
		Screen screen = new Screen();
		ShapeType type1 = ShapeType.RECTANGLE;
		Point point1 = new Point(1, 1);
		List<Double> parameters1 = new ArrayList<Double>(
				Arrays.asList(1.0, 1.0));
		Shape shape1 = screen.addShape(type1, point1, parameters1);

		ShapeType type2 = ShapeType.RECTANGLE;
		Point point2 = new Point(1, 1);
		List<Double> parameters2 = new ArrayList<Double>(
				Arrays.asList(2.0, 2.0));
		Shape shape2 = screen.addShape(type2, point2, parameters2);
		Point point3 = new Point(2.5, 2.5);
		List<Shape> expectedresult = new ArrayList<Shape>(Arrays.asList(shape2));
		List<Shape> actualresult = new ArrayList<Shape>();
		actualresult = screen.shapesEnclosingPoint(point3);
		assertEquals(expectedresult, actualresult);
	}
}

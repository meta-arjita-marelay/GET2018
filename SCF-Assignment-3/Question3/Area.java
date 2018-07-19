package Question3;

/**
 * this class contains method which will calculate the area of respective shapes
 * 
 * @author Arjita
 *
 */
public class Area {
	/**
	 * 
	 * @param width
	 *            width of triangle
	 * @param height
	 *            height of triangle
	 * @return area of triangle
	 */
	public double triangleArea(double width, double height) {
		if (width <= 0 && height <= 0) {
			throw new ArithmeticException("You entered invalid values.");
		} else {
			return 0.5 * width * height;
		}
	}

	/**
	 * 
	 * @param width
	 *            width of rectangle
	 * @param height
	 *            height of rectangle
	 * @return area of rectangle
	 */
	public double rectangleArea(double width, double height) {
		if (width <= 0 && height <= 0) {
			throw new ArithmeticException("You entered invalid values.");
		} else {
			return width * height;
		}
	}

	/**
	 * 
	 * @param width
	 *            width of square
	 * @return area of square
	 */
	public double squareArea(double width) {
		if (width <= 0) {
			throw new ArithmeticException("You entered invalid values.");
		} else {
			return width * width;
		}
	}

	/**
	 * 
	 * @param radius
	 *            radius of circle
	 * @return area of circle
	 */
	public double circleArea(double radius) {
		if (radius <= 0) {
			throw new ArithmeticException("You entered invalid values.");
		} else {
			return 3.14 * radius * radius;
		}
	}
}
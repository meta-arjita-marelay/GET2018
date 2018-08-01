package shapeOfObject;

/**
 * Point class contains x-coordinate and y-coordinate of point
 * 
 * @author Arjita
 *
 */
public class Point {
	private double xCoordinate;
	private double yCoordinate;

	/**
	 * constructor to initialise the private member
	 * 
	 * @param xCoordinate
	 *            x-coordinate of point
	 * @param yCoordinate
	 *            y-coordinate of point
	 */
	Point(double xCoordinate, double yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

}

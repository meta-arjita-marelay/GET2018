package shapeOfObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Triangle contains properties of circle and it calculates the area, perimeter,
 * and checks if some point is enclosed by Triangle.
 * 
 * @author Arjita
 *
 */
public class Triangle implements Shape {
	private Point point;// origin point of shape
	private double height, side1, side2, side3;
	private Date timestamp;
	private ShapeType type;

	/**
	 * constructor to initialise the private members
	 * 
	 * @param point
	 *            origin point of shape
	 * @param parameters
	 *            list of parameters which will contain length of sides of
	 *            triangle
	 */
	Triangle(Point point, List<Double> parameters) {
		this.point = point;
		this.type = ShapeType.TRIANGLE;
		this.timestamp = new Date();
		side1 = parameters.get(0);
		side2 = parameters.get(1);
		side3 = parameters.get(2);
		height = parameters.get(3);
	}

	@Override
	public ShapeType getType() {
		return type;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public double getArea() {
		double halfOfParameter = getPerimeter() / 2;
		double tempArea = halfOfParameter * (halfOfParameter - side1)
				* (halfOfParameter - side2) * (halfOfParameter - side3);
		return Math.sqrt(tempArea);
	}

	@Override
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	@Override
	public Point getOrigin() {
		return point;
	}

	@Override
	public boolean isPointEnclosed(Point point) {

		double pointX1 = this.point.getxCoordinate();
		double pointY1 = this.point.getyCoordinate();
		double pointX2 = pointX1 + side1;
		double pointX3 = Math.sqrt(side3 * side3 - height * height) + pointX1;
		double pointY3 = pointY1 + height;
		Point point1 = new Point(pointX1, pointY1);
		Point point2 = new Point(pointX2, pointY1);
		Point point3 = new Point(pointX3, pointY3);
		double area1 = calAreaByPoints(point1, point2, point);
		double area2 = calAreaByPoints(point2, point, point3);
		double area3 = calAreaByPoints(point1, point3, point);

		double area = getArea();

		double summedArea = area1 + area2 + area3;
		if (area == summedArea) {
			return true;
		}
		return false;
	}

	/**
	 * helper method to calculate area of triangle using points of vertices
	 * 
	 * @param point1
	 *            first vertex point
	 * @param point2
	 *            second vertex point
	 * @param point3
	 *            third vertex point
	 * @return area enclosed by three vertices
	 */
	private double calAreaByPoints(Point point1, Point point2, Point point3) {
		double area = (point1.getxCoordinate() * (point2.getyCoordinate() - point3
				.getyCoordinate()))
				+ (point2.getxCoordinate() * (point3.getyCoordinate() - point1
						.getyCoordinate()))
				+ (point3.getxCoordinate() * (point1.getyCoordinate() - point2
						.getyCoordinate()));
		if (area > 0) {
			return area / 2;
		} else {
			return (-1) * area / 2;
		}
	}

	@Override
	public double getDistance() {
		double dist = point.getxCoordinate() * point.getxCoordinate()
				+ point.getyCoordinate() * point.getyCoordinate();
		return Math.sqrt(dist);
	}
}

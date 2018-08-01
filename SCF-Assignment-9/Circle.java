package shapeOfObject;

import java.util.Date;
import java.util.List;

/**
 * Circle contains properties of circle and it calculates the area, perimeter,
 * and checks if some point is enclosed by circle.
 * 
 * @author Arjita
 *
 */
public class Circle implements Shape {
	private Point point;
	private double radius;
	private ShapeType type;
	private Date timestamp;

	Circle(Point point, List<Double> parameters) {
		this.point = point;
		this.timestamp = new Date();
		this.type = ShapeType.CIRCLE;
		radius = parameters.get(0);
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
		return 3.14 * radius * radius;
	}

	@Override
	public double getPerimeter() {
		return 2 * 3.14 * radius;
	}

	@Override
	public Point getOrigin() {
		return point;
	}

	@Override
	public boolean isPointEnclosed(Point pointCheck) {
		Point point1 = new Point(0, 0);
		double semiLength = calculateDistance(point1, this.point);
		double totalLength = semiLength + radius;
		double xCenter, yCenter;
		double angle = this.point.getyCoordinate()
				/ this.point.getxCoordinate();
		angle = Math.atan(angle);
		xCenter = totalLength * Math.cos(angle);
		yCenter = totalLength * Math.sin(angle);
		Point center = new Point(xCenter, yCenter);
		double distance = calculateDistance(center, pointCheck);
		if (distance <= radius) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * calculateDistance will calculate the distance between two points
	 * 
	 * @param point1
	 *            first point
	 * @param point2
	 *            second point
	 * @return distance between first and second point
	 */
	private double calculateDistance(Point point1, Point point2) {
		double x1, x2, y1, y2;
		x1 = point1.getxCoordinate();
		x2 = point2.getxCoordinate();
		y1 = point1.getyCoordinate();
		y2 = point2.getyCoordinate();
		double tempResult;
		tempResult = ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
		return Math.sqrt(tempResult);
	}

	@Override
	public double getDistance() {
		double dist = point.getxCoordinate() * point.getxCoordinate()
				+ point.getyCoordinate() * point.getyCoordinate();
		return Math.sqrt(dist);
	}
}

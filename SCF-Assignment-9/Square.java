package shapeOfObject;

import java.util.Date;
import java.util.List;

/**
 * Square contains properties of circle and it calculates the area, perimeter,
 * and checks if some point is enclosed by Square.
 * 
 * @author Arjita
 *
 */
public class Square implements Shape {

	private Point point;// origin point of shape
	private double side;// length of square
	private Date timestamp;// time at which object is created
	private ShapeType type;// type of shape

	/**
	 * constructor to initialise the private member
	 * 
	 * @param point
	 *            origin point of shape
	 * @param parameters
	 *            list of parameters which will contain length of side
	 */
	Square(Point point, List<Double> parameters) {
		this.point = point;
		this.timestamp = new Date();
		this.type = ShapeType.SQUARE;
		side = parameters.get(0);
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
		return side * side;
	}

	@Override
	public double getPerimeter() {
		return 4 * side;
	}

	@Override
	public Point getOrigin() {
		return point;
	}

	@Override
	public boolean isPointEnclosed(Point pointCheck) {
		double xCheck, yCheck, xCoord, yCoord;
		xCheck = pointCheck.getxCoordinate();
		yCheck = pointCheck.getyCoordinate();
		xCoord = point.getxCoordinate();
		yCoord = point.getyCoordinate();
		if ((xCoord + side) > xCheck && xCheck > xCoord
				&& (yCoord + side) > yCheck && yCheck > yCoord) {
			return true;
		}
		return false;
	}

	@Override
	public double getDistance() {
		double dist = point.getxCoordinate() * point.getxCoordinate()
				+ point.getyCoordinate() * point.getyCoordinate();
		return Math.sqrt(dist);
	}

}

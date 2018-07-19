package Question3;

import java.util.Scanner;

/**
 * this class contains main class and will call the functions of area and will
 * print the respective values.
 * 
 * @author Arjita
 *
 */
public class AreaCalculate {
	/**
	 * 
	 * @param objectArea
	 *            object of area class
	 * @param areaOfTriangle
	 *            will store the return value of triangle area
	 * @param areaOfRectangle
	 *            will store the return value of rectangle area
	 * @param areaOfSquare
	 *            will store the return value of square area
	 * @param areaOfCircle
	 *            will store the return value of circle area
	 */
	public static void main(String[] args) {
		Area objectArea = new Area();
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out
				.println("Enter your choice...\n1...Area of triangle\n2...Area of rectangle\n3...Area of Squaren4....area of circle");
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			int width,
			height;
			System.out.println("enter width and height of triangle..");
			width = scan.nextInt();
			height = scan.nextInt();
			try {
				double areaOfTriangle = objectArea.triangleArea(width, height);
				System.out.println("Area of Triangle " + areaOfTriangle);
			} catch (Exception e) {
				System.out.println("error is: " + e);
			}
			break;
		case 2:
			int width1,
			height1;
			System.out.println("enter width and height of rectangle..");
			width1 = scan.nextInt();
			height1 = scan.nextInt();
			try {
				double areaOfRectangle = objectArea.rectangleArea(width1,
						height1);
				System.out.println("Area of rectangle " + areaOfRectangle);
			} catch (Exception e) {
				System.out.println("error is: " + e);
			}
			break;
		case 3:
			int width2;
			System.out.println("enter width of square..");
			width2 = scan.nextInt();
			try {
				double areaOfSquare = objectArea.squareArea(width2);
				System.out.println("Area of square " + areaOfSquare);
			} catch (Exception e) {
				System.out.println("error is: " + e);
			}
			break;
		case 4:
			int radius;
			System.out.println("enter radius of circle..");
			radius = scan.nextInt();
			try {
				double areaOfCircle = objectArea.circleArea(radius);
				System.out.println("Area of square " + areaOfCircle);
			} catch (Exception e) {
				System.out.println("error is: " + e);
			}
			break;
		default:
			System.out.println("enter valid choice");
		}
		scan.close();
	}
}

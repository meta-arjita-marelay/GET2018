package Question2;

import java.util.Scanner;

/**
 * main class which will take input of grades of student and will call function
 * for respective calculations.
 * 
 * @author Arjita
 *
 */
public class StudentMarks {
	public static void main(String[] args) {
		int numberOfStudents;// number of students
		int choice;
		MarkSheet calculateMarks = new MarkSheet();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of students. ");
		numberOfStudents = scan.nextInt();
		if (numberOfStudents > 0) {
			int[] studentGrade = new int[numberOfStudents];
			System.out.println("Enter grades:\n");
			for (int i = 0; i < numberOfStudents; i++) {
				studentGrade[i] = scan.nextInt();
			}
			System.out
					.println("enter your choice...\n1...average of grade\n2....maximum of grade\n3....minimum of grade\n4....percentage of passed student");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println(String.format("%.2f", calculateMarks
							.averageOfGrade(studentGrade, numberOfStudents)));
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				try {
					System.out.println(String.format("%.2f", calculateMarks
							.maximumOfGrade(studentGrade, numberOfStudents)));
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
					System.out.println(String.format("%.2f", calculateMarks
							.minimumOfGrade(studentGrade, numberOfStudents)));
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 4:
				try {
					System.out.println(String.format("%.2f", calculateMarks
							.percentageofPass(studentGrade, numberOfStudents)));
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			default:
				System.out.println("enter valid option");
			}
			scan.close();
		} else {
			System.out.println("enter valid option");
		}

	}

}

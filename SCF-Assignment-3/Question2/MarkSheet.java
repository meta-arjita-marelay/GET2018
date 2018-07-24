package Question2;

/**
 * this class contains function which will perform the different operations like
 * average , maximum , minimum of grade or percentage of passed student
 * 
 * @author Arjita
 *
 */

public class MarkSheet {
	/**
	 * 
	 * @param student
	 *            1-D array which will store grades from 0-100 only
	 * @param size
	 *            number of students
	 * @return average of all grades
	 */
	public float averageOfGrade(int[] student, int size) {
		float average = 0;
		float total = 0;

		for (int i = 0; i < size; i++) {
			if (student[i] < 0) {
				throw new ArithmeticException("You entered invalid grade.");
			}
			total = total + student[i];
		}
		average = total / size;
		return average;

	}

	/**
	 * 
	 * @param student
	 *            1-D array which will store grades from 0-100 only
	 * @param size
	 *            number of students
	 * @return maximum of all grades
	 */
	public int maximumOfGrade(int[] student, int size) {
		int maximumGrade = 0;
		for (int i = 0; i < size; i++) {
			if (student[i] < 0) {
				throw new ArithmeticException("You entered invalid grade.");
			}
			if (student[i] > maximumGrade) {
				maximumGrade = student[i];
			}
		}
		return maximumGrade;

	}

	/**
	 * 
	 * @param student
	 *            1-D array which will store grades from 0-100 only
	 * @param size
	 *            number of students
	 * @return minimum of all grades
	 */
	public int minimumOfGrade(int[] student, int size) {
		int minimumGrade = student[0];

		for (int i = 1; i < size; i++) {
			if (student[i] < 0) {
				throw new ArithmeticException("You entered invalid grade.");
			}
			if (student[i] < minimumGrade) {
				minimumGrade = student[i];
			}
		}
		return minimumGrade;

	}

	/**
	 * 
	 * @param student
	 *            1-D array which will store grades from 0-100 only
	 * @param size
	 *            number of students
	 * @return percentage of passed students
	 */
	public float percentageofPass(int[] student, int size) {
		int countofPassedStudent = 0;
		float percentagePass = 0;

		for (int i = 0; i < size; i++) {
			if (student[i] < 0) {
				throw new ArithmeticException("You entered invalid grade.");
			}
			if (student[i] > 39) {
				countofPassedStudent++;
			}
		}
		percentagePass = (countofPassedStudent * 100) / size;
		return percentagePass;

	}
}
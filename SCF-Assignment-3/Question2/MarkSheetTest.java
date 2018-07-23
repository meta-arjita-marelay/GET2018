package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarkSheetTest {
	MarkSheet markSheet = new MarkSheet();
	int[] student = new int[] { 10, 20, 30, 40 };

	@Test
	public void testForAverage() {
		float result1 = markSheet.averageOfGrade(student, 4);
		assertEquals(result1, 25, 0.0f);
		float result2 = markSheet.averageOfGrade(student, 4);
		assertNotEquals(result2, 27, 0.0f);

	}

	@Test(expected = ArithmeticException.class)
	public void testForAverageError() {
		int[] student1 = new int[] { 10, 20, 30, 40, -1 };
		float result1 = markSheet.averageOfGrade(student1, 5);
		assertEquals(result1, 25, 0.0f);
	}

	@Test
	public void testForMaximum() {
		int result1 = markSheet.maximumOfGrade(student, 4);
		assertEquals(result1, 40);
		int result2 = markSheet.maximumOfGrade(student, 4);
		assertNotEquals(result2, 30);

	}

	@Test(expected = ArithmeticException.class)
	public void testForMaximumError() {
		int[] student1 = new int[] { 10, 20, 30, 40, -1 };
		float result1 = markSheet.maximumOfGrade(student1, 5);
		assertEquals(result1, 25, 0.0f);
	}

	@Test
	public void testForMinimum() {
		int result1 = markSheet.minimumOfGrade(student, 4);
		assertEquals(result1, 10);
		int result2 = markSheet.minimumOfGrade(student, 4);
		assertNotEquals(result2, 30);

	}

	@Test(expected = ArithmeticException.class)
	public void testForMinimumError() {
		int[] student1 = new int[] { 10, 20, 30, 40, -1 };
		float result1 = markSheet.maximumOfGrade(student1, 5);
		assertEquals(result1, 25, 0.0f);
	}

	@Test
	public void testForPassPercentage() {
		float result1 = markSheet.percentageofPass(student, 4);
		assertEquals(result1, 25, 0.0f);
		float result2 = markSheet.percentageofPass(student, 4);
		assertNotEquals(result2, 30, 0.0f);

	}

	@Test(expected = ArithmeticException.class)
	public void testForPassPercentageError() {
		int[] student1 = new int[] { 10, 20, 30, 40, -1 };
		float result1 = markSheet.maximumOfGrade(student1, 5);
		assertEquals(result1, 25, 0.0f);
	}
}

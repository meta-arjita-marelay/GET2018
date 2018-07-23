package ArrayOperations;

public class ArrOperation {
	// Part1
	/**
	 * This method calculate the length of largest mirror in array
	 * 
	 * @param array
	 *            input array
	 * @return size of largest mirror section in array
	 */
	public static int calculateLargestMirror(int[] array) {
		int size = array.length - 1;
		if (size == 0) {
			throw new AssertionError("enter valid array");
		}
		int j = size;
		int i = 0;
		int count = 0;
		int maxLength = 0;
		while (i < size) {
			while (j >= 0) {
				if (array[i] == array[j]) {
					i++;
					count++;
				}
				j--;
			}
			if (maxLength < count) {
				maxLength = count;
				count = 0;
			}
			i++;
		}
		return maxLength;
	}

	// Part 2
	/**
	 * This method calculates the number of clumps in input array
	 * 
	 * @param array
	 *            input array
	 * @return number of clumps in input array
	 */
	public static int calculatearrayClumps(int[] array) {
		int size = array.length;
		if (size == 0) {
			throw new AssertionError("enter valid array");
		}
		int count = 0;
		int numOfClumps = 0;
		for (int i = 0; i < size - 1; i++) {
			if (array[i] == array[i + 1]) {
				count++;
			} else {
				if (count > 0) {
					numOfClumps++;
				}
				count = 0;
			}
		}
		return numOfClumps;
	}

	// Part 3

	/**
	 * This method calculates the count of x in array
	 * 
	 * @param x
	 *            number whose successor needs to be fixed
	 * @param array
	 *            input array
	 * @param size
	 *            size of input array
	 * @return number of x
	 */
	private static int numOfX(int x, int[] array, int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == x) {
				count++;
			}
		}
		return count;
	}

	/**
	 * This method calculates the count of y in array
	 * 
	 * @param y
	 *            number which needs to be fixed as successor
	 * @param array
	 *            input array
	 * @param size
	 *            size of input array
	 * @return number of y
	 */
	private static int numOfY(int y, int[] array, int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == y) {
				count++;
			}
		}
		return count;
	}

	/**
	 * This method checks if two consecutive x present in array
	 * 
	 * @param x
	 *            number whose successor needs to be fixed
	 * @param array
	 *            input array
	 * @param size
	 *            size of input array
	 * @return true if there are two consecutive x
	 */
	private static boolean isConsecutiveX(int x, int[] array, int size) {
		for (int i = 0; i < size - 1; i++) {
			if (array[i] == x && array[i + 1] == x) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks if x is last element of array
	 * 
	 * @param x
	 *            number whose successor needs to be fixed
	 * @param array
	 *            input array
	 * @param size
	 *            size of input array
	 * @return true if x is last element
	 */
	private static boolean isXLastElement(int x, int[] array, int size) {
		if (array[size - 1] == x) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * this method finds the location of y which needs to be fixed as successor
	 * of x
	 * 
	 * @param y
	 *            number which needs to be fixed as successor
	 * @param x
	 *            number whose successor needs to be fixed
	 * @param array
	 *            input array
	 * @param size
	 *            size of input array
	 * @return location of y which is to be swapped
	 */
	private static int locationOfY(int y, int x, int[] array, int size) {
		if (array[0] == y) {
			return 0;
		}
		for (int i = 1; i < size; i++) {
			if (array[i] == y && array[i - 1] != x) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This method will fix x and y in array such that every y is successor of
	 * every x
	 * 
	 * @param x
	 *            number whose successor needs to be fixed
	 * @param y
	 *            number which needs to be fixed as successor
	 * @param array
	 *            input array
	 * @return the array with y in adjacent right of x
	 */
	public static int[] fixXY(int x, int y, int[] array) {
		int temp = 0, locationY = 0;
		int size = array.length;
		if ((numOfX(x, array, size) == numOfY(y, array, size))
				&& !isConsecutiveX(x, array, size)
				&& !isXLastElement(x, array, size)) {
			for (int i = 0; i < size - 1; i++) {
				if (array[i] == x) {
					locationY = locationOfY(y, x, array, size);
					if (locationY == -1) {
						throw new AssertionError("error");
					}
					temp = array[i + 1];
					array[i + 1] = array[locationY];
					array[locationY] = temp;
				}
			}
		} else {
			throw new AssertionError("enter valid array");
		}
		return array;
	}

	// Part 4

	/**
	 * This function will calculate index from where array can be split in two
	 * equal array
	 * 
	 * @param array
	 *            input array
	 * @return index if there is place to split the array in two equal sum
	 *         otherwise -1
	 */
	public static int calculateArraySplitFunction(int[] array) {
		int size = array.length;
		if (size == 0) {
			throw new AssertionError("array size cannot be zero");
		}
		int arraySum = 0;
		for (int i = 0; i < size; i++) {
			arraySum += array[i];
		}
		if (arraySum % 2 == 0) {
			int halfArraySum = arraySum / 2;
			int firstArraySum = 0;
			for (int i = 0; i < size; i++) {
				firstArraySum += array[i];
				if (firstArraySum == halfArraySum) {
					return i + 1;
				}
			}
		}
		return -1;
	}
}

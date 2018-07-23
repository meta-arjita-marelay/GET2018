package ArrayOperations;

public class ArrOperation {
	// Part1
	/**
	 * 
	 * @param array
	 *            should not be empty
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
	 * 
	 * @param array
	 *            should not be empty
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
	 *
	 * @param x
	 *            should be present in array
	 * @param array
	 *            array should not be null
	 * @param size
	 *            size should not be negative
	 * @return number of x
	 */
	public static int numOfX(int x, int[] array, int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == x) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 
	 * @param y
	 *            should be present in array
	 * @param array
	 *            array should not be null
	 * @param size
	 *            size should not be negative
	 * @return number of y
	 */
	public static int numOfY(int y, int[] array, int size) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (array[i] == y) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 
	 * @param x
	 *            should be present in array
	 * @param array
	 *            should not be null
	 * @param size
	 *            should not be negative
	 * @return true if there are two consecutive 4
	 */
	public static boolean isConsecutiveX(int x, int[] array, int size) {
		for (int i = 0; i < size - 1; i++) {
			if (array[i] == x && array[i + 1] == x) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param x
	 *            should be present in array
	 * @param array
	 *            should not be null
	 * @param size
	 *            should not be negative
	 * @return true if x is last element
	 */
	public static boolean isXLastElement(int x, int[] array, int size) {
		if (array[size - 1] == x) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param y
	 *            should be present in array
	 * @param x
	 *            should be present in array
	 * @param array
	 *            should not be null
	 * @param size
	 *            should not be negative
	 * @return location of y which is to be swapped
	 */
	public static int locationOfY(int y, int x, int[] array, int size) {
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
	 * 
	 * @param x
	 *            should be present in array
	 * @param y
	 *            should be present in array
	 * @param array
	 *            should not be null
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
	 * 
	 * @param array
	 *            should not be empty
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

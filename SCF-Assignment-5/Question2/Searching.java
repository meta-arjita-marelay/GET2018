package Question2;

/**
 * 
 * this class includes function which will use to search element in array
 * 
 * @author Arjita
 *
 */
public class Searching {
	/**
	 * this method is for linear search of element
	 * 
	 * @param array
	 *            in which element is to be searched
	 * @param x
	 *            element which is to be searched
	 * @param first
	 *            position at which element is to be searched recursively
	 * @return index at which element is found otherwise -1
	 */
	public static int linearSearch(int[] array, int x, int first) {
		int size = array.length;
		// check if whole array is traversed
		if (first == size) {
			return -1;
		}
		// check if element is present
		else if (array[first] == x) {
			return first;
		}
		// recursive call of function
		else {
			return linearSearch(array, x, first + 1);
		}
	}

	/**
	 * this method will search element in array through binary search this is
	 * assumed that array is sorted in ascending order
	 * 
	 * @param array
	 *            in which element is to be searched
	 * @param x
	 *            element which is to be searched
	 * @param first
	 *            first index of array from where searching needs to done
	 * @param last
	 *            last index of array upto which searching needs to be done
	 * @return index of element if found otherwise -1
	 */
	public static int binarySearch(int[] array, int x, int first, int last) {
		// middle index is calculated
		int mid = (first + last) / 2;
		// middle element is checked
		if (array[mid] == x) {
			return mid;
		}
		// middle element is compared with element
		else if (array[mid] > x) {
			return binarySearch(array, x, first, mid);
		} else if (array[mid] < x) {
			return binarySearch(array, x, mid, last);
		}
		return -1;
	}
}

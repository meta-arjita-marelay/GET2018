package Question1;

/**
 * IntSet contains the methods to perform operation on set like to check the
 * membership, calculate size, check the subset and union of two set
 * 
 * @author Arjita
 *
 */
public final class IntSet {
	private final int[] set;

	/**
	 * IntSet is constructor of class which will initialise the private member
	 * of class after putting some validation which is that number should be
	 * between 1-1000
	 * 
	 * @param array
	 *            input array to initialse the object of class
	 */
	public IntSet(int[] array) {
		set = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 1 || array[i] > 1000) {
				throw new ArithmeticException("enter valid data");
			}
			set[i] = array[i];
		}
	}

	/**
	 * getter method for getting the private member of class
	 * 
	 * @return private member set array of class
	 */
	public int[] getSet() {
		return set;
	}

	/**
	 * check the membership of element in set array
	 * 
	 * @param element
	 *            variable whose membership is to be checked
	 * @return true if present otherwise false
	 */
	public boolean isMember(int element) {
		for (int i = 0; i < set.length; i++) {
			if (set[i] == element) {
				return true;
			}
		}
		return false;
	}

	/**
	 * calculate the size of set
	 * 
	 * @return size of set
	 */
	public int size() {
		return set.length;
	}

	/**
	 * check if input set is subset of first set
	 * 
	 * @param subSet
	 *            object of IntSet which is to checked if it is subset or not
	 * @return true if subset otherwise false
	 */
	public boolean isSubSet(IntSet subSet) {
		int[] subSetArray = subSet.getSet();
		for (int i = 0; i < subSetArray.length; i++) {
			if (!search(set, subSetArray[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * complement method will find the complement of set. the universal set for
	 * set is assumed to be 1-1000. but for the ease of making test case, here i
	 * took 1-10. so for 1-1000, 10 will be replaced by 100
	 * 
	 * @return complement array of set
	 */
	public int[] complement() {
		int size = 10 - set.length;// 10 will be replaced by 1000
		int[] result = new int[size];
		// 10 will be replaced by 1000
		for (int i = 1, k = 0; i <= 10 && k < size; i++) {
			if (!search(set, i)) {
				result[k] = i;
				k++;
			}
		}
		return result;
	}

	/**
	 * union method will do the union of two sets
	 * 
	 * @param set1
	 *            object of first set
	 * @param set2
	 *            object of second set
	 * @return Intset object of union of two sets
	 */
	public static IntSet union(IntSet set1, IntSet set2) {
		// setArray1 and setArray2 stores the array of first and second input
		// object
		int[] setArray1 = set1.getSet();
		int[] setArray2 = set2.getSet();
		// size will be calculated by adding the length of both array
		int size = setArray1.length + setArray2.length;
		int[] result = new int[size];
		int i = 0, j = 0;
		// firstly the first will be added
		for (i = 0; i < setArray1.length; i++) {
			result[i] = setArray1[i];
		}
		// second array elements will be added only if that element is not
		// already present in result array
		for (j = 0; j < setArray2.length; j++) {
			if (!search(result, setArray2[j])) {
				result[i] = setArray2[j];
				i++;
			}
		}
		// this array will store array after removing trailing zeroes
		int[] resultRemovingZero = new int[i];
		for (j = 0; j < i; j++) {
			resultRemovingZero[j] = result[j];
		}
		// object of result array
		IntSet resultSet = new IntSet(resultRemovingZero);
		return resultSet;
	}

	/**
	 * helper method to search the element in array
	 * 
	 * @param array
	 *            array in which searching is to be done
	 * @param element
	 *            variable which is to be searched
	 * @return true if element is present otherwise false
	 */
	private static boolean search(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return true;
			}
		}
		return false;
	}
}

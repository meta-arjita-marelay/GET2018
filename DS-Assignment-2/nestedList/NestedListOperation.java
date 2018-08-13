package nestedList;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

/**
 * This class defines the method declared in NestedListy interface
 * 
 * @author Arjita
 *
 * @param <E>
 */
public class NestedListOperation<E> implements NestedList<E> {
	private List<Object> nestedList = new ArrayList<Object>();

	/**
	 * constructor of class
	 * 
	 * @param list
	 *            input nested list
	 */
	public NestedListOperation(List<Object> list) {
		this.nestedList = list;
	}

	@Override
	public int sumOfAllValues(List<Object> nestedList) {
		int sum = 0;
		for (Object object : nestedList) {
			if (object instanceof List) {
				sum += sumOfAllValues((List<Object>) object);
			} else if (object instanceof Integer) {
				sum += (Integer) object;
			} else {
				throw new AssertionError();
			}
		}
		return sum;
	}

	@Override
	public int largestValue(List<Object> nestedList) {
		int max = 0;
		int temp = 0;
		for (Object object : nestedList) {
			if (object instanceof List) {
				temp = largestValue((List<Object>) object);
			} else if (object instanceof Integer) {
				temp = (Integer) object;
			} else {
				throw new AssertionError();
			}
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean searchValue(List<Object> nestedList, int element) {
		boolean flag = false;
		for (Object object : nestedList) {
			if (object instanceof List) {
				if (searchValue((List<Object>) object, element)) {
					return true;
				}
			} else if (object instanceof Integer) {
				if ((Integer) object == element) {
					flag = true;
					return flag;
				}
			} else {
				throw new AssertionError();
			}

		}
		return flag;
	}

	/**
	 * getValue will find the in nested list according to given string where H
	 * means head of nested list i.e., first element of nested list and T means
	 * tail of nested list i.e., all the elements except for head
	 * 
	 * @param pattern
	 *            according to which value is to be searched
	 * @param index
	 *            of string pattern from which searching is to be done
	 * @return value which is present at required location
	 */
	@SuppressWarnings("unchecked")
	public int getValue(String pattern, int index) {

		return getvalueRecursive(nestedList, pattern, index);

	}

	/**
	 * private helper method for getting value in nested list according to given
	 * string
	 * 
	 * @param nestedList
	 *            in which value is to be searched
	 * @param pattern
	 *            according to which value is to be searched
	 * @param index
	 *            of string pattern from which searching is to be done
	 * @return value which is present at required location
	 */
	@SuppressWarnings("unchecked")
	private int getvalueRecursive(List<Object> nestedList, String pattern,
			int index) {
		int elementedExtracted = 0;
		pattern.trim();
		int i = index;
		if ("T".equals(pattern.charAt(pattern.length() - 1))) {
			throw new AssertionError();
		}
		while (i < pattern.length()) {
			if ("T".equals(pattern.charAt(i))) {
				nestedList.remove(0);
			}
			if ("H".equals(pattern.charAt(i))) {

				if (nestedList.get(i) instanceof List && i == pattern.length()) {

					throw new AssertionError("!! Error !!");

				} else if (nestedList.get(i) instanceof List
						&& i != pattern.length()) {
					elementedExtracted = getvalueRecursive(
							(List<Object>) nestedList.get(i), pattern,
							index + 1);
					break;
				} else {
					elementedExtracted = (Integer) nestedList.get(i);
					break;
				}
			}
			i++;
		}
		return elementedExtracted;

	}
}

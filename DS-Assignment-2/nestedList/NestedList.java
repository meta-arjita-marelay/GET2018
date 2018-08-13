package nestedList;

import java.util.List;

/**
 * NestedList Interface will contain different method declaration for sum of all
 * values of list, largest value of list, or searching value in list.
 * 
 * @author Arjita
 *
 * @param <E>
 */
public interface NestedList<E> {
	/**
	 * sumOfAllvalues will calculate the sum of all values present in nested
	 * list
	 * 
	 * @param nestedList
	 *            whose values sum is to be calculated
	 * @return sum of all values of nested list
	 */
	public int sumOfAllValues(List<Object> nestedList);

	/**
	 * largestValue will find the largest value present in nested list
	 * 
	 * @param nestedList
	 *            in which largest value is to be searched
	 * @return largest value in nested list
	 */
	public int largestValue(List<Object> nestedList);

	/**
	 * searchValue will search the element in nested list
	 * 
	 * @param nestedList
	 *            in which value is to be searched
	 * @param element
	 * @return
	 */
	public boolean searchValue(List<Object> nestedList, int element);
}

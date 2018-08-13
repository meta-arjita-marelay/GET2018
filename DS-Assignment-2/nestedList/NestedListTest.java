package nestedList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

import org.junit.Test;

public class NestedListTest {

	@Test
	public void testSum() {
		List<Object> inputList = asList(1, 2, 3, asList(4, 5, asList(16, 17)),
				11, 13, 12, asList(6, 7, 8, 9), 10, asList(15, 14));
		NestedListOperation<Object> nestedOperations = new NestedListOperation<Object>(
				inputList);
		int result = nestedOperations.sumOfAllValues(inputList);
		assertEquals(result, 153);
	}

	@Test
	public void testLargest() {
		List<Object> inputList = asList(1, 2, 3, asList(4, 5, asList(16, 17)),
				11, 13, 12, asList(6, 7, 8, 9), 10, asList(15, 14));
		NestedListOperation<Object> nestedOperations = new NestedListOperation<Object>(
				inputList);
		int result = nestedOperations.largestValue(inputList);
		assertEquals(result, 17);
	}

	@Test
	public void testSearch() {
		List<Object> inputList = asList(1, 2, 3, asList(4, 5, asList(16, 17)),
				11, 13, 12, asList(6, 7, 8, 9), 10, asList(15, 14));
		NestedListOperation<Object> nestedOperations = new NestedListOperation<Object>(
				inputList);
		boolean result = nestedOperations.searchValue(inputList, 8);
		assertEquals(result, true);
	}

	@Test
	public void testGetValue() {
		List<Object> inputList = asList(1, 2, 3, asList(4, 5, asList(16, 17)),
				11, 13, 12, asList(6, 7, 8, 9), 10, asList(15, 14));
		NestedListOperation<Object> nestedOperations = new NestedListOperation<Object>(
				inputList);
		int result = nestedOperations.getValue("TH", 0);
		assertEquals(result, 2);
	}
}

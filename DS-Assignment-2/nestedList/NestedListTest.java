package nestedList;

import static org.junit.Assert.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class NestedListTest {
	@Test
	public void testSum() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		int result = nestedOperations.sumOfAllValues();
		assertEquals(result, 207);
	}

	@Test
	public void testLargest() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		int result = nestedOperations.largestValue();
		assertEquals(result, 99);
	}

	@Test
	public void testSearch() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		boolean result = nestedOperations.searchValue(45);
		assertEquals(result, true);
	}

	@Test
	public void testGetValue() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		int result = (int) nestedOperations.getValue("hh");
		assertEquals(result, 2);
	}
}

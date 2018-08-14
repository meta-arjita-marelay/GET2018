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
		long result = nestedOperations.sumOfAllValues();
		assertEquals(result, 207);
	}
	@Test
	public void testSumNegative() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		long result = nestedOperations.sumOfAllValues();
		assertNotEquals(result, 11);
	}
	@Test
	public void testLargest() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		long result = nestedOperations.largestValue();
		assertEquals(result, 99);
	}
	@Test
	public void testLargestNegative() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		long result = nestedOperations.largestValue();
		assertNotEquals(result, 9);
	}
	@Test
	public void testSearch() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		boolean result = nestedOperations.searchValue(45);
		assertEquals(result, true);
	}
	@Test
	public void testSearchNegative() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		boolean result = nestedOperations.searchValue(49);
		assertNotEquals(result, true);
	}

	@Test
	public void testGetValue() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		long result = (long) nestedOperations.getValue("hh");
		assertEquals(result, 4);
	}
	@Test(expected=AssertionError.class)
	public void testGetValueError() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		long result = (long) nestedOperations.getValue("hhtt");
		assertEquals(result, 4);
	}
	@Test
	public void testGetValueNegative() throws IOException, ParseException {
		NestedListOperation nestedOperations = new NestedListOperation(
				"E:/Assignments/Assignment11/src/nestedList/input.json.txt");
		long result = (long) nestedOperations.getValue("hh");
		assertNotEquals(result, 7);
	}
}

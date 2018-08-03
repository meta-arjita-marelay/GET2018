package Question1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	@Test
	public void testArrayPushPositive() {
		StackByArray stackArray = new StackByArray();
		assertEquals(true, stackArray.push(2));
	}

	@Test(expected = AssertionError.class)
	public void testArrayPushNegative() {
		StackByArray stackArray = new StackByArray();
		stackArray.push(2);
		stackArray.push(3);
		assertEquals(false, stackArray.push(2));
	}

	@Test
	public void testArrayPopPositive() {
		StackByArray stackArray = new StackByArray();
		stackArray.push(2);
		stackArray.push(3);
		assertEquals(3, stackArray.pop());
	}

	@Test(expected = AssertionError.class)
	public void testArrayPopNegative() {
		StackByArray stackArray = new StackByArray();
		assertEquals(3, stackArray.pop());
	}

	@Test
	public void testArrayEmptyPositive() {
		StackByArray stackArray = new StackByArray();
		assertEquals(true, stackArray.isEmpty());
	}

	@Test
	public void testArrayEmptyNegative() {
		StackByArray stackArray = new StackByArray();
		stackArray.push(2);
		assertNotEquals(true, stackArray.isEmpty());
	}

	@Test
	public void testArrayTopPostive() {
		StackByArray stackArray = new StackByArray();
		stackArray.push(2);
		assertEquals(2, stackArray.topElement());
	}

	@Test(expected = AssertionError.class)
	public void testArrayTopNegative() {
		StackByArray stackArray = new StackByArray();
		assertEquals(3, stackArray.topElement());
	}

	@Test
	public void testLinkedListPushPositive() {
		StackBylinkedlist stackList = new StackBylinkedlist();
		assertEquals(true, stackList.push(2));
	}

	@Test
	public void testLinkedListPopPositive() {
		StackBylinkedlist stackList = new StackBylinkedlist();
		stackList.push(2);
		stackList.push(3);
		assertEquals(3, stackList.pop());
	}

	@Test(expected = AssertionError.class)
	public void testLinkedListPopNegative() {
		StackBylinkedlist stackList = new StackBylinkedlist();
		assertEquals(3, stackList.pop());
	}

	@Test
	public void testLinkedListEmptyPositive() {
		StackBylinkedlist stackList = new StackBylinkedlist();
		assertEquals(true, stackList.isEmpty());
	}

	@Test
	public void testLinkedListTopPostive() {
		StackBylinkedlist stackList = new StackBylinkedlist();
		stackList.push(2);
		stackList.push(3);
		assertEquals(3, stackList.topElement());
	}

	@Test(expected = AssertionError.class)
	public void testLinkedListTopNegative() {
		StackBylinkedlist stackList = new StackBylinkedlist();
		assertEquals(3, stackList.topElement());
	}
}

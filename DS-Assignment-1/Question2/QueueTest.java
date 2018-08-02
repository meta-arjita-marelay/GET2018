package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

import Question1.StackByArray;

public class QueueTest {

	@Test
	public void testArrayInsertPositive() {
		QueuebyArray queueArray = new QueuebyArray();
		assertEquals(true, queueArray.insert(2));
	}

	@Test(expected = AssertionError.class)
	public void testArrayInsertNegative() {
		QueuebyArray queueArray = new QueuebyArray();
		queueArray.insert(2);
		queueArray.insert(3);
		assertEquals(true, queueArray.insert(2));
	}

	@Test
	public void testArrayDeletePositive() {
		QueuebyArray queueArray = new QueuebyArray();
		queueArray.insert(2);
		queueArray.insert(3);
		assertEquals(2, queueArray.delete());
	}

	@Test(expected = AssertionError.class)
	public void testArrayDeleteNegative() {
		QueuebyArray queueArray = new QueuebyArray();
		assertEquals(3, queueArray.delete());
	}

	@Test
	public void testArrayEmptyPositive() {
		QueuebyArray queueArray = new QueuebyArray();
		assertEquals(true, queueArray.isEmpty());
	}

	@Test
	public void testArrayEmptyNegative() {
		QueuebyArray queueArray = new QueuebyArray();
		queueArray.insert(2);
		queueArray.insert(3);
		assertNotEquals(true, queueArray.isEmpty());
	}

	@Test
	public void testArrayFullPositive() {
		QueuebyArray queueArray = new QueuebyArray();
		queueArray.insert(2);
		queueArray.insert(3);
		assertEquals(true, queueArray.isQueueFull());
	}

	@Test
	public void testArrayFullNegative() {
		QueuebyArray queueArray = new QueuebyArray();
		queueArray.insert(2);
		assertNotEquals(true, queueArray.isQueueFull());
	}

	@Test
	public void testLinkedListInsertPositive() {
		QueueByLinkedlist queueList = new QueueByLinkedlist();
		assertEquals(true, queueList.insert(2));
	}

	@Test
	public void testLinkedListDeletePositive() {
		QueueByLinkedlist queueList = new QueueByLinkedlist();
		queueList.insert(2);
		queueList.insert(3);
		assertEquals(2, queueList.delete());
	}

	@Test(expected = AssertionError.class)
	public void testLinkedListDeleteNegative() {
		QueueByLinkedlist queueList = new QueueByLinkedlist();
		assertEquals(2, queueList.delete());
	}

	@Test
	public void testLinkedListEmptyPositive() {
		QueueByLinkedlist queueList = new QueueByLinkedlist();
		assertEquals(true, queueList.isEmpty());
	}

	@Test
	public void testLinkedListEmptyNegative() {
		QueueByLinkedlist queueList = new QueueByLinkedlist();
		queueList.insert(2);
		queueList.insert(3);
		assertNotEquals(true, queueList.isEmpty());
	}
}

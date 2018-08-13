package CircularQueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void testArrayInsertPositive() {
		CircularQueue queueArray = new CircularQueue();
		assertEquals(true, queueArray.insert(2));
	}

	@Test(expected = AssertionError.class)
	public void testArrayInsertNegative() {
		CircularQueue queueArray = new CircularQueue();
		queueArray.insert(2);
		queueArray.insert(3);
		assertEquals(true, queueArray.insert(2));
	}

	@Test
	public void testArrayDeletePositive() {
		CircularQueue queueArray = new CircularQueue();
		queueArray.insert(2);
		queueArray.insert(3);
		assertEquals(2, queueArray.delete());
	}

	@Test(expected = AssertionError.class)
	public void testArrayDeleteNegative() {
		CircularQueue queueArray = new CircularQueue();
		assertEquals(3, queueArray.delete());
	}

	@Test
	public void testArrayEmptyPositive() {
		CircularQueue queueArray = new CircularQueue();
		assertEquals(true, queueArray.isEmpty());
	}

	@Test
	public void testArrayEmptyNegative() {
		CircularQueue queueArray = new CircularQueue();
		queueArray.insert(2);
		queueArray.insert(3);
		assertNotEquals(true, queueArray.isEmpty());
	}

	@Test
	public void testArrayFullPositive() {
		CircularQueue queueArray = new CircularQueue();
		queueArray.insert(2);
		queueArray.insert(3);
		assertEquals(true, queueArray.isQueueFull());
	}

	@Test
	public void testArrayFullNegative() {
		CircularQueue queueArray = new CircularQueue();
		queueArray.insert(2);
		assertNotEquals(true, queueArray.isQueueFull());
	}
}

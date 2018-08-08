package Question2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	PriorityQueueArray priorityQueue;

	@Test
	public void test() throws QueueFull, QueueEmpty {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1)));
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}

	@Test(expected = QueueFull.class)
	public void testQueueFull() throws QueueFull, QueueEmpty {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1)));
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}

	@Test(expected = QueueEmpty.class)
	public void testQueueEmpty() throws QueueFull, QueueEmpty {
		priorityQueue = new PriorityQueueArray(4);

		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 3)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(2, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

		assertTrue(priorityQueue.enqueue(new Job(3, 1)));
		assertTrue(priorityQueue.enqueue(new Job(5, 2)));
		assertTrue(priorityQueue.enqueue(new Job(4, 3)));
		assertTrue(priorityQueue.enqueue(new Job(6, 4)));
		assertEquals(6, priorityQueue.dequeue().getValue());
		assertEquals(4, priorityQueue.dequeue().getValue());
		assertTrue(priorityQueue.enqueue(new Job(7, 1)));
		assertTrue(priorityQueue.enqueue(new Job(2, 2)));
		assertEquals(5, priorityQueue.dequeue().getValue());
		assertEquals(3, priorityQueue.dequeue().getValue());

	}
}

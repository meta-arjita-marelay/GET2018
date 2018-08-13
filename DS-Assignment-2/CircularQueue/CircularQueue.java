package CircularQueue;

import Question2.*;

/**
 * CircularQueue implements Queue interface and will give definitions of method
 * included in Queue using array
 * 
 * @author Arjita
 *
 * @param <E>
 *            is used to maintain the generic behaviour
 */
public class CircularQueue<E> implements Queue<E> {
	private static final int MAX = 2;// queue array size
	@SuppressWarnings("unchecked")
	private E[] array = (E[]) new Object[MAX];// queue array
	private int end;// index of last element
	private int front;// index of first element

	/**
	 * constructor to initialise the private members
	 */
	CircularQueue() {
		end = -1;
		front = -1;
	}

	@Override
	public boolean insert(E element) {
		if (isQueueFull()) {
			throw new AssertionError("queue full");
		} else if (front == -1) {
			front++;
		} else if (end == MAX - 1 && front != 0) {
			end = -1;
		}
		end++;
		array[end] = element;
		return true;
	}

	@Override
	public E delete() {
		if (isEmpty()) {
			throw new AssertionError("queue empty");
		}
		E element = array[front];
		if (front == end) {
			front = -1;
			end = -1;
		} else if (front == MAX - 1) {
			front = 0;
		} else {
			front++;
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (front == -1);
	}

	/**
	 * isQueueFull will check if queue array has reached its maximum limit
	 * 
	 * @return true if queue array is full else false
	 */
	public boolean isQueueFull() {
		return ((front == 0 && end == MAX - 1) || (front - end == 1));
	}
}

package Question2;

/**
 * QueuebyArray implements Queue interface and will give definitions of method
 * included in Queue using array
 * 
 * @author Arjita
 *
 */
public class QueuebyArray<E> implements Queue<E> {
	private static final int MAX = 2;// queue array size
	private E[] array =(E[]) new Object[MAX];// queue array
	private int end;// index of last element
	private int front;//index of first element
	/**
	 * constructor to initialise the private members
	 */
	QueuebyArray() {
		end = -1;
		front=-1;
	}

	@Override
	public boolean insert(E element) {
		if (end == MAX - 1) {
			throw new AssertionError("queue full");
		}
		if(front==-1)
		{
			front++;
		}
		end++;
		array[end] = element;
		return true;
	}

	@Override
	public E delete() {
		if (end == -1) {
			throw new AssertionError("queue empty");
		}
		E element = array[front];
		front++;
		return element;
	}

	@Override
	public boolean isEmpty() {
		return (end < 0);
	}

	/**
	 * isQueueFull will check if queue array has reached its maximum limit
	 * 
	 * @return true if queue array is full else false
	 */
	public boolean isQueueFull() {
		return (end >= MAX - 1);
	}
}

package Question2;

/**
 * QueuebyArray implements Queue interface and will give definitions of method
 * included in Queue using array
 * 
 * @author Arjita
 *
 */
public class QueuebyArray implements Queue {
	private static final int MAX = 2;// queue array size
	private int[] array = new int[MAX];// queue array
	private int end;// index of last element

	/**
	 * constructor to initialise the private members
	 */
	QueuebyArray() {
		end = -1;
	}

	@Override
	public boolean insert(int element) {
		if (end == MAX - 1) {
			throw new AssertionError("queue full");
		}
		end++;
		array[end] = element;
		return true;
	}

	@Override
	public int delete() {
		if (end == -1) {
			throw new AssertionError("queue empty");
		}
		int element = array[0];
		for (int i = 0; i < end; i++) {
			array[i] = array[i + 1];
		}
		end--;
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

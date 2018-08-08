package Question2;

/**
 * PriorityQueueArray implements interface and defines the method present in
 * PriorityQueue interface
 * 
 * @author Arjita
 *
 */
public class PriorityQueueArray implements PriorityQueue {

	private Job[] queue;// queue array
	private int rear, front, maxSize;

	/**
	 * constructor of class
	 * 
	 * @param maxSize
	 *            size of queue array
	 */
	public PriorityQueueArray(int maxSize) {
		this.maxSize = maxSize;// size will be initialised
		queue = new Job[maxSize];// queue size will be allocated
		rear = -1;// rear initialisation
		front = -1;// front initialisation
	}

	@Override
	public boolean enqueue(Job job) throws QueueFull {

		if (!isFull()) {
			if (rear == -1) {
				front++;
				rear++;
			} else {
				rear = (rear + 1) % maxSize;
			}
			int pos = -1;
			for (int i = front; i <= (rear - 1) % maxSize; i++) {
				if (job.getPriority() > queue[i].getPriority()) {
					pos = i;
					break;
				}
			}
			if (pos != -1) {
				for (int i = (rear - 1) % maxSize; i >= pos; i--) {
					queue[(i + 1) % maxSize] = queue[i];
				}
				queue[pos] = job;
			} else
				queue[rear] = job;

		} else {
			throw new QueueFull("The queue is full!");
		}
		return true;

	}

	@Override
	public Job dequeue() throws QueueEmpty {
		Job job = null;

		if (!isEmpty()) {
			if (front == rear) {
				job = queue[front];
				front = -1;
				rear = -1;
			} else {
				job = queue[front];
				front = (front + 1) % maxSize;
			}
		} else {
			throw new QueueEmpty("The queue is empty!");
		}
		return job;
	}

	@Override
	public boolean isEmpty() {

		boolean isEmpty = false;

		if (rear == -1 && front == -1)
			isEmpty = true;

		return isEmpty;
	}

	@Override
	public boolean isFull() {

		return (rear + 1) % maxSize == front;
	}

}

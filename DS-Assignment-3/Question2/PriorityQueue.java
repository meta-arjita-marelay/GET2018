package Question2;

/**
 * PriorityQueue interface contains method declarations for different operations
 * to be performed in Queue
 * 
 * @author Arjita
 *
 */
public interface PriorityQueue {
	/**
	 * enqueue will insert Job object in queue
	 * 
	 * @param value
	 *            Job object that contains value and its priority
	 * @return true if value can be added to queue
	 * @throws QueueFull 
	 */
	public boolean enqueue(Job value) throws QueueFull;

	/**
	 * dequeue will delete job object from priority queue
	 * 
	 * @return job object which will be deleted
	 * @throws QueueEmpty 
	 */
	public Job dequeue() throws QueueEmpty;

	/**
	 * isEmpty will check if priority queue is empty or not
	 * 
	 * @return true if it is empty otherwise false
	 */
	public boolean isEmpty();

	/**
	 * isFull will check if priority queue is full or not
	 * 
	 * @return true if it is full otherwise false
	 */
	public boolean isFull();
}

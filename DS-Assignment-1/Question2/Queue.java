package Question2;

/**
 * Queue interface will contain declaration of all methods to be perform in
 * queue.
 * 
 * @author Arjita
 *
 */
public interface Queue {
	/**
	 * insert method will insert element in queue at last
	 * 
	 * @param element
	 *            which is to be inserted in queue
	 * @return true if it can be inserted else will throw error
	 */
	public boolean insert(int element);

	/**
	 * delete method will delete first element from queue
	 * 
	 * @return element which is deleted
	 */
	public int delete();

	/**
	 * isEmpty method will check if queue is empty
	 * 
	 * @return true if it is empty otherwise false
	 */
	public boolean isEmpty();
}

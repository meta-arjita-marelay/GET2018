package Question2;

/**
 * this error class will be called if user will try to add element in queue
 * which is already full
 * 
 * @author Arjita
 *
 */
public class QueueFull extends Exception {
	public QueueFull(String message) {
		super(message);
	}
}

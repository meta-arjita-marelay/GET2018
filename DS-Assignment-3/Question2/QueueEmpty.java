package Question2;
/**
 * this class will be called if user will try to delete element from empty queue 
 * @author Arjita
 *
 */
public class QueueEmpty extends Exception {
	public QueueEmpty(String message) {
		super(message);
	}
}

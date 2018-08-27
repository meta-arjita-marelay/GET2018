package Question2;
/**
 * Job will have value and priorities of value
 * @author Arjita
 *
 */
public class Job {

	final int value;
	final int priority;
	/**
	 * constructor for class
	 * @param value value which is to be stored
	 * @param priority priority of respective value
	 */
	public Job(int value, int priority) {
		
		this.value = value;
		this.priority = priority;
	}
	public int getValue() {
		return value;
	}

	public int getPriority() {
		return priority;
	}
	
	
}

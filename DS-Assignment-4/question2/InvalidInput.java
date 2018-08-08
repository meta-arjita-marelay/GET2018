package question2;

/**
 * InvalidInput is error class which will be called when user will enter null
 * string
 * 
 * @author Arjita
 *
 */
public class InvalidInput extends Exception {
	public InvalidInput(String message) {
		super(message);
	}
}

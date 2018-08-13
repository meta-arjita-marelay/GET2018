package Question1;
/**
 * InvalidInput is error class which will be called if input is invalid 
 * @author Arjita
 *
 */
@SuppressWarnings("serial")
public class InvalidInput extends Exception {
	public InvalidInput(String message) {
		super(message);
	}
}

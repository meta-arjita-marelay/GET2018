package question;

/**
 * CustomException is error class and will be called if element searched is not
 * present in tree
 * 
 * @author Arjita
 *
 */
@SuppressWarnings("serial")
public class CustomException extends Exception {
	public CustomException(String message) {
		super(message);
	}
}

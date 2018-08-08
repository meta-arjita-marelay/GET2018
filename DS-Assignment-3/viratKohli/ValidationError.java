package viratKohli;

/**
 * this class will be called if numOfBallsToBePlayed or numOfBowlers is negative
 * 
 * @author Arjita
 *
 */
public class ValidationError extends Exception {
	public ValidationError(String message) {
		super(message);
	}
}

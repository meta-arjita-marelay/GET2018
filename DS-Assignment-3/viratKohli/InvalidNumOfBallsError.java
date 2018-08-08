package viratKohli;

/**
 * this error class will be call if number of balls provided to bowler is zero
 * 
 * @author Arjita
 *
 */
public class InvalidNumOfBallsError extends Exception {
	public InvalidNumOfBallsError(String message) {
		super(message);
	}
}

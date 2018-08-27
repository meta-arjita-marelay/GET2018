package viratKohli;

/**
 * this error class will be called if if total number of balls to be thrown is
 * less than number of balls to be played
 * 
 * @author Arjita
 *
 */
public class LessNumOfBallsToBeThrown extends Exception {
	public LessNumOfBallsToBeThrown(String message) {
		super(message);
	}
}

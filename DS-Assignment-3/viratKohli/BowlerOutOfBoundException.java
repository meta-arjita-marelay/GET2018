package viratKohli;

/**
 * BowlerOutOfBoundException will be called when user try to insert number of
 * bowlers maximum than the given size of Bowlers list
 * 
 * @author Arjita
 *
 */
public class BowlerOutOfBoundException extends Exception {
	public BowlerOutOfBoundException(String message) {
		super(message);
	}
}

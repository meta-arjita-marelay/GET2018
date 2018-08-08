package viratKohli;

/**
 * Bowler contains the name and number of balls to be played by bowlers
 * 
 * @author Arjita
 *
 */
public class Bowler {
	String name;// name of bowler
	int numOfBalls;// number of balls to be thrown by bowler

	/**
	 * constructor
	 * 
	 * @param name
	 *            name of bowler
	 * @param numOfBalls
	 *            number of balls to be thrown by bowler
	 * @throws InvalidNumOfBallsError
	 *             if number of balls is zero
	 */
	public Bowler(String name, int numOfBalls) throws InvalidNumOfBallsError {
		if (numOfBalls == 0) {
			throw new InvalidNumOfBallsError("number of balls cannot be zero");
		}
		this.name = name;
		this.numOfBalls = numOfBalls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfBalls() {
		return numOfBalls;
	}

	public void setNumOfBalls(int numOfBalls) {
		this.numOfBalls = numOfBalls;
	}
}

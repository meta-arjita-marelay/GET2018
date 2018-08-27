package viratKohli;

import java.util.ArrayList;
import java.util.List;

/**
 * CricketMatch defines method which will help to solve a following question: A
 * cricket team is playing against Virat Kohli and we want him to score as low
 * as possible. Virat scores max runs of the bowler who has minimum balls left
 * to bowl.So we need a bowlers order such that Virat scores less run.
 * 
 * @author Arjita
 *
 */
public class CricketMatch {
	// bowlers list added by user
	private List<Bowler> bowlersList = new ArrayList<Bowler>();
	// bowlers order to be maintained
	private List<Bowler> bowlerOrder = new ArrayList<Bowler>();
	private int numOfBallsToBePlayed, numOfBowlers;

	/**
	 * constructor of class
	 * 
	 * @param numOfBallsToBePlayed
	 *            number of balls to be played by virat kohli
	 * @param numOfBowlers
	 *            number of bowlers which will throw the ball
	 * @throws ValidationError
	 *             if numOfBallsToBePlayed or numOfBowlers is negative
	 */
	public CricketMatch(int numOfBallsToBePlayed, int numOfBowlers)
			throws ValidationError {
		if (checkValidation(numOfBallsToBePlayed, numOfBowlers)) {
			this.numOfBallsToBePlayed = numOfBallsToBePlayed;
			this.numOfBowlers = numOfBowlers;
		}

	}

	/**
	 * 
	 * @param numOfBallsToBePlayed
	 *            number of balls to be played by virat kohli
	 * @param numOfBowlers
	 *            number of bowlers which will throw the ball
	 * @return true if numOfBallsToBePlayed or numOfBowlers is positive
	 * @throws ValidationError
	 *             if numOfBallsToBePlayed or numOfBowlers is negative
	 */
	private boolean checkValidation(int numOfBallsToBePlayed, int numOfBowlers)
			throws ValidationError {
		if (numOfBallsToBePlayed > 0 && numOfBowlers > 0) {
			return true;
		} else {
			throw new ValidationError("invalid input");
		}
	}

	/**
	 * addBowler will add bowlers to bowlersList
	 * 
	 * @param bowler
	 *            bowler object to be added in list
	 * @throws BowlerOutOfBoundException
	 *             if number of bowlers maximum than the given size of Bowlers
	 *             list
	 */
	public void addBowler(Bowler bowler) throws BowlerOutOfBoundException {
		if (this.bowlersList.size() == numOfBowlers) {
			throw new BowlerOutOfBoundException("bowlers cannot be added");
		}
		this.bowlersList.add(bowler);
	}

	/**
	 * 
	 * @return list of bowlers in which they should be sent to Virat Kohli
	 * @throws InvalidNumOfBallsError
	 *             if number of balls provided to bowler is zero
	 * @throws LessNumOfBallsToBeThrown
	 *             if total number of balls to be thrown is less than number of
	 *             balls to be played
	 */
	public List<Bowler> choseBowler() throws InvalidNumOfBallsError,
			LessNumOfBallsToBeThrown {
		int turn;
		int totalBalls = totalnumOfBalls();// total number of balls to be thrown
		if (totalBalls < this.numOfBallsToBePlayed) {
			throw new LessNumOfBallsToBeThrown(
					"number of balls to be thrown is less than played");
		}
		while (this.numOfBallsToBePlayed != 0) {
			turn = maxBalls();// turn of bowler which have maximum balls left
			Bowler bowler = bowlersList.get(turn);// details of bowler
			// if there is no bowler in bowlerOrder list
			if (bowlerOrder.size() == 0) {
				bowlerOrder.add(new Bowler(bowler.getName(), 1));
			} else {
				int previousIndex = bowlerOrder.size() - 1;
				String previousBowlerName = bowlerOrder.get(previousIndex)
						.getName();
				// if last thrown ball is thrown by same bowler than simply
				// number of balls thrown will be incremented by one else bowler
				// details will be added to bowler order with thrown ball=1
				if (previousBowlerName.equals(bowler.getName())) {
					int ballsPlayed = bowlerOrder.get(previousIndex)
							.getNumOfBalls();
					bowlerOrder.get(previousIndex).setNumOfBalls(
							ballsPlayed + 1);
				} else {
					bowlerOrder.add(new Bowler(bowler.getName(), 1));
				}
			}
			// number of bowls bowler can play will be decremented for bowler
			bowler.setNumOfBalls(bowlersList.get(turn).getNumOfBalls() - 1);
			totalBalls--;
			this.numOfBallsToBePlayed--;
		}
		return bowlerOrder;
	}

	/**
	 * private helper method to calculate the total number of balls
	 * 
	 * @return total number of balls
	 */
	private int totalnumOfBalls() {
		int totalBalls = 0;
		for (Bowler bowler : bowlersList) {
			totalBalls += bowler.getNumOfBalls();
		}
		return totalBalls;
	}

	/**
	 * private helper method to find the bowler with maximum balls
	 * 
	 * @return index of bowler with maximum bowler
	 */
	private int maxBalls() {
		int max = 0;
		int i = 0, ballIndex = 0;
		for (Bowler bowler : bowlersList) {
			if (max < bowler.getNumOfBalls()) {
				max = bowler.getNumOfBalls();
				ballIndex = i;
			}
			i++;
		}
		return ballIndex;
	}
}

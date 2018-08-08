package viratKohli;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CricketMatchTest {

	@Test
	public void testBowlers() throws InvalidNumOfBallsError,
			BowlerOutOfBoundException, LessNumOfBallsToBeThrown,
			ValidationError {

		CricketMatch cricketmatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("arjita", 8);
		Bowler bowler2 = new Bowler("richa", 3);
		Bowler bowler3 = new Bowler("prakalpa", 1);
		cricketmatch.addBowler(bowler1);
		cricketmatch.addBowler(bowler2);
		cricketmatch.addBowler(bowler3);
		List<Bowler> resultActual = cricketmatch.choseBowler();
		for (Bowler bowler : resultActual) {
			System.out.print(bowler.getName());
			System.out.println(bowler.getNumOfBalls());
		}
		List<Bowler> resultExpected = new ArrayList<Bowler>();
		resultExpected.add(new Bowler("arjita", 6));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("prakalpa", 1));

		for (int i = 0; i < resultExpected.size(); i++) {
			assertEquals(resultExpected.get(i).getName(), resultActual.get(i)
					.getName());
			assertEquals(resultExpected.get(i).getNumOfBalls(), resultActual
					.get(i).getNumOfBalls());
		}

	}

	@Test(expected = InvalidNumOfBallsError.class)
	public void testBowlersInvalidNumOfBallsError()
			throws InvalidNumOfBallsError, BowlerOutOfBoundException,
			LessNumOfBallsToBeThrown, ValidationError {

		CricketMatch cricketmatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("arjita", 0);
		Bowler bowler2 = new Bowler("richa", 3);
		Bowler bowler3 = new Bowler("prakalpa", 1);
		cricketmatch.addBowler(bowler1);
		cricketmatch.addBowler(bowler2);
		cricketmatch.addBowler(bowler3);
		List<Bowler> resultActual = cricketmatch.choseBowler();
		for (Bowler bowler : resultActual) {
			System.out.print(bowler.getName());
			System.out.println(bowler.getNumOfBalls());
		}
		List<Bowler> resultExpected = new ArrayList<Bowler>();
		resultExpected.add(new Bowler("arjita", 6));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("prakalpa", 1));

		for (int i = 0; i < resultExpected.size(); i++) {
			assertEquals(resultExpected.get(i).getName(), resultActual.get(i)
					.getName());
			assertEquals(resultExpected.get(i).getNumOfBalls(), resultActual
					.get(i).getNumOfBalls());
		}

	}

	@Test(expected = BowlerOutOfBoundException.class)
	public void testBowlersBowlerOutOfBoundException()
			throws InvalidNumOfBallsError, BowlerOutOfBoundException,
			LessNumOfBallsToBeThrown, ValidationError {

		CricketMatch cricketmatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("arjita", 8);
		Bowler bowler2 = new Bowler("richa", 3);
		Bowler bowler3 = new Bowler("prakalpa", 1);
		Bowler bowler4 = new Bowler("prakalpa", 1);

		cricketmatch.addBowler(bowler1);
		cricketmatch.addBowler(bowler2);
		cricketmatch.addBowler(bowler3);
		cricketmatch.addBowler(bowler4);
		List<Bowler> resultActual = cricketmatch.choseBowler();
		for (Bowler bowler : resultActual) {
			System.out.print(bowler.getName());
			System.out.println(bowler.getNumOfBalls());
		}
		List<Bowler> resultExpected = new ArrayList<Bowler>();
		resultExpected.add(new Bowler("arjita", 6));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("prakalpa", 1));

		for (int i = 0; i < resultExpected.size(); i++) {
			assertEquals(resultExpected.get(i).getName(), resultActual.get(i)
					.getName());
			assertEquals(resultExpected.get(i).getNumOfBalls(), resultActual
					.get(i).getNumOfBalls());
		}

	}

	@Test(expected = ValidationError.class)
	public void testBowlersValidationError() throws InvalidNumOfBallsError,
			BowlerOutOfBoundException, LessNumOfBallsToBeThrown,
			ValidationError {

		CricketMatch cricketmatch = new CricketMatch(12, -1);
		Bowler bowler1 = new Bowler("arjita", 9);
		Bowler bowler2 = new Bowler("richa", 3);
		Bowler bowler3 = new Bowler("prakalpa", 1);

		cricketmatch.addBowler(bowler1);
		cricketmatch.addBowler(bowler2);
		cricketmatch.addBowler(bowler3);
		List<Bowler> resultActual = cricketmatch.choseBowler();
		for (Bowler bowler : resultActual) {
			System.out.print(bowler.getName());
			System.out.println(bowler.getNumOfBalls());
		}
		List<Bowler> resultExpected = new ArrayList<Bowler>();
		resultExpected.add(new Bowler("arjita", 6));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("prakalpa", 1));

		for (int i = 0; i < resultExpected.size(); i++) {
			assertEquals(resultExpected.get(i).getName(), resultActual.get(i)
					.getName());
			assertEquals(resultExpected.get(i).getNumOfBalls(), resultActual
					.get(i).getNumOfBalls());
		}
	}

	@Test(expected = LessNumOfBallsToBeThrown.class)
	public void testBowlersLessNumOfBallsToBeThrown()
			throws InvalidNumOfBallsError, BowlerOutOfBoundException,
			LessNumOfBallsToBeThrown, ValidationError {

		CricketMatch cricketmatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("arjita", 2);
		Bowler bowler2 = new Bowler("richa", 3);
		Bowler bowler3 = new Bowler("prakalpa", 1);

		cricketmatch.addBowler(bowler1);
		cricketmatch.addBowler(bowler2);
		cricketmatch.addBowler(bowler3);
		List<Bowler> resultActual = cricketmatch.choseBowler();
		for (Bowler bowler : resultActual) {
			System.out.print(bowler.getName());
			System.out.println(bowler.getNumOfBalls());
		}
		List<Bowler> resultExpected = new ArrayList<Bowler>();
		resultExpected.add(new Bowler("arjita", 6));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("arjita", 1));
		resultExpected.add(new Bowler("richa", 1));
		resultExpected.add(new Bowler("prakalpa", 1));

		for (int i = 0; i < resultExpected.size(); i++) {
			assertEquals(resultExpected.get(i).getName(), resultActual.get(i)
					.getName());
			assertEquals(resultExpected.get(i).getNumOfBalls(), resultActual
					.get(i).getNumOfBalls());
		}
	}
}

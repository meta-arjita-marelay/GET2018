package PostfixQuestion;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvalTest {
	
	@Test
	public void testSingleDigit() {
		PostfixEval postfixEval = new PostfixEval("2 3 1 * + 9 -");
		assertEquals(-4, postfixEval.expressionEval(), 0.0);
	}

	@Test
	public void testMultipleValueDigit() {
		PostfixEval postfixEval = new PostfixEval("100 200 + 2 / 5 * 7 +");
		assertEquals(757, postfixEval.expressionEval(), 0.0);
	}

	@Test(expected = AssertionError.class)
	public void testErrorInPop() {
		PostfixEval postfixEval = new PostfixEval("200 + 2 / 5 * 7 +");
		assertEquals(757, postfixEval.expressionEval(), 0.0);
	}

	@Test(expected = AssertionError.class)
	public void testErrorInDivision() {
		PostfixEval postfixEval = new PostfixEval("100 200 + 0 / 5 * 7 +");
		assertEquals(757, postfixEval.expressionEval(), 0.0);
	}

	@Test(expected = AssertionError.class)
	public void testErrorInvalidExpression() {
		PostfixEval postfixEval = new PostfixEval("100 200 & 2 / 5 * 7 +");
		assertEquals(757, postfixEval.expressionEval(), 0.0);
	}

	@Test(expected = AssertionError.class)
	public void testErrorMoreElementsInResultStack() {
		PostfixEval postfixEval = new PostfixEval("100 200 200 & 2 / 5 * 7 +");
		assertEquals(757, postfixEval.expressionEval(), 0.0);
	}
}

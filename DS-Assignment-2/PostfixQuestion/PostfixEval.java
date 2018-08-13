package PostfixQuestion;

//Question1 contains methods for implementation of stack
import Question1.*;

/**
 * PostfixEval contains method to evaluate postfix expression using stack
 * 
 * @author Arjita
 *
 */
public class PostfixEval {
	// stack used to evaluate postfix expression
	StackBylinkedlist<Double> stack = new StackBylinkedlist<Double>();
	// postfix expression will be set by user
	private String postfixExpression = "";

	/**
	 * constructor of class
	 * 
	 * @param postfixExpression
	 *            string to be evaluated
	 */
	public PostfixEval(String postfixExpression) {
		this.postfixExpression = postfixExpression;
	}

	/**
	 * expressionEval to evaluate postfix expression
	 * 
	 * @return value after evaluating postfix expression
	 */
	public double expressionEval() {
		String array[] = postfixExpression.split("\\s+");
		for (String temp : array) {
			if (isDouble(temp)) {
				double value = Double.parseDouble(temp);
				stack.push(value);
			} else {
				double value1 = stack.pop();
				double value2 = stack.pop();
				switch (temp) {
				case "+":
					stack.push(value1 + value2);
					break;
				case "-":
					stack.push(value2 - value1);
					break;
				case "*":
					stack.push(value1 * value2);
					break;
				case "/":
					if (value1 == 0) {
						throw new AssertionError("invalid computations");
					}
					stack.push(value2 / value1);
					break;
				default:
					throw new AssertionError("invalid token");
				}
			}
		}
		if (stack.getSize() > 1) {
			throw new AssertionError("invalid expressions");
		}
		return stack.pop();
	}

	/**
	 * private helper method to check if string is double number or not
	 * 
	 * @param string
	 *            which is to be checked
	 * @return true if it is double otherwise false
	 */
	private boolean isDouble(String string) {
		try {
			Double.parseDouble(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

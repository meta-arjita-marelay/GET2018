package InfixToPostfix;

//Question1 package contains operations on stack
import Question1.*;

/**
 * InfixtoPostfix contains method which will convert infix expression to postfix
 * expression.
 * 
 * @author Arjita
 *
 */
public class InfixToPostfix {
	// stack that will be used in conversion
	StackBylinkedlist<String> stack = new StackBylinkedlist<String>();
	// input infix expression that is to be converted in postfix expression
	private String infixExpression = "";
	// postfixExpression will store the resultant postfix expression after
	// conversion
	private String postfixExpression = "";

	/**
	 * Constructor
	 * 
	 * @param infixExpression
	 *            input expression
	 */
	public InfixToPostfix(String infixExpression) {
		System.out.println("hi");
		this.infixExpression = infixExpression;
	}

	/**
	 * infixtoPostfix will convert infix expression to postfix expression using
	 * stack
	 * 
	 * @return postfix expression after conversion
	 */
	public String infixToPostfix() {
		// array to store elements after splitting them through whitespaces
		String array[] = infixExpression.split("\\s+");
		// loop for checking all elements
		for (String temp : array) {
			if (temp == "(") {
				stack.push(temp);
			} else if (temp == ")") {
				while (!stack.isEmpty() && stack.topElement() != "(") {
					postfixExpression += stack.pop();
				}
				if (!stack.isEmpty() && stack.topElement() != "(") {
					throw new AssertionError("invalid expression");
				}
				stack.pop();
			} else if (isOperator(temp)) {
				while (!stack.isEmpty()
						&& getPrecedence(temp) > getPrecedence(stack
								.topElement())) {
					postfixExpression += temp;
				}
				stack.push(temp);
			} else {
				postfixExpression += temp;
			}
		}
		while (!stack.isEmpty()) {
			postfixExpression += stack.pop();
		}
		System.out.println(postfixExpression);
		return postfixExpression;
	}

	/**
	 * private helper method for getting precedence of operators 1 means higher
	 * precedence
	 * 
	 * @param operator
	 *            operator whose precedence is to be checked
	 * @return precedence of operator
	 */
	private int getPrecedence(String operator) {
		switch (operator) {
		case "!":
			return 1;
		case "*":
		case "/":
			return 2;
		case "+":
		case "-":
			return 3;
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 4;
		case "==":
		case "!=":
			return 5;
		case "&&":
			return 6;
		case "||":
			return 7;
		default:
			return -1;
		}
	}

	/**
	 * isOperator will check if passed string is operator
	 * 
	 * @param operator
	 *            string which is to be checked
	 * @return true if operator else false
	 */
	private boolean isOperator(String operator) {
		switch (operator) {
		case "!":
		case "*":
		case "/":
		case "+":
		case "-":
		case "<":
		case ">":
		case "<=":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
			return true;
		default:
			return false;
		}
	}
}

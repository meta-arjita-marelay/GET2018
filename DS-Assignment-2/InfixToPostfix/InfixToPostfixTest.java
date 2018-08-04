package InfixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {

	@Test
	public void testWithBrackets() {
		InfixToPostfix infixToPostfix = new InfixToPostfix("( ( A + B ) — C * ( D / E ) ) + F");
		String result=infixToPostfix.infixToPostfix();
		assertEquals(result,"AB+CDE/*-F+");
	}
	@Test
	public void testWithoutBrackets() {
		InfixToPostfix infixToPostfix = new InfixToPostfix("A + B — C * D / E + F");
		String result=infixToPostfix.infixToPostfix();
		assertEquals(result,"AB+CDE/*-F+");
	}
	@Test(expected=AssertionError.class)
	public void testError() {
		InfixToPostfix infixToPostfix = new InfixToPostfix("A + B — C * D / E + F");
		String result=infixToPostfix.infixToPostfix();
		assertEquals(result,"AB+CDE/*-F+");
	}
}

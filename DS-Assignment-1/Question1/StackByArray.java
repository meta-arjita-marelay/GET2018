package Question1;

/**
 * StackByArray implements stack interface and will give definitions of method
 * included in stack using array
 * 
 * @author Arjita
 *
 */
public class StackByArray<E> implements Stack<E> {
	private static final int MAX = 2;// length of stack
	private E[] array =(E[]) new Object[MAX];// stack array declaration
	private int top;// top index of stack

	/**
	 * constructor to initialise the private members
	 */
	StackByArray() {
		top = -1;
	}

	@Override
	public boolean push(E element) {
		if (top >= (MAX - 1)) {
			throw new AssertionError("stack full");
		}
		array[++top] = element;
		return true;

	}

	@Override
	public E pop() {
		if (top < 0) {
			throw new AssertionError("stack empty");
		}
		E x = array[top--];
		return x;

	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public E topElement() {
		if (top == -1) {
			throw new AssertionError("stack empty");
		}
		return array[top];
	}

}

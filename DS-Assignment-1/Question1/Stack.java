package Question1;

/**
 * Stack will contain declaration of all methods to be perform in stack.
 * 
 * @author Arjita
 *
 */
public interface Stack<E> {
	/**
	 * push method will add an element to stack
	 * 
	 * @param element
	 *            value which is to be pushed
	 * @return true if it can be pushed otherwise will throw error
	 */
	public boolean push(E element);

	/**
	 * pop method will delete the element from stack
	 * 
	 * @return element which is deleted
	 */
	public E pop();

	/**
	 * isEmpty method will check if stack is empty
	 * 
	 * @return true if stack is empty otherwise false
	 */
	public boolean isEmpty();

	/**
	 * topElement will do the peek operation in stack
	 * 
	 * @return top element of stack
	 */
	public E topElement();
}

package Question1;

import linkedListNode.*;

/**
 * StackBylinkedlist implements stack interface and will give definitions of
 * method included in stack using linked list
 * 
 * @author Arjita
 *
 */
public class StackBylinkedlist implements Stack {
	private Node top;// pointer to store top element of stack

	/**
	 * constructor to initialise the top node
	 */
	StackBylinkedlist() {
		top = null;
	}

	@Override
	public boolean push(int element) {
		Node node = new Node(element, null);
		if (top == null)
			top = node;
		else {
			node.setLink(top);
			top = node;
		}
		return true;
	}

	@Override
	public int pop() {
		if (isEmpty()) {
			throw new AssertionError("No element exist in stack");
		}
		Node ptr = top;
		top = ptr.getLink();
		return ptr.getData();
	}

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	@Override
	public int topElement() {
		if (isEmpty()) {
			throw new AssertionError("No element exist in stack");
		}
		return top.getData();
	}

}

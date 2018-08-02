package Question2;

import linkedListNode.*;

/**
 * QueueByLinkedlist implements Queue interface and will give definitions of
 * method included in Queue using linked list
 * 
 * @author Arjita
 *
 */
public class QueueByLinkedlist implements Queue {
	Node front, rear;// node references to front and last elemnt of queue

	/**
	 * constructor to initialise the private members of class
	 */
	public QueueByLinkedlist() {
		front = rear = null;
	}

	@Override
	public boolean insert(int element) {
		Node node = new Node(element, null);
		if (isEmpty()) {
			front = node;
			rear = node;
		} else {
			rear.setLink(node);
			rear = node;
		}
		return true;
	}

	@Override
	public int delete() {
		if (isEmpty()) {
			throw new AssertionError("queue full");
		}
		int element = front.getData();
		front.setLink(front.getLink());
		return element;
	}

	@Override
	public boolean isEmpty() {

		return (front == null);
	}

}

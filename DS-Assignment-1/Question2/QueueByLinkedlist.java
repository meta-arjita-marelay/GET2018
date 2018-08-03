package Question2;

import linkedListNode.*;

/**
 * QueueByLinkedlist implements Queue interface and will give definitions of
 * method included in Queue using linked list
 * 
 * @author Arjita
 *
 */
public class QueueByLinkedlist<E> implements Queue<E> {
	Node front, rear;// node references to front and last elemnt of queue

	/**
	 * constructor to initialise the private members of class
	 */
	public QueueByLinkedlist() {
		front = rear = null;
	}

	@Override
	public boolean insert(E element) {
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
	public E delete() {
		if (isEmpty()) {
			throw new AssertionError("queue full");
		}
		E element = ((E)front.getData());
		front.setLink(front.getLink());
		return element;
	}

	@Override
	public boolean isEmpty() {

		return (front == null);
	}

}

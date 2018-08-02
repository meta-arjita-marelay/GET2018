package linkedListNode;

/**
 * Node represent a single node of linked list.
 * 
 * @author Arjita
 *
 */
public class Node<E> {
	private E data;// element value of node
	private Node link;// link stores the value of next node

	/**
	 * Constructor to initialize the private member
	 * 
	 * @param data
	 *            value to be stored in node
	 * @param link
	 *            pointer to store next node address
	 */
	public Node(E data, Node link) {
		this.data = data;
		this.link = link;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setLink(Node link) {
		this.link = link;
	}

	public E getData() {
		return data;
	}

	public Node getLink() {
		return link;
	}

}

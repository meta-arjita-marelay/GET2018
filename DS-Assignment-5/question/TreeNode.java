package question;

/**
 * TreeNode will contain data about binary search tree node and its left and
 * right child
 * 
 * @author Arjita
 *
 * @param <E>
 */
public class TreeNode<E> {
	private Node<E> node;// key and value of node
	private TreeNode<E> leftChild;// left child of node
	private TreeNode<E> rightChild;// right child of node

	/**
	 * constructor
	 * 
	 * @param key
	 *            key of node
	 * @param value
	 *            value of key
	 */
	public TreeNode(String key, E value) {
		this.node = new Node<E>(key, value);
		this.leftChild = null;
		this.rightChild = null;
	}

	public Node<E> getNode() {
		return node;
	}

	public void setNode(Node<E> node) {
		this.node = node;
	}

	public TreeNode<E> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<E> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<E> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<E> rightChild) {
		this.rightChild = rightChild;
	}

}

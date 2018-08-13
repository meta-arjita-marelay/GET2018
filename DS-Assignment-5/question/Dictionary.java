package question;

import java.util.List;

/**
 * Dictionary interface contains function to be performed in binary search tree
 * 
 * @author Arjita
 *
 * @param <E>
 */
public interface Dictionary<E> {
	/**
	 * addNode will add node in binary search tree
	 * 
	 * @param key
	 *            key of node
	 * @param value
	 *            value of key of respective node
	 */
	public void addNode(String key, E value);

	/**
	 * deleteNode will delete will node containing the respective key
	 * 
	 * @param key
	 *            key which is to be deleted
	 * @return root node after deletion
	 * @throws CustomException if key not present
	 */
	public TreeNode<E> deleteNode(String key) throws CustomException;

	/**
	 * getValue will find the value of respective key
	 * 
	 * @param key
	 *            key whose value is to be searched
	 * @return generic value of key
	 * @throws CustomException
	 *             if element is not found
	 */
	public E getValue(String key) throws CustomException;

	/**
	 * sortedOrder will sort the key of tree
	 * 
	 * @return list of nodes in sorted order
	 */
	public List<Node<E>> sortedOrder();

	/**
	 * sortBetweentwoKeyValue will sort the keys between two key values
	 * 
	 * @param key1
	 *            first key
	 * @param key2
	 *            second key
	 * @return sorted list of keys between key1 and key2
	 */
	public List<Node<E>> sortBetweenTwoKeyValue(String key1, String key2);
}

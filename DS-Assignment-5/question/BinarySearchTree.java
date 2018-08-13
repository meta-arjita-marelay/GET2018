package question;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * BinarySearchTree will define methods declared in Dictionary interface
 * 
 * @author Arjita
 *
 * @param <E>
 *            to make dictionary generic
 */
public class BinarySearchTree<E> implements Dictionary<E> {
	private TreeNode<E> root;
	private List<Node<E>> sortedOrder = new ArrayList<Node<E>>();
	private List<Node<E>> sortedBetweenTwoKeys = new ArrayList<Node<E>>();

	/**
	 * constructor of class
	 * 
	 * @param inputString
	 *            JSON file location
	 * @throws IOException
	 * @throws ParseException
	 *             if JSON couldn't be parsed
	 */
	@SuppressWarnings("unchecked")
	public BinarySearchTree(String inputString) throws ParseException,
			IOException {
		this.root = null;// root will be initialised
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader(inputString));
			JSONObject jsonObject = (JSONObject) object;
			// add nodes after parsing from JSON file
			for (Object key : jsonObject.keySet()) {
				addNode(key.toString(), (E) jsonObject.get(key).toString());
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("sorry file cannot be found");
		}
	}

	@Override
	public void addNode(String key, E value) {
		if(key==null|| value==null)
		{
			throw new AssertionError("invalid input");
		}
		root = addRecursive(root, key, value);
	}

	/**
	 * private helper method to recursively check child nodes in BST for
	 * addition of node
	 * 
	 * @param root
	 *            node whose child need to be added
	 * @param key
	 *            key which is to be added
	 * @param value
	 *            value of key which is to added
	 * @return root node
	 */
	private TreeNode<E> addRecursive(TreeNode<E> root, String key, E value) {
		if (root == null) {
			root = new TreeNode<E>(key, value);
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) > 0) {
			root.setRightChild(addRecursive(root.getRightChild(), key, value));
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) < 0) {
			root.setLeftChild(addRecursive(root.getLeftChild(), key, value));
		} else {
			throw new AssertionError("key cannot have same values");
		}
		return root;

	}

	@Override
	public TreeNode<E> deleteNode(String key) throws CustomException {
		root = deleteRecursive(root, key);
		return root;
	}

	/**
	 * private helper method for deletion of node which will run recursively
	 * 
	 * @param root
	 *            node which is to be checked
	 * @param key
	 *            key value which is to be deleted
	 * @return parent node
	 * @throws CustomException if key not present
	 */
	private TreeNode<E> deleteRecursive(TreeNode<E> root, String key) throws CustomException {
		if(root!=null)
		{
		TreeNode<E> tempTreeNode1 = null;
		if (key.equalsIgnoreCase(root.getNode().getKey())) {
			TreeNode<E> leftNode = root.getLeftChild();
			TreeNode<E> rightNode = root.getRightChild();
			if (leftNode == null && rightNode == null) {
				return null;
			} else if (leftNode == null) {
				return rightNode;
			} else if (rightNode == null) {
				return leftNode;
			} else {
				tempTreeNode1 = rightNode;
				while (tempTreeNode1.getLeftChild() != null) {
					tempTreeNode1 = tempTreeNode1.getLeftChild();
				}
				tempTreeNode1.setLeftChild(leftNode);
				return rightNode;
			}
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) > 0) {
			root.setRightChild(deleteRecursive(root.getRightChild(), key));
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) < 0) {
			root.setLeftChild(deleteRecursive(root.getLeftChild(), key));
		}
		return root;
		}
		throw new CustomException("value not found");
	}

	@Override
	public E getValue(String key) throws CustomException {
		E value = getValueRecursive(root, key);
		return value;
	}

	/**
	 * private helper method will help in finding key in tree and getting its
	 * value
	 * 
	 * @param root
	 *            node which is to be checked
	 * @param key
	 *            key whose value is to be found
	 * @return value of key
	 * @throws CustomException
	 *             if key does not exist
	 */
	private E getValueRecursive(TreeNode<E> root, String key)
			throws CustomException {
		if(root!=null)
		{
		if (key.equals(root.getNode().getKey())) {
			return root.getNode().getValue();
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) > 0) {
			return getValueRecursive(root.getRightChild(), key);
		} else if (key.compareToIgnoreCase(root.getNode().getKey()) < 0) {
			return getValueRecursive(root.getLeftChild(), key);
		}
		}
		throw new CustomException("no element found");
	}

	@Override
	public List<Node<E>> sortedOrder() {
		sortedOrderRecursively(this.root);
		return sortedOrder;
	}

	/**
	 * private helper method for getting sorted order recursively
	 * 
	 * @param root
	 *            node which is to be sorted
	 */
	private void sortedOrderRecursively(TreeNode<E> root) {
		if (root != null) {
			sortedOrderRecursively(root.getLeftChild());
			sortedOrder.add(root.getNode());
			sortedOrderRecursively(root.getRightChild());
		}
	}

	@Override
	public List<Node<E>> sortBetweenTwoKeyValue(String key1, String key2) {
		if (root == null) {
			throw new AssertionError("Empty tree");
		} else {
			if (key1.compareToIgnoreCase(key2) > 0) {
				throw new AssertionError("Enter valid set of keys");
			} else {
				sortBetweenTwoKeyValueRecursively(this.root, key1, key2);
				return sortedBetweenTwoKeys;
			}
		}
	}

	/**
	 * private helper method which will help sort keys between two given keys
	 * recursively
	 * 
	 * @param root
	 *            node which is to be checked
	 * @param key1
	 *            first key
	 * @param key2
	 *            second key
	 */
	private void sortBetweenTwoKeyValueRecursively(TreeNode<E> root,
			String key1, String key2) {
		if (root != null) {
			if (key1.compareToIgnoreCase(root.getNode().getKey()) < 0) {
				sortBetweenTwoKeyValueRecursively(root.getLeftChild(), key1,
						key2);
			}
			if (key1.compareToIgnoreCase(root.getNode().getKey()) <= 0
					&& key2.compareToIgnoreCase(root.getNode().getKey()) >= 0) {
				sortedBetweenTwoKeys.add(root.getNode());
			}
			if (key2.compareToIgnoreCase(root.getNode().getKey()) > 0) {
				sortBetweenTwoKeyValueRecursively(root.getRightChild(), key1,
						key2);
			}
		}

	}

	// display function
	public void display() {
		display(root);
	}

	// private helper method for display method which will be called
	// recursively
	private void display(TreeNode<E> root) {
		sortedOrderRecursively(root.getLeftChild());
		System.out.println(root.getNode());
		sortedOrderRecursively(root.getRightChild());
	}

}

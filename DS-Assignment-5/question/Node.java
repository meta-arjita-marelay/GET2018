package question;

/**
 * Node contains key and value of dictionary
 * 
 * @author Arjita
 *
 * @param <E>
 */
public class Node<E> {
	private String key;
	private E value;

	/**
	 * constructor
	 * 
	 * @param key
	 *            key of dictionary
	 * @param value
	 *            which store meaning of key
	 */
	public Node(String key, E value) {
		if(key==null || value==null)
		{
			throw new AssertionError("Inavlid input");
		}
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}
}

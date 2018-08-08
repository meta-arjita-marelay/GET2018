package question2;

import java.util.HashMap;
import java.util.Map;

/**
 * Cache contains hash map of string as key and number of unique characters in
 * it as its value and will store the input which can be used for further input
 * 
 * @author Arjita
 *
 */
public class Cache {
	// map declaration of cache
	private Map<String, Integer> cacheMemory = new HashMap<String, Integer>();

	public Map<String, Integer> getCacheMemory() {
		return cacheMemory;
	}

	/**
	 * saveStringResult will store result and string in cache map
	 * 
	 * @param string
	 *            string value which is to be stored as key
	 * @param result
	 *            number of unique characters in key
	 */
	public void saveStringResult(String string, int result) {
		cacheMemory.put(string, result);
	}

	/**
	 * ifStringPresent will check if key is already present in cache map
	 * 
	 * @param string
	 *            key which is to be checked in map
	 * @return true if it is present otherwise false
	 */
	public boolean ifStringPresent(String string) {
		return cacheMemory.containsKey(string);
	}

	/**
	 * resultOfString will return value of key value
	 * 
	 * @param string
	 *            key whose value is needed
	 * @return value of given key
	 */
	public int resultOfString(String string) {
		return cacheMemory.get(string);
	}
}
